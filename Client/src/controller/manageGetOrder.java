package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dto.FloristDTO;
import dto.FlowerDetailsDTO;
import dto.OrderDTO;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import observer.Observer;
import proxy.ProxyHandeler;
import service.ServiceFactory;
import service.custom.FloristService;
import service.custom.OrderService;

import java.io.IOException;
import java.net.URL;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class manageGetOrder implements Initializable, Observer, Remote {


    OrderService orderService;
    FloristService floristService;


    {
        try {

            orderService = ProxyHandeler.getInstance().getSuperService(ServiceFactory.ServiceTypes.ORDERS);
            floristService=ProxyHandeler.getInstance().getSuperService(ServiceFactory.ServiceTypes.FLORIST);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private JFXComboBox<?> userCombo;

    @FXML
    private PasswordField pasword;
    @FXML
    private JFXTextField txtOrderId;

    @FXML
    private JFXTextField txtDate;

    @FXML
    private JFXTextField txtCustoomerId;

    @FXML
    private JFXTextField txtFloristId;

    @FXML
    private JFXTextField txtReceptionId;

    @FXML
    private JFXTextField txtStatus;

    @FXML
    private JFXTextField txtpayemnetId;
    @FXML
    private TableView<OrderDTO> getOrderTable;

    @FXML
    private TableView<OrderDTO> finishOrderTables;

    @FXML
    private JFXButton btnGetOrder;

    @FXML
    private JFXButton finishOrderActionOnClick;
    @FXML
    private JFXTextField txtReceptionId1;
    @FXML
    void getOrderOnActionClick(ActionEvent event) {
        int oid = (Integer) getOrderTable.getColumns().get(0).getCellObservableValue(0).getValue();
        System.out.println(oid);
        txtOrderId.setText(String.valueOf(oid));
        String date=(String) getOrderTable.getColumns().get(1).getCellObservableValue(0).getValue();
        txtDate.setText(String.valueOf(date));
        String status=(String) getOrderTable.getColumns().get(2).getCellObservableValue(0).getValue();
        txtStatus.setText(String.valueOf(status));
        String time=(String) getOrderTable.getColumns().get(3).getCellObservableValue(0).getValue();
        txtCustoomerId.setText(String.valueOf(time));
        int cid=(Integer) getOrderTable.getColumns().get(4).getCellObservableValue(0).getValue();
        txtFloristId.setText(String.valueOf(cid));
        String floristId=(String) getOrderTable.getColumns().get(5).getCellObservableValue(0).getValue();
//        txtpayemnetId.setText(String.valueOf(floristId));
        int payment=(Integer) getOrderTable.getColumns().get(6).getCellObservableValue(0).getValue();
        txtReceptionId.setText(String.valueOf(payment));
        int rception=(Integer) getOrderTable.getColumns().get(7).getCellObservableValue(0).getValue();
        txtReceptionId1.setText(String.valueOf(rception));


        String updateStatus="getting Order";
        OrderDTO orderDTO=new OrderDTO(oid,date,updateStatus,time,cid,comboFrolist.getSelectionModel().getSelectedItem(),payment,rception);
        try{
            boolean isUpdate=orderService.update(orderDTO);
            if(isUpdate){
                Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"get a order");
                alert.showAndWait();

            }else {
                Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Not get Order");
                alert.showAndWait();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    @FXML
    void finishOrderOnClick(ActionEvent event) {

        String updateStatus="FinishOrder...";
        int oid=Integer.parseInt(txtOrderId.getText());
        String date=txtDate.getText();
        String status=txtStatus.getText();
        String time=txtCustoomerId.getText();
        int cid=Integer.parseInt(txtFloristId.getText());
//        int floristId=Integer.parseInt(comboFrolist.getSelectionModel().getSelectedItem());
        int payment=Integer.parseInt(txtReceptionId.getText());
        int reception=Integer.parseInt(txtReceptionId1.getText());
        OrderDTO orderDTO=new OrderDTO(oid,date,updateStatus,time,cid,comboFrolist.getSelectionModel().getSelectedItem(),payment,reception);
        try{
            boolean isUpdate=orderService.update(orderDTO);
            if(isUpdate){
                Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Finish Order");
                alert.showAndWait();
            }else {
                Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Not Finish Order");
                alert.showAndWait();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private JFXComboBox<String> comboFrolist;





    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            UnicastRemoteObject.exportObject(this,0);
            orderService.register(this);
            floristService.register(this);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        loardOrder();
        getLoarIds();
    }

    private void getLoarIds() {
        List<FloristDTO> floristDTOS= null;
        try {
            floristDTOS = floristService.getloardOrders();

            ArrayList<String> arrayList=new ArrayList<>();
            for(FloristDTO flowerCategoryTupeDTO:floristDTOS){
                arrayList.add(flowerCategoryTupeDTO.getFloristId());

            }
            for (String f:arrayList){
                comboFrolist.getItems().add(f);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loardOrder() {
        getOrderTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("oid"));
        getOrderTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("date"));
        getOrderTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("status"));
        getOrderTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("time"));
        getOrderTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("custId"));
        getOrderTable.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("floristId"));
        getOrderTable.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("payID"));
        getOrderTable.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("receptionId"));

        try {
            getOrderTable.setItems(FXCollections.observableArrayList(orderService.getloardOrders()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    private JFXButton btnNextItem;
    @FXML
    void getItemNextActionOnClick(ActionEvent event) {
        try {
            Parent parent= FXMLLoader.load(this.getClass().getResource("/views/searchItem.fxml"));
            Scene scene=new Scene(parent);
            Stage stage=new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void enterSearchOnActionClick(ActionEvent actionEvent) {
    }

    @Override
    public void update(String mesage) throws Exception {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Platform.runLater(()->{
                    loardOrder();

                });
            }
        }).start();
    }
}
