import javafx.application.Application;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.lang.model.element.ElementVisitor;
import java.math.BigDecimal;

import static CalculationFormulas.AutoLoanCal.calculateTotalPrice;
import static CalculationFormulas.AutoLoanCal.calculateVehiclePrice;
import static CalculationFormulas.MortgageCal.calculateMonthlyPayment;


public class AutoLoan_Interface implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        //Create Main Window
        Stage AutoCal = new Stage();
        AutoCal.setTitle("Financial Calculator > Financial Calculator");

        //Background Panel creating
        AnchorPane stage = new AnchorPane();
        stage.setStyle("-fx-background-color: #F1E8E6");

        HBox stageDivide = new HBox();
        stageDivide.layout();
        stageDivide.setPrefSize(800.0,400.0);

        //I made another anchor to put my buttons
        AnchorPane leftAnchor = new AnchorPane();
        leftAnchor.setPrefSize(200.0,400.0);
        leftAnchor.setStyle("-fx-background-color: #361D32");

        //That was the my button layout
        VBox primaryBtnList = new VBox();
        primaryBtnList.layout();
        primaryBtnList.setPrefSize(200.0,400.0);

        AnchorPane rightAnchor = new AnchorPane();
        rightAnchor.setPrefSize(560.0,350.0);
        rightAnchor.setStyle("-fx-background-color: #F1E8E6");

        HBox loanCal_Content = new HBox();
        loanCal_Content.layout();
        loanCal_Content.setLayoutX(20.0);
        loanCal_Content.setLayoutY(25.0);
        loanCal_Content.setStyle("-fx-background-color: #FFFF");


        //Total Price cal Vbox

        VBox loanCal_conInputs_totalPrice = new VBox();
        loanCal_conInputs_totalPrice.layout();
        loanCal_conInputs_totalPrice.setPrefSize(300.0,350.0);

        //Monthly Payment cal Vbox

        VBox loanCal_conInputs_monthPay = new VBox();
        loanCal_conInputs_monthPay.layout();
        loanCal_conInputs_monthPay.setPrefSize(300.0,350.0);

        //Create tabPane and Tabs

        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        Tab tabTotalCal = new Tab("Total Price");
        AnchorPane ancTotalCal = new AnchorPane();

        Tab tabMonthCal = new Tab("Monthly Payment");
        AnchorPane ancMonthCal = new AnchorPane();

        ancTotalCal.getChildren().add(loanCal_conInputs_totalPrice);
        ancMonthCal.getChildren().add(loanCal_conInputs_monthPay);

        tabTotalCal.setContent(ancTotalCal);
        tabMonthCal.setContent(ancMonthCal);
        tabPane.getTabs().addAll(tabTotalCal,tabMonthCal);






        VBox loanCal_conInputs = new VBox();
        loanCal_conInputs.layout();
        loanCal_conInputs.setPrefSize(300.0,350.0);
        loanCal_conInputs.getChildren().add(tabPane);




        VBox loanCal_conOutputs = new VBox();
        loanCal_conOutputs.layout();
        loanCal_conOutputs.setPrefSize(260.0,350.0);
        loanCal_conOutputs.setStyle("-fx-background-color: #EDD2CB");

        stage.getChildren().addAll(stageDivide);
        stageDivide.getChildren().addAll(leftAnchor,rightAnchor);
        rightAnchor.getChildren().add(loanCal_Content);

        leftAnchor.getChildren().add(primaryBtnList);
        loanCal_Content.getChildren().addAll(loanCal_conInputs,loanCal_conOutputs);



        //Main Logo and Button List

        Pane logo = new Pane();
        logo.setPrefSize(200.0,100.0);

        Image logoPNG = new Image("calLogo.png");
        ImageView logoView = new ImageView(logoPNG);
        logoView.setX(16.0);
        logoView.setY(25.0);
        logoView.setFitHeight(100.0);
        logoView.setFitWidth(160.0);
        logoView.setPreserveRatio(true);

        logo.getChildren().add(logoView);

        //Create my Primary buttons to traveling different Calculators in my app
        Button btnFinancialCal = new Button("Financial Calculator");
        btnFinancialCal.setId("btnFinancialCal");
        btnFinancialCal.setPrefSize(200.0,50.0);
        btnFinancialCal.setOnAction(new Financial_Interface());

        Button btnAutoLoanCal = new Button("Loan Calculator");
        btnAutoLoanCal.setId("btnAutoLoanCal");
        btnAutoLoanCal.setPrefSize(200.0,50.0);

        Button btnMortgageCal = new Button("Mortgage Calculator");
        btnMortgageCal.setId("btnMortgageCal");
        btnMortgageCal.setPrefSize(200.0,50.0);
        btnMortgageCal.setOnAction(new Mortgage_Interface());


        primaryBtnList.getChildren().addAll(
                logo,btnFinancialCal,btnAutoLoanCal,btnMortgageCal);




        //Content of Tab Total Price

        GridPane gridTabTotal = new GridPane();
        gridTabTotal.setPadding(new Insets(40,10,10,30));
        gridTabTotal.setVgap(8);
        gridTabTotal.setHgap(10);

        //Get home price inputs
        Label labAutoPrice = new Label("Auto Price");
        GridPane.setConstraints(labAutoPrice, 0, 0);
        TextField txtAutoPrice = new TextField();
        txtAutoPrice.setPromptText("$");
        GridPane.setConstraints(txtAutoPrice, 1, 0);


        //Get Down Payment inputs
        Label labDownPay = new Label("Down Payment");
        GridPane.setConstraints(labDownPay, 0, 1);
        TextField txtDownPay = new TextField();
        txtDownPay.setPromptText("$");
        GridPane.setConstraints(txtDownPay, 1, 1);


        //Get Loan Term inputs
        Label labLoanTerm = new Label("Loan Term");
        GridPane.setConstraints(labLoanTerm, 0, 2);
        TextField txtLoanTerm = new TextField();
        txtLoanTerm.setPromptText("months");
        GridPane.setConstraints(txtLoanTerm, 1, 2);


        //Get Interest Rate inputs
        Label labIntRate = new Label("Interest Rate");
        GridPane.setConstraints(labIntRate, 0, 3);
        TextField txtIntRate = new TextField();
        txtIntRate.setPromptText("0.0%");
        GridPane.setConstraints(txtIntRate, 1, 3);

        gridTabTotal.getChildren().addAll(
                labAutoPrice,txtAutoPrice,
                labDownPay,txtDownPay,
                labLoanTerm,txtLoanTerm,
                labIntRate,txtIntRate);


        //Error massages
        Pane errorForTotalTab = new Pane();
        Label labError = new Label("");
        labError.setId("labError");
        labError.setLayoutX(30.0);
        labError.setLayoutY(60.0);
        errorForTotalTab.getChildren().add(labError);

        Pane subButtons_Total = new Pane();

        Button btnMortInputsSubmit_Total = new Button("Calculate");
        btnMortInputsSubmit_Total.setPrefSize(220.0,40.0);
        btnMortInputsSubmit_Total.setLayoutX(79.0);
        btnMortInputsSubmit_Total.setLayoutY(20.0);
        btnMortInputsSubmit_Total.setId("btnMortInputsSubmit");

        subButtons_Total.getChildren().addAll(btnMortInputsSubmit_Total);

        loanCal_conInputs_totalPrice.getChildren().addAll(
                gridTabTotal,errorForTotalTab,subButtons_Total);





        //Content of Tab Monthly Payment

        GridPane gridTabMonth = new GridPane();
        gridTabMonth.setPadding(new Insets(40,10,10,30));
        gridTabMonth.setVgap(8);
        gridTabMonth.setHgap(10);

        //Get home price inputs
        Label labMonthlyPay = new Label("Monthly Pay");
        GridPane.setConstraints(labMonthlyPay, 0, 0);
        TextField txtMonthlyPay = new TextField();
        txtMonthlyPay.setPromptText("$");
        GridPane.setConstraints(txtMonthlyPay, 1, 0);


        //Get Down Payment inputs
        Label labDownPay2 = new Label("Down Payment");
        GridPane.setConstraints(labDownPay2, 0, 1);
        TextField txtDownPay2 = new TextField();
        txtDownPay2.setPromptText("$");
        GridPane.setConstraints(txtDownPay2, 1, 1);


        //Get Loan Term inputs
        Label labLoanTerm2 = new Label("Loan Term");
        GridPane.setConstraints(labLoanTerm2, 0, 2);
        TextField txtLoanTerm2 = new TextField();
        txtLoanTerm2.setPromptText("months");
        GridPane.setConstraints(txtLoanTerm2, 1, 2);


        //Get Interest Rate inputs
        Label labIntRate2 = new Label("Interest Rate");
        GridPane.setConstraints(labIntRate2, 0, 3);
        TextField txtIntRate2 = new TextField();
        txtIntRate2.setPromptText("0.0%");
        GridPane.setConstraints(txtIntRate2, 1, 3);

        gridTabMonth.getChildren().addAll(
                labMonthlyPay,txtMonthlyPay,
                labDownPay2,txtDownPay2,
                labLoanTerm2,txtLoanTerm2,
                labIntRate2,txtIntRate2);


        //Error massages
        Pane errorForMonthTab = new Pane();
        Label labError2 = new Label("");
        labError2.setId("labError");
        labError2.setLayoutX(30.0);
        labError2.setLayoutY(60.0);
        errorForMonthTab.getChildren().add(labError2);

        Pane subButtons_Month = new Pane();

        Button btnMortInputsSubmit_Month = new Button("Calculate");
        btnMortInputsSubmit_Month.setPrefSize(220.0,40.0);
        btnMortInputsSubmit_Month.setLayoutX(79.0);
        btnMortInputsSubmit_Month.setLayoutY(20.0);
        btnMortInputsSubmit_Month.setId("btnMortInputsSubmit");

        subButtons_Month.getChildren().addAll(btnMortInputsSubmit_Month);

        loanCal_conInputs_monthPay.getChildren().addAll(
                gridTabMonth,errorForMonthTab,subButtons_Month);





        //Result(Output Table)

        Pane headingBackgroundResult = new Pane();
        headingBackgroundResult.setPrefSize(200.0,40.0);
        headingBackgroundResult.setStyle("-fx-background-color: #F55951");

        Label mort_headingResult = new Label("Result");
        mort_headingResult.setId("labMortHResult");
        mort_headingResult.setLayoutX(30.0);
        mort_headingResult.setLayoutY(10.0);

        headingBackgroundResult.getChildren().add(mort_headingResult);

        Pane mainResultBackground = new Pane();
        mainResultBackground.setPrefSize(200.0,30.0);
        mainResultBackground.setLayoutY(50.0);
        mainResultBackground.setStyle("-fx-background-color: #EF9F9B");

        Label labFinalResult = new Label("Monthly Pay:  $12,323.00");
        labFinalResult.setId("mainResult");
        labFinalResult.setLayoutX(30.0);
        labFinalResult.setLayoutY(5.0);

        mainResultBackground.getChildren().add(labFinalResult);



        loanCal_conOutputs.getChildren().addAll(
                headingBackgroundResult,
                mainResultBackground);



        Scene scene = new Scene(stage, 800, 400);
        AutoCal.setResizable(false);
        AutoCal.setScene(scene);
        AutoCal.show();
        Stage previousStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        previousStage.close();

        scene.getStylesheets().add("CSS/autoLoan_interface.css");

        btnMortInputsSubmit_Total.setOnAction(e->{
            labError.setText("");
            double loanAmount = 0;
            try{
                loanAmount = Double.parseDouble(txtAutoPrice.getText());
            } catch (NumberFormatException ex){
                labError.setText("Error: Please provide a positive Auto price value.");
            }

            double loanTerm = 0;
            try{
                loanTerm = Double.parseDouble(txtLoanTerm.getText());
            } catch (NumberFormatException ex){
                labError.setText("Error: Please provide a positive down payment with \n" +
                        "\t  value between 0 and 100.");
                labError.setLayoutY(40.0);
            }
            double downPay = 0;
            try{
                downPay = Double.parseDouble(txtDownPay.getText());
            } catch (NumberFormatException ex){
                labError.setText("Error: Please provide a positive loan term value.");
            }

            double intRate = 0;
            try{
                intRate = Double.parseDouble(txtIntRate.getText());
            } catch (NumberFormatException ex){
                labError.setText("Please provide a positive interest value.");
            }
            BigDecimal monthlyPay = calculateTotalPrice(loanAmount,loanTerm,intRate,downPay);
            labFinalResult.setText("Monthly Pay:  $"+monthlyPay);
        });

        btnMortInputsSubmit_Month.setOnAction(e->{
            labError2.setText("");
            double loanAmount = 0;
            try{
                loanAmount = Double.parseDouble(txtMonthlyPay.getText());
            } catch (NumberFormatException ex){
                labError2.setText("Error: Please provide a positive Monthly Payment value.");
            }

            double loanTerm = 0;
            try{
                loanTerm = Double.parseDouble(txtLoanTerm.getText());
            } catch (NumberFormatException ex){
                labError2.setText("Error: Please provide a positive down payment with \n" +
                        "\t  value between 0 and 100.");
                labError2.setLayoutY(40.0);
            }
            double downPay = 0;
            try{
                downPay = Double.parseDouble(txtDownPay.getText());
            } catch (NumberFormatException ex){
                labError2.setText("Error: Please provide a positive loan term value.");
            }

            double intRate = 0;
            try{
                intRate = Double.parseDouble(txtIntRate.getText());
            } catch (NumberFormatException ex){
                labError2.setText("Please provide a positive interest value.");
            }

            BigDecimal finalPrice = calculateVehiclePrice(loanAmount,loanTerm,intRate,downPay);
            labFinalResult.setText("Vehicle Price:  $"+finalPrice);
        });
    }

}
