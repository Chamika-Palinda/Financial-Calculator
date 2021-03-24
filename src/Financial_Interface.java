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
import javafx.stage.Stage;

import java.math.BigDecimal;

import static CalculationFormulas.FinancialCal.*;


public class Financial_Interface implements EventHandler<ActionEvent>{


    @Override
    public void handle(ActionEvent event) {
        //Create Main Window
        Stage FinCal = new Stage();
        FinCal.setTitle("Financial Calculator > Financial Calculator");

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


        //Future Value cal Vbox

        VBox loanCal_conInputs_FutureV = new VBox();
        loanCal_conInputs_FutureV.layout();
        loanCal_conInputs_FutureV.setPrefSize(300.0,350.0);

        //Monthly Payment cal Vbox

        VBox loanCal_conInputs_PMT = new VBox();
        loanCal_conInputs_PMT.layout();
        loanCal_conInputs_PMT.setPrefSize(300.0,350.0);

        //Interest Rate cal Vbox

        VBox loanCal_conInputs_InterestR = new VBox();
        loanCal_conInputs_InterestR.layout();
        loanCal_conInputs_InterestR.setPrefSize(300.0,350.0);

        //Number of periods cal Vbox

        VBox loanCal_conInputs_NumPeriods = new VBox();
        loanCal_conInputs_NumPeriods.layout();
        loanCal_conInputs_NumPeriods.setPrefSize(300.0,350.0);

        //Present Value cal Vbox

        VBox loanCal_conInputs_PresentV = new VBox();
        loanCal_conInputs_PresentV.layout();
        loanCal_conInputs_PresentV.setPrefSize(300.0,350.0);



        //Create tabPane and Tabs

        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);


        Tab tabFutureV = new Tab("FV");
        AnchorPane ancFutureV = new AnchorPane();

        Tab tabPMT = new Tab("PMT");
        AnchorPane ancPMT = new AnchorPane();

        Tab tabInterestR = new Tab("I/Y");
        AnchorPane ancInterestR = new AnchorPane();

        Tab tabNumPeriods = new Tab("N");
        AnchorPane ancNumPeriods = new AnchorPane();

        Tab tabPresentV = new Tab("Start Principal");
        AnchorPane ancPresentV = new AnchorPane();


        ancFutureV.getChildren().add(loanCal_conInputs_FutureV);
        ancPMT.getChildren().add(loanCal_conInputs_PMT);
        ancInterestR.getChildren().add(loanCal_conInputs_InterestR);
        ancNumPeriods.getChildren().add(loanCal_conInputs_NumPeriods);
        ancPresentV.getChildren().add(loanCal_conInputs_PresentV);


        tabFutureV.setContent(ancFutureV);
        tabPMT.setContent(ancPMT);
        tabInterestR.setContent(ancInterestR);
        tabNumPeriods.setContent(ancNumPeriods);
        tabPresentV.setContent(ancPresentV);

        tabPane.getTabs().addAll(
                tabFutureV,tabPMT,tabInterestR,tabNumPeriods,tabPresentV);






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

        Button btnAutoLoanCal = new Button("Loan Calculator");
        btnAutoLoanCal.setId("btnAutoLoanCal");
        btnAutoLoanCal.setPrefSize(200.0,50.0);
        btnAutoLoanCal.setOnAction(new AutoLoan_Interface());

        Button btnMortgageCal = new Button("Mortgage Calculator");
        btnMortgageCal.setId("btnMortgageCal");
        btnMortgageCal.setPrefSize(200.0,50.0);
        btnMortgageCal.setOnAction(new Mortgage_Interface());


        primaryBtnList.getChildren().addAll(
                logo,btnFinancialCal,btnAutoLoanCal,btnMortgageCal);




        //Content of Tab FV

        GridPane gridTabFV = new GridPane();
        gridTabFV.setPadding(new Insets(40,10,10,30));
        gridTabFV.setVgap(8);
        gridTabFV.setHgap(10);

