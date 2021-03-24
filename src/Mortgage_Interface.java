import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.math.BigDecimal;

import static CalculationFormulas.MortgageCal.calculateMonthlyPayment;

public class Mortgage_Interface implements EventHandler<ActionEvent>{


    @Override
    public void handle(ActionEvent event) {
        //Create Main Window
        Stage MortCal = new Stage();
        MortCal.setTitle("Financial Calculator > Mortgage Calculator");

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

        HBox finCal_Content = new HBox();
        finCal_Content.layout();
        finCal_Content.setLayoutX(20.0);
        finCal_Content.setLayoutY(25.0);
        finCal_Content.setStyle("-fx-background-color: #FFFF");


        VBox finCal_conInputs = new VBox();
        finCal_conInputs.layout();
        finCal_conInputs.setPrefSize(300.0,350.0);

        VBox finCal_conOutputs = new VBox();
        finCal_conOutputs.layout();
        finCal_conOutputs.setPrefSize(260.0,350.0);
        finCal_conOutputs.setStyle("-fx-background-color: #EDD2CB");

        stage.getChildren().addAll(stageDivide);
        stageDivide.getChildren().addAll(leftAnchor,rightAnchor);
        rightAnchor.getChildren().add(finCal_Content);

        leftAnchor.getChildren().add(primaryBtnList);
        finCal_Content.getChildren().addAll(finCal_conInputs,finCal_conOutputs);



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
        btnAutoLoanCal.setOnAction(new AutoLoan_Interface());

        Button btnMortgageCal = new Button("Mortgage Calculator");
        btnMortgageCal.setId("btnMortgageCal");
        btnMortgageCal.setPrefSize(200.0,50.0);


        primaryBtnList.getChildren().addAll(
                logo,btnFinancialCal,btnAutoLoanCal,btnMortgageCal);




        //Content of Mortgage Cal

        Pane headingBackground = new Pane();
        headingBackground.setPrefSize(200.0,40.0);
        headingBackground.setStyle("-fx-background-color: #543C52");

        Label mort_heading = new Label("Mortgage Calculator");
        mort_heading.setId("labMortH");
        mort_heading.setLayoutX(30.0);
        mort_heading.setLayoutY(10.0);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(40,10,10,30));
        grid.setVgap(8);
        grid.setHgap(10);

        //Get home price inputs
        Label labHomePrice = new Label("Home Price");
        GridPane.setConstraints(labHomePrice, 0, 0);
        TextField txtHomePrice = new TextField();
        txtHomePrice.setPromptText("$");
        GridPane.setConstraints(txtHomePrice, 1, 0);


        //Get Down Payment inputs
        Label labDownPay = new Label("Down Payment");
        GridPane.setConstraints(labDownPay, 0, 1);
        TextField txtDownPay = new TextField();
        txtDownPay.setPromptText("0.0%");
        GridPane.setConstraints(txtDownPay, 1, 1);


        //Get Loan Term inputs
        Label labLoanTerm = new Label("Loan Term");
        GridPane.setConstraints(labLoanTerm, 0, 2);
        TextField txtLoanTerm = new TextField();
        txtLoanTerm.setPromptText("years");
        GridPane.setConstraints(txtLoanTerm, 1, 2);


        //Get Interest Rate inputs
        Label labIntRate = new Label("Interest Rate");
        GridPane.setConstraints(labIntRate, 0, 3);
        TextField txtIntRate = new TextField();
        txtIntRate.setPromptText("0.0%");
        GridPane.setConstraints(txtIntRate, 1, 3);

        grid.getChildren().addAll(
                labHomePrice,txtHomePrice,
                labDownPay,txtDownPay,
                labLoanTerm,txtLoanTerm,
                labIntRate,txtIntRate);


        //Error massages
        Pane error = new Pane();
        Label labError = new Label("");
        labError.setId("labError");
        labError.setLayoutX(30.0);
        labError.setLayoutY(60.0);
        error.getChildren().add(labError);
        Pane subButtons = new Pane();

        Button btnMortInputsSubmit = new Button("Calculate");
        btnMortInputsSubmit.setPrefSize(220.0,40.0);
        btnMortInputsSubmit.setLayoutX(79.0);
        btnMortInputsSubmit.setLayoutY(20.0);
        btnMortInputsSubmit.setId("btnMortInputsSubmit");

        subButtons.getChildren().addAll(btnMortInputsSubmit);
        headingBackground.getChildren().add(mort_heading);

        finCal_conInputs.getChildren().addAll(
                headingBackground,grid,error,subButtons);





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

        Label labFinalResult = new Label("");
        labFinalResult.setId("mainResult");
        labFinalResult.setLayoutX(30.0);
        labFinalResult.setLayoutY(5.0);

        mainResultBackground.getChildren().add(labFinalResult);



        finCal_conOutputs.getChildren().addAll(
                headingBackgroundResult,
                mainResultBackground);



        Scene scene = new Scene(stage, 800, 400);
        MortCal.setResizable(false);
        MortCal.setScene(scene);
        MortCal.show();
        Stage previousStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        previousStage.close();

        scene.getStylesheets().add("CSS/mortgage_interface.css");

        btnMortInputsSubmit.setOnAction(e->{
            labError.setText("");
            double loanAmount = 0;
            try{
                loanAmount = Double.parseDouble(txtHomePrice.getText());
            } catch (NumberFormatException ex){
                labError.setText("Error: Please provide a positive home price value.");

            }

            double loanTerm = 0;
            try{
                loanTerm = Double.parseDouble(txtLoanTerm.getText());
            } catch (NumberFormatException ex){
                labError.setText("Error: Please provide a positive loan term value.");

            }

            double downPay = 0;
            try{
                downPay = Double.parseDouble(txtDownPay.getText());
            } catch (NumberFormatException ex){
                labError.setText("Error: Please provide a positive down payment with \n" +
                        "\t  value between 0 and 100.");
                labError.setLayoutY(40.0);
            }

            double intRate = 0;
            try{
                intRate = Double.parseDouble(txtIntRate.getText());
            } catch (NumberFormatException ex){
                labError.setText("Please provide a positive interest value.");
            }
            BigDecimal monthlyPay = calculateMonthlyPayment(loanAmount,loanTerm,intRate,downPay);
            labFinalResult.setText("Monthly Pay:  $"+monthlyPay);
        });

    }

}
