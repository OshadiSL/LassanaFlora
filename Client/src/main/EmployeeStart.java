package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EmployeeStart extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane root = FXMLLoader.load(this.getClass().getResource("/views/manageDetails.fxml"));
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.show();

//        Parent fxml= FXMLLoader.load(getClass().getResource("/lk/ijse/edu/view/main.fxml"));
//
//        Scene scene1=new Scene(fxml);
//        primaryStage.setScene(scene1);
//        primaryStage.show();
    }
}