        //Get Num of Periods inputs
        Label labNumOfPeriods = new Label("N (# of periods)");
        GridPane.setConstraints(labNumOfPeriods, 0, 0);
        TextField txtNumOfPeriods = new TextField();
        txtNumOfPeriods.setPromptText("Years");
        GridPane.setConstraints(txtNumOfPeriods, 1, 0);


        //Get Start Principal inputs
        Label labPresentV = new Label("Start Principal");
        GridPane.setConstraints(labPresentV, 0, 1);
        TextField txtPresentV = new TextField();
        txtPresentV.setPromptText("$");
        GridPane.setConstraints(txtPresentV, 1, 1);


        //Get I/Y (Interest) inputs
        Label labInterestR = new Label("I/Y (Interest)");
        GridPane.setConstraints(labInterestR, 0, 2);
        TextField txtInterestR = new TextField();
        txtInterestR.setPromptText("0.0%");
        GridPane.setConstraints(txtInterestR, 1, 2);


        //Get PMT inputs
        Label labPMT = new Label("PMT (Annuity Pay)");
        GridPane.setConstraints(labPMT, 0, 3);
        TextField txtPMT = new TextField();
        txtPMT.setPromptText("$");
        GridPane.setConstraints(txtPMT, 1, 3);

        gridTabFV.getChildren().addAll(
                labNumOfPeriods,txtNumOfPeriods,
                labPresentV,txtPresentV,
                labInterestR,txtInterestR,
                labPMT,txtPMT);


        //Error massages
        Pane errorForTabFV = new Pane();
        Label labError = new Label("");
        labError.setId("labError");
        labError.setLayoutX(30.0);
        labError.setLayoutY(60.0);
        errorForTabFV.getChildren().add(labError);

        Pane subButtons_FV = new Pane();

        Button btnFinInputsSubmit_FV = new Button("Calculate");
        btnFinInputsSubmit_FV.setPrefSize(220.0,40.0);
        btnFinInputsSubmit_FV.setLayoutX(79.0);
        btnFinInputsSubmit_FV.setLayoutY(20.0);
        btnFinInputsSubmit_FV.setId("btnInputsSubmit");

        subButtons_FV.getChildren().addAll(btnFinInputsSubmit_FV);

        loanCal_conInputs_FutureV.getChildren().addAll(
                gridTabFV,errorForTabFV,subButtons_FV);





        //Content of Tab PMT

        GridPane gridTabPMT = new GridPane();
        gridTabPMT.setPadding(new Insets(40,10,10,30));
        gridTabPMT.setVgap(8);
        gridTabPMT.setHgap(10);


        //Get Future Value inputs
        Label labFutureV = new Label("FV (Future Value)");
        GridPane.setConstraints(labFutureV, 0, 0);
        TextField txtFutureV = new TextField();
        txtFutureV.setPromptText("$");
        GridPane.setConstraints(txtFutureV, 1, 0);


        //Get Number of periods inputs
        Label labNumOfPeriods2 = new Label("N (# of periods)");
        GridPane.setConstraints(labNumOfPeriods2, 0, 1);
        TextField txtNumOfPeriods2 = new TextField();
        txtNumOfPeriods2.setPromptText("Years");
        GridPane.setConstraints(txtNumOfPeriods2, 1, 1);


        //Get Start principal inputs
        Label labPresentV2 = new Label("Start Principal");
        GridPane.setConstraints(labPresentV2, 0, 2);
        TextField txtPresentV2 = new TextField();
        txtPresentV2.setPromptText("$");
        GridPane.setConstraints(txtPresentV2, 1, 2);


        //Get Interest Rate inputs
        Label labInterestR2 = new Label("Interest Rate");
        GridPane.setConstraints(labInterestR2, 0, 3);
        TextField txtInterestR2 = new TextField();
        txtInterestR2.setPromptText("0.0%");
        GridPane.setConstraints(txtInterestR2, 1, 3);

