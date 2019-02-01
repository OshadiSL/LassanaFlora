package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class adminDashBodController implements Initializable {
    @FXML
    private JFXButton backBtn;
    @FXML
    private JFXButton btnAdmin;


    @FXML
    void backbtnAction(ActionEvent event) throws IOException {
        AnchorPane root = FXMLLoader.load(this.getClass().getResource("/views/dashBoard.fxml"));
        Scene scene = new Scene(root);

        Stage stage= (Stage) this.backBtn.getScene().getWindow();
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void backActionOnClick(ActionEvent event) throws IOException {


    }

    @FXML
    private JFXButton btnReception;
    public void receptionOnAction(ActionEvent actionEvent) throws IOException {
//        AnchorPane root = FXMLLoader.load(this.getClass().getResource("/views/manageDetails.fxml"));
//        Scene scene = new Scene(root);
//
//        Stage stage= (Stage) this.btnAdmin.getScene().getWindow();
//        stage.centerOnScreen();
//        stage.setScene(scene);
//        stage.show();

        Parent parent=FXMLLoader.load(this.getClass().getResource("/views/manageDetails.fxml"));
        Scene scene=new Scene(parent);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void adminOnAction(ActionEvent actionEvent) throws IOException {
//        AnchorPane root = FXMLLoader.load(this.getClass().getResource("/views/Add NewCategory.fxml"));
//        Scene scene = new Scene(root);
//
//        Stage stage= (Stage) this.btnReception.getScene().getWindow();
//        stage.centerOnScreen();
//        stage.setScene(scene);
//        stage.show();

        Parent parent=FXMLLoader.load(this.getClass().getResource("/views/Add NewCategory.fxml"));
        Scene scene=new Scene(parent);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
