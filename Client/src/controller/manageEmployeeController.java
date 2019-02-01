package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dto.FloristDTO;
import dto.ReceptionDTO;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import proxy.ProxyHandeler;
import service.ServiceFactory;
import service.custom.FloristService;
import service.custom.ReceptionService;

import java.net.URL;
import java.rmi.Remote;
import java.util.ResourceBundle;

public class manageEmployeeController implements Initializable, Remote {
    ReceptionService receptionService;
    FloristService floristService;

    {
        try {
            receptionService = ProxyHandeler.getInstance().getSuperService(ServiceFactory.ServiceTypes.RESEPTION);
            floristService = ProxyHandeler.getInstance().getSuperService(ServiceFactory.ServiceTypes.FLORIST);
//            customerService=ProxyHandeler.getInstance().getSuperService(ServiceFactory.ServiceTypes.CUSTOMER);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loardTable();
        loardReception();

    }



    private void loardReception() {
        tblReception.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("receptionId"));
        tblReception.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("receptionName"));
        tblReception.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("userName"));
        tblReception.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("passWord"));
        try {
            tblReception.setItems(FXCollections.observableArrayList(receptionService.getAll()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loardTable() {
        tblDeliver.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("floristId"));
        tblDeliver.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("floristName"));
        tblDeliver.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("userName"));
        tblDeliver.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("passWord"));

        try {
            tblDeliver.setItems(FXCollections.observableArrayList(floristService.getloardOrders()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private TableView<ReceptionDTO> tblReception;

    @FXML
    private JFXTextField txtdeliverId;

    @FXML
    private JFXTextField txtDeliverName;

    @FXML
    private JFXTextField txtDeliversAddress;

    @FXML
    private JFXTextField txtDeliverTel;

    @FXML
    private JFXTextField txtDEliverNic;

    @FXML
    private JFXButton btnDeliverAdd;

    @FXML
    private JFXTextField chefId;

    @FXML
    private JFXTextField chefName;

    @FXML
    private JFXTextField chefAddress;

    @FXML
    private JFXTextField chefTel;

    @FXML
    private JFXTextField chefNIC;

    @FXML
    private JFXButton btnChefDetails;

    @FXML
    private JFXTextField chefUserName;

    @FXML
    private JFXTextField chefPassWord;

    @FXML
    private JFXTextField chefConfirmPassword;

    @FXML
    private JFXTextField txtDeliverUserName;

    @FXML
    private JFXTextField txtDeliverPassword;

    @FXML
    private JFXTextField txtDeliverConfirePassword;

    @FXML
    private JFXTextField dataPicker;

    @FXML
    private TableView<FloristDTO> tblDeliver;

    @FXML
    void addDeliverOnActionClick(ActionEvent event) {
        FloristDTO floristDTO=new FloristDTO(txtdeliverId.getText(),txtDeliverName.getText(),txtDEliverNic.getText(),txtDeliverTel.getText(),txtDeliversAddress.getText(),txtDeliverUserName.getText(),txtDeliverPassword.getText());
        boolean isAdded= false;
        try {
            isAdded = floristService.save(floristDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(isAdded){
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Added Success");
            alert.showAndWait();
            loardTable();

        }else {
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Added Not Success");
            alert.showAndWait();
        }

    }

    @FXML
    void chefAddOnClick(ActionEvent event) {
        ReceptionDTO receptionDTO=new ReceptionDTO(Integer.parseInt(chefId.getText()),chefName.getText(),chefNIC.getText(),chefTel.getText(),chefAddress.getText(),chefUserName.getText(),chefPassWord.getText());
        boolean isAdded= false;
        try {
            isAdded = receptionService.save(receptionDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(isAdded){
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Added Success");
            alert.showAndWait();
            loardReception();

        }else {
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Added Not Success");
            alert.showAndWait();
        }


    }



}