        gridTabPMT.getChildren().addAll(
                labFutureV,txtFutureV,
                labNumOfPeriods2,txtNumOfPeriods2,
                labPresentV2,txtPresentV2,
                labInterestR2,txtInterestR2);


        //Error massages
        Pane errorForTabPMT = new Pane();
        Label labError2 = new Label("");
        labError2.setId("labError");
        labError2.setLayoutX(30.0);
        labError2.setLayoutY(60.0);
        errorForTabPMT.getChildren().add(labError2);

        Pane subButtons_PMT = new Pane();

        Button btnFinInputsSubmit_PMT = new Button("Calculate");
        btnFinInputsSubmit_PMT.setPrefSize(220.0,40.0);
        btnFinInputsSubmit_PMT.setLayoutX(79.0);
        btnFinInputsSubmit_PMT.setLayoutY(20.0);
        btnFinInputsSubmit_PMT.setId("btnInputsSubmit");

        subButtons_PMT.getChildren().addAll(btnFinInputsSubmit_PMT);

        loanCal_conInputs_PMT.getChildren().addAll(
                gridTabPMT,errorForTabPMT,subButtons_PMT);





        //Content of Tab I/Y

        GridPane gridTabIntR = new GridPane();
        gridTabIntR.setPadding(new Insets(40,10,10,30));
        gridTabIntR.setVgap(8);
        gridTabIntR.setHgap(10);


        //Get Future Value inputs
        Label labFutureV2 = new Label("FV (Future Value)");
        GridPane.setConstraints(labFutureV2, 0, 0);
        TextField txtFutureV2 = new TextField();
        txtFutureV2.setPromptText("$");
        GridPane.setConstraints(txtFutureV2, 1, 0);


        //Get Number of periods inputs
        Label labNumOfPeriods3 = new Label("N (# of periods)");
        GridPane.setConstraints(labNumOfPeriods3, 0, 1);
        TextField txtNumOfPeriods3 = new TextField();
        txtNumOfPeriods3.setPromptText("Years");
        GridPane.setConstraints(txtNumOfPeriods3, 1, 1);


        //Get Start principal inputs
        Label labPresentV3 = new Label("Start Principal");
        GridPane.setConstraints(labPresentV3, 0, 2);
        TextField txtPresentV3 = new TextField();
        txtPresentV3.setPromptText("$");
        GridPane.setConstraints(txtPresentV3, 1, 2);


        //Get PMT inputs
        Label labPMT2 = new Label("PMT (Annuity Pay)");
        GridPane.setConstraints(labPMT2, 0, 3);
        TextField txtPMT2 = new TextField();
        txtPMT2.setPromptText("$");
        GridPane.setConstraints(txtPMT2, 1, 3);

        gridTabIntR.getChildren().addAll(
                labFutureV2,txtFutureV2,
                labNumOfPeriods3,txtNumOfPeriods3,
                labPresentV3,txtPresentV3,
                labPMT2,txtPMT2);


        //Error massages
        Pane errorForTabIntR = new Pane();
        Label labError3 = new Label("");
        labError3.setId("labError");
        labError3.setLayoutX(30.0);
        labError3.setLayoutY(60.0);
        errorForTabIntR.getChildren().add(labError3);

        Pane subButtons_IntR = new Pane();

        Button btnFinInputsSubmit_IntR = new Button("Calculate");
        btnFinInputsSubmit_IntR.setPrefSize(220.0,40.0);
        btnFinInputsSubmit_IntR.setLayoutX(79.0);
        btnFinInputsSubmit_IntR.setLayoutY(20.0);
        btnFinInputsSubmit_IntR.setId("btnInputsSubmit");

        subButtons_IntR.getChildren().addAll(btnFinInputsSubmit_IntR);

