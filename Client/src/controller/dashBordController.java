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

public class dashBordController implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML
    private JFXButton btnAdmin;

    @FXML
    private JFXButton btnReception;

    @FXML
    private JFXButton btnChef;


    public void adminOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane root = FXMLLoader.load(this.getClass().getResource("/views/adminDashBord.fxml"));
        Scene scene = new Scene(root);

        Stage stage= (Stage) this.btnAdmin.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void receptionOnAction(ActionEvent actionEvent) throws IOException {
//        AnchorPane root = FXMLLoader.load(this.getClass().getResource("/views/LoginFrom.fxml"));
//        Scene scene = new Scene(root);
//
//        Stage stage= (Stage) this.btnReception.getScene().getWindow();
//        stage.centerOnScreen();
//        stage.setScene(scene);
//        stage.show();


        Parent parent=FXMLLoader.load(this.getClass().getResource("/views/LoginFrom.fxml"));
        Scene scene=new Scene(parent);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();


    }

    public void chefOrderOnAction(ActionEvent actionEvent) throws IOException {
//        AnchorPane root = FXMLLoader.load(this.getClass().getResource("/views/newGetOrderFrom.fxml"));
//        Scene scene = new Scene(root);
//
//        Stage stage= (Stage) this.btnChef.getScene().getWindow();
//        stage.centerOnScreen();
//        stage.setScene(scene);
//        stage.show();

        Parent parent=FXMLLoader.load(this.getClass().getResource("/views/newGetOrderFrom.fxml"));
        Scene scene=new Scene(parent);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

    }
}
