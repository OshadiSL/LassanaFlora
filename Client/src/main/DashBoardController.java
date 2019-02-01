package main;

import com.jfoenix.controls.JFXButton;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashBoardController extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
//        AnchorPane root = FXMLLoader.load(this.getClass().getResource("/views/dashBoard.fxml"));
//        Scene scene = new Scene(root);
//
//        primaryStage.setScene(scene);
//        primaryStage.centerOnScreen();
//        primaryStage.show();

        Parent parent=FXMLLoader.load(this.getClass().getResource("/views/dashBoard.fxml"));
        Scene scene=new Scene(parent);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

    }

}