        loanCal_conInputs_InterestR.getChildren().addAll(
                gridTabIntR,errorForTabIntR,subButtons_IntR);




        //Content of Tab N

        GridPane gridTabN = new GridPane();
        gridTabN.setPadding(new Insets(40,10,10,30));
        gridTabN.setVgap(8);
        gridTabN.setHgap(10);

        //Get Future Value inputs
        Label labFutureV3 = new Label("FV (Future Value)");
        GridPane.setConstraints(labFutureV3, 0, 0);
        TextField txtFutureV3 = new TextField();
        txtFutureV3.setPromptText("$");
        GridPane.setConstraints(txtFutureV3, 1, 0);


        //Get Start Principal inputs
        Label labPresentV4 = new Label("Start Principal");
        GridPane.setConstraints(labPresentV4, 0, 1);
        TextField txtPresentV4 = new TextField();
        txtPresentV4.setPromptText("$");
        GridPane.setConstraints(txtPresentV4, 1, 1);


        //Get I/Y (Interest) inputs
        Label labInterestR3 = new Label("I/Y (Interest)");
        GridPane.setConstraints(labInterestR3, 0, 2);
        TextField txtInterestR3 = new TextField();
        txtInterestR3.setPromptText("0.0%");
        GridPane.setConstraints(txtInterestR3, 1, 2);


        //Get PMT inputs
        Label labPMT3 = new Label("PMT (Annuity Pay)");
        GridPane.setConstraints(labPMT3, 0, 3);
        TextField txtPMT3 = new TextField();
        txtPMT3.setPromptText("$");
        GridPane.setConstraints(txtPMT3, 1, 3);

        gridTabN.getChildren().addAll(
                labFutureV3,txtFutureV3,
                labPresentV4,txtPresentV4,
                labInterestR3,txtInterestR3,
                labPMT3,txtPMT3);


        //Error massages
        Pane errorForTabN = new Pane();
        Label labError4 = new Label("");
        labError4.setId("labError");
        labError4.setLayoutX(30.0);
        labError4.setLayoutY(60.0);
        errorForTabN.getChildren().add(labError4);

        Pane subButtons_N = new Pane();

        Button btnFinInputsSubmit_N = new Button("Calculate");
        btnFinInputsSubmit_N.setPrefSize(220.0,40.0);
        btnFinInputsSubmit_N.setLayoutX(79.0);
        btnFinInputsSubmit_N.setLayoutY(20.0);
        btnFinInputsSubmit_N.setId("btnInputsSubmit");

        subButtons_N.getChildren().addAll(btnFinInputsSubmit_N);

        loanCal_conInputs_NumPeriods.getChildren().addAll(
                gridTabN,errorForTabN,subButtons_N);





        //Content of Tab Start Principal

        GridPane gridTabPV = new GridPane();
        gridTabPV.setPadding(new Insets(40,10,10,30));
        gridTabPV.setVgap(8);
        gridTabPV.setHgap(10);

        //Get Future Value inputs
        Label labFutureV4 = new Label("FV (Future Value)");
        GridPane.setConstraints(labFutureV4, 0, 0);
        TextField txtFutureV4 = new TextField();
        txtFutureV4.setPromptText("$");
        GridPane.setConstraints(txtFutureV4, 1, 0);


        //Get Start Principal inputs
        Label labNumOfPeriods4 = new Label("N (# of periods)");
        GridPane.setConstraints(labNumOfPeriods4, 0, 1);
        TextField txtNumOfPeriods4 = new TextField();
        txtNumOfPeriods4.setPromptText("Years");
        GridPane.setConstraints(txtNumOfPeriods4, 1, 1);


        //Get I/Y (Interest) inputs
        Label labInterestR4 = new Label("I/Y (Interest)");
        GridPane.setConstraints(labInterestR4, 0, 2);
        TextField txtInterestR4 = new TextField();
        txtInterestR4.setPromptText("0.0%");
        GridPane.setConstraints(txtInterestR4, 1, 2);


