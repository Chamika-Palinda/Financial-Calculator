import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.beans.EventHandler;
import java.io.FileNotFoundException;


public class Main extends Application {

    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        //Create Main Window
        window = primaryStage;
        window.setTitle("Financial Calculator v1.0");

        //Background Panel creating
        AnchorPane stage = new AnchorPane();
        stage.setStyle("-fx-background-color: #301A2C");

        //I made another anchor to put my buttons
        AnchorPane leftAnchor = new AnchorPane();
        leftAnchor.setPrefSize(200.0, 400.0);
        leftAnchor.setStyle("-fx-background-color: #361D32");

        //That was the my button layout
        VBox primaryBtnList = new VBox();
        primaryBtnList.layout();
        primaryBtnList.setPrefSize(200.0, 400.0);

        stage.getChildren().add(leftAnchor);
        leftAnchor.getChildren().add(primaryBtnList);

        Pane logo = new Pane();
        logo.setPrefSize(200.0, 100.0);

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
        btnFinancialCal.setPrefSize(200.0, 50.0);
        btnFinancialCal.setOnAction(new Financial_Interface());


        Button btnAutoLoanCal = new Button("Loan Calculator");
        btnAutoLoanCal.setId("btnAutoLoanCal");
        btnAutoLoanCal.setPrefSize(200.0, 50.0);
        btnAutoLoanCal.setOnAction(new AutoLoan_Interface());


        Button btnMortgageCal = new Button("Mortgage Calculator");
        btnMortgageCal.setId("btnMortgageCal");
        btnMortgageCal.setPrefSize(200.0, 50.0);
        btnMortgageCal.setOnAction(new Mortgage_Interface());

        primaryBtnList.getChildren().addAll(
                logo, btnFinancialCal, btnAutoLoanCal, btnMortgageCal);

        Scene scene = new Scene(stage, 800, 400);
        primaryStage.setResizable(false);
        window.setScene(scene);
        window.show();

        scene.getStylesheets().add("CSS/main_interface.css");

    }

}