        //Get PMT inputs
        Label labPMT4 = new Label("PMT (Annuity Pay)");
        GridPane.setConstraints(labPMT4, 0, 3);
        TextField txtPMT4 = new TextField();
        txtPMT4.setPromptText("$");
        GridPane.setConstraints(txtPMT4, 1, 3);

        gridTabPV.getChildren().addAll(
                labFutureV4,txtFutureV4,
                labNumOfPeriods4,txtNumOfPeriods4,
                labInterestR4,txtInterestR4,
                labPMT4,txtPMT4);


        //Error massages
        Pane errorForTabPV = new Pane();
        Label labError5 = new Label("");
        labError5.setId("labError");
        labError5.setLayoutX(30.0);
        labError5.setLayoutY(60.0);
        errorForTabPV.getChildren().add(labError5);

        Pane subButtons_PV = new Pane();

        Button btnFinInputsSubmit_PV = new Button("Calculate");
        btnFinInputsSubmit_PV.setPrefSize(220.0,40.0);
        btnFinInputsSubmit_PV.setLayoutX(79.0);
        btnFinInputsSubmit_PV.setLayoutY(20.0);
        btnFinInputsSubmit_PV.setId("btnInputsSubmit");

        subButtons_PV.getChildren().addAll(btnFinInputsSubmit_PV);

        loanCal_conInputs_PresentV.getChildren().addAll(
                gridTabPV,errorForTabPV,subButtons_PV);






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
        FinCal.setResizable(false);
        FinCal.setScene(scene);
        FinCal.show();
        Stage previousStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        previousStage.close();

        scene.getStylesheets().add("CSS/financial_interface.css");

        btnFinInputsSubmit_FV.setOnAction(e->{
            labError.setText("");
            double PV = 0;
            try{
                PV = Double.parseDouble(txtPresentV.getText());
            } catch (NumberFormatException ex){
                labError.setText("Error: Please provide a positive Auto price value.");
            }

            double loanTerm = 0;
            try{
                loanTerm = Double.parseDouble(txtNumOfPeriods.getText());
            } catch (NumberFormatException ex){
                labError.setText("Error: Please provide a positive down payment with \n" +
                        "\t  value between 0 and 100.");
                labError.setLayoutY(40.0);
            }
            double PMT = 0;
            try{
                PMT = Double.parseDouble(txtPMT.getText());
            } catch (NumberFormatException ex){
                labError.setText("Error: Please provide a positive loan term value.");
            }

            double intRate = 0;
            try{
                intRate = Double.parseDouble(txtInterestR.getText());
            } catch (NumberFormatException ex){
                labError.setText("Please provide a positive interest value.");
            }
            BigDecimal FV = calculateFutureValue(loanTerm,PV,intRate,PMT);
            labFinalResult.setText("FV(Future Value):  $"+FV);
        });

        btnFinInputsSubmit_PMT.setOnAction(e->{
            labError2.setText("");
            double FV = 0;
            try{
                FV = Double.parseDouble(txtFutureV.getText());
            } catch (NumberFormatException ex){
                labError2.setText("Error: Please provide a positive Monthly Payment value.");
            }

            double loanTerm = 0;
            try{
                loanTerm = Double.parseDouble(txtNumOfPeriods2.getText());
            } catch (NumberFormatException ex){
                labError2.setText("Error: Please provide a positive down payment with \n" +
                        "\t  value between 0 and 100.");
                labError2.setLayoutY(40.0);
            }
            double PV = 0;
            try{
                PV = Double.parseDouble(txtPresentV2.getText());
            } catch (NumberFormatException ex){
                labError2.setText("Error: Please provide a positive loan term value.");
            }

            double intRate = 0;
            try{
                intRate = Double.parseDouble(txtInterestR2.getText());
            } catch (NumberFormatException ex){
                labError2.setText("Please provide a positive interest value.");
            }

            BigDecimal finalPrice = calculatePMT(FV,loanTerm,PV,intRate);
            labFinalResult.setText("Monthly Payment:  $"+finalPrice);
        });

        btnFinInputsSubmit_IntR.setOnAction(e->{
            labError3.setText("");
            double FV = 0;
            try{
                FV = Double.parseDouble(txtFutureV2.getText());
            } catch (NumberFormatException ex){
                labError3.setText("Error: Please provide a positive Monthly Payment value.");
            }

            double loanTerm = 0;
            try{
                loanTerm = Double.parseDouble(txtNumOfPeriods3.getText());
            } catch (NumberFormatException ex){
                labError3.setText("Error: Please provide a positive down payment with \n" +
                        "\t  value between 0 and 100.");
                labError3.setLayoutY(40.0);
            }
            double PV = 0;
            try{
                PV = Double.parseDouble(txtPresentV3.getText());
            } catch (NumberFormatException ex){
                labError3.setText("Error: Please provide a positive loan term value.");
            }

            double PMT = 0;
            try{
                PMT = Double.parseDouble(txtPMT2.getText());
            } catch (NumberFormatException ex){
                labError3.setText("Please provide a positive interest value.");
            }

            BigDecimal intR = calculateInterestRate(FV,loanTerm,PV,PMT);
            labFinalResult.setText("Interest Rate:  "+intR+"%");
        });


        btnFinInputsSubmit_N.setOnAction(e->{
            labError4.setText("");
            double FV = 0;
            try{
                FV = Double.parseDouble(txtFutureV3.getText());
            } catch (NumberFormatException ex){
                labError4.setText("Error: Please provide a positive Monthly Payment value.");
            }

            double PV = 0;
            try{
                PV = Double.parseDouble(txtPresentV4.getText());
            } catch (NumberFormatException ex){
                labError4.setText("Error: Please provide a positive down payment with \n" +
                        "\t  value between 0 and 100.");
                labError4.setLayoutY(40.0);
            }
            double IntR = 0;
            try{
                IntR = Double.parseDouble(txtInterestR3.getText());
            } catch (NumberFormatException ex){
                labError4.setText("Error: Please provide a positive loan term value.");
            }

            double PMT = 0;
            try{
                PMT = Double.parseDouble(txtPMT3.getText());
            } catch (NumberFormatException ex){
                labError4.setText("Please provide a positive interest value.");
            }

//            BigDecimal N = calculatePresentValue(FV,loanTerm,IntR,PMT);
//            labFinalResult.setText("Num of Periods:  "+N);
            labFinalResult.setText(FV+" "+PV+" "+IntR+" "+PMT);
        });




        btnFinInputsSubmit_PV.setOnAction(e->{
            labError5.setText("");
            double FV = 0;
            try{
                FV = Double.parseDouble(txtFutureV4.getText());
            } catch (NumberFormatException ex){
                labError5.setText("Error: Please provide a positive Monthly Payment value.");
            }

            double loanTerm = 0;
            try{
                loanTerm = Double.parseDouble(txtNumOfPeriods4.getText());
            } catch (NumberFormatException ex){
                labError5.setText("Error: Please provide a positive down payment with \n" +
                        "\t  value between 0 and 100.");
                labError5.setLayoutY(40.0);
            }
            double IntR = 0;
            try{
                IntR = Double.parseDouble(txtInterestR4.getText());
            } catch (NumberFormatException ex){
                labError5.setText("Error: Please provide a positive loan term value.");
            }

            double PMT = 0;
            try{
                PMT = Double.parseDouble(txtPMT4.getText());
            } catch (NumberFormatException ex){
                labError5.setText("Please provide a positive interest value.");
            }

            BigDecimal PV = calculatePresentValue(FV,loanTerm,IntR,PMT);
            labFinalResult.setText("Start Principal:  $"+PV);
        });

    }

}
