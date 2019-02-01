package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import dto.*;
import entity.Reception;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import observer.Observer;
import proxy.ProxyHandeler;
import service.ServiceFactory;
import service.custom.*;

import java.net.URL;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class OrderController implements Initializable, Observer, Remote {
    double unitPrice = 0;
    double total = 0;
    FlowerCategoryService flowerCategoryService;
    OrderService orderService;
    CustomerService customerService;
    PayementService payementService;
    OrderDetailsService orderDetailsService;
    ReceptionService receptionService;

    {
        try {
            flowerCategoryService = ProxyHandeler.getInstance().getSuperService(ServiceFactory.ServiceTypes.FLOWERCATEGORY);
            orderService = ProxyHandeler.getInstance().getSuperService(ServiceFactory.ServiceTypes.ORDERS);
            customerService = ProxyHandeler.getInstance().getSuperService(ServiceFactory.ServiceTypes.CUSTOMER);
            payementService = ProxyHandeler.getInstance().getSuperService(ServiceFactory.ServiceTypes.PAYMENT);
            orderDetailsService = ProxyHandeler.getInstance().getSuperService(ServiceFactory.ServiceTypes.FLOWERDETAILS);
            receptionService=ProxyHandeler.getInstance().getSuperService(ServiceFactory.ServiceTypes.RESEPTION);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private JFXTextField txtQty;

        ObservableList<String> list=FXCollections.observableArrayList("Birthday Flowers","Wedding Flowers","Love And Romance","Anniversary Flowers","New Born Baby","Congratulations","Get Well Flowers","Thank you Flowers" );

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            UnicastRemoteObject.exportObject(this,0);
            orderService.register(this);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        loodTablr();
//        loardComboCategory();
        loardDate();
        setTime();
//        loardComboReception();
        comboFlowerCategory.setItems(list);
    }

    private void loardComboReception() {
//        try {
//            List<ReceptionDTO>receptionDTOS=receptionService.getAll();
//            ArrayList<Integer>integers=new ArrayList<>();
//            for (ReceptionDTO receptionDTOS1:receptionDTOS){
//                integers.add(receptionDTOS1.getReceptionId());
//            }
//            for (Integer s:integers){
//                txtCombo.getItems().get(s);
//            }
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }

    }

    private void loardComboCategory() {
        try {
            List<FlowerCategoryDTO>flowerDetailsDTOS=flowerCategoryService.getAll();
            ArrayList<String>flowerId=new ArrayList<>();
            for(FlowerCategoryDTO flowerCategoryDTO:flowerDetailsDTOS){
                flowerId.add(flowerCategoryDTO.getStatus());
            }

        comboFlowerCategory.getItems().clear();
            for(String id:flowerId){
                comboFlowerCategory.getItems().add(id);

                            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @FXML
    private ComboBox<?> txtCombo;



    private void setTime() {
        Timeline time = new Timeline(new KeyFrame(Duration.seconds(0), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                txtTime.setText(new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }), new KeyFrame(Duration.seconds(1)));
        time.setCycleCount(Animation.INDEFINITE);
        time.play();
    }

    private void loardDate() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0), new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                txtDate.setText(new SimpleDateFormat("YYYY-MM-dd").format(new Date()));


            }

        }), new KeyFrame(Duration.seconds(1)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    @FXML
    private TableView<FlowerCategoryDTO> tableItem;

    @FXML
    private TableView<TempDTO> selectItemTable;

    @FXML
    void tableOnActionClick(ActionEvent event) {

    }

    @FXML
    private JFXTextField txtSearchBar;

    @FXML
    void enterSearchOnActionClick(ActionEvent event) {
        String search = txtSearchBar.getText();
        try {
            List<FlowerCategoryDTO> flowerCategoryDTOS = flowerCategoryService.getSearch(search);
            System.out.println(flowerCategoryDTOS);
            tableItem.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("FCID"));
            tableItem.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("description"));
            tableItem.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
            tableItem.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("status"));
            tableItem.setItems(FXCollections.observableArrayList(flowerCategoryDTOS));

        } catch (Exception e) {
            e.printStackTrace();

        }


    }
    @FXML
    void comboOnAction(ActionEvent event) throws Exception {
        tableItem.getItems().clear();
        List<FlowerCategoryDTO> all = flowerCategoryService.getAll();

            for (FlowerCategoryDTO flowerCategoryDTO : all) {
                System.out.println(flowerCategoryDTO.getStatus());
                if (comboFlowerCategory.getSelectionModel().getSelectedItem().equalsIgnoreCase(flowerCategoryDTO.getStatus())) {
                    tableItem.getItems().addAll(flowerCategoryDTO);
                }

            }

    }

    @FXML
    void tableClickOnAction(MouseEvent event) {
        FlowerCategoryDTO flowerCategoryDTO = tableItem.getSelectionModel().getSelectedItem();
        double price = flowerCategoryDTO.getUnitPrice();
        String desc = flowerCategoryDTO.getDescription();
        int id = flowerCategoryDTO.getFCID();

        TempDTO tempDTO = new TempDTO(id, desc, price, Integer.parseInt(txtQty.getText()));

        selectItemTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("FCID"));
        selectItemTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("description"));
        selectItemTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        selectItemTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("qty"));
        selectItemTable.getItems().addAll(tempDTO);

    }


    private void loodTablr() {
        tableItem.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("FCID"));
        tableItem.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("description"));
        tableItem.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        tableItem.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("status"));


        try {
            tableItem.setItems(FXCollections.observableArrayList(flowerCategoryService.getAll()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private ComboBox<String> comboFlowerCategory;


    @FXML
    private JFXTextField txtCustomerNic;

    @FXML
    private JFXTextField txtCustomerId;

    @FXML
    private JFXTextField txtCustomerName;

    @FXML
    private JFXTextField txtCustomerAddress;

    @FXML
    private JFXTextField txtCustomerTell;

    @FXML
    private JFXTextField txtOrderId;

    @FXML
    private JFXTextField txtPaymentId;

    @FXML
    private JFXTextField txtStatus;
    @FXML
    private JFXTextField Customer_NIC;

    @FXML
    private JFXTextField txtTotal;

    @FXML
    private JFXTextField txtDiscount;

    @FXML
    private JFXTextField txtPayAmount;

    @FXML
    private JFXTextField txtBlance;

    @FXML
    private Label btnSave;

    @FXML
    private JFXComboBox<?> comboUserName;

    @FXML
    private JFXPasswordField password;

    @FXML
    private TableView<?> tableOrder;

    @FXML
    private Label btnCancle;

    @FXML
    private Label txtTime;

    @FXML
    private Label txtDate;

    @FXML
    void BlanceActionOnClick(ActionEvent event) {

    }

    @FXML
    void CustomerAddressActionOnClick(ActionEvent event) {

    }

    @FXML
    void CustomerTellActionOnClick(ActionEvent event) {
        CustomerDTO customerDTO = new CustomerDTO(Integer.parseInt(txtCustomerId.getText()), txtCustomerName.getText(), txtCustomerAddress.getText(), txtCustomerTell.getText(), txtCustomerNic.getText());
        System.out.println(Integer.parseInt(txtCustomerId.getText()));
        System.out.println(txtCustomerName.getText());
        System.out.println(txtCustomerAddress.getText());
        System.out.println(txtCustomerTell.getText());
        System.out.println(txtCustomerNic.getText());
//        sout
        boolean isAdded = false;
        try {
            isAdded = customerService.addCustomer(customerDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (isAdded) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Customer Added", ButtonType.OK);
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Customer Is Not Added", ButtonType.OK);
            alert.showAndWait();
        }
    }

    @FXML
    private JFXTextField txtSelect;


    @FXML
    void DiscountActionOnClick(ActionEvent event) {

    }

    @FXML
    void PaymentActionOnClick(ActionEvent event) {

    }

    @FXML
    void StatusActionOnClick(ActionEvent event) {

    }

    @FXML
    void btnCancleActionOnClick(MouseEvent event) {

    }

    @FXML
    void customerIdActionOnClick(ActionEvent event) {

    }

    @FXML
    void customerNameActionOnClick(ActionEvent event) {

    }

    @FXML
    private JFXTextField receptionId;


    @FXML
    void customerSearchActionOnClick(ActionEvent event) {
        try {
            CustomerDTO customerDTO = customerService.searchCustomer(Integer.parseInt(txtCustomerId.getText()));

            if (customerDTO != null) {
                txtCustomerNic.setText("" + customerDTO.getNic());
                txtCustomerName.setText("" + customerDTO.getName());
                txtCustomerAddress.setText("" + customerDTO.getAddress());
                txtCustomerTell.setText("" + customerDTO.getTell());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @FXML
    void payAmountActionOnClick(ActionEvent event) {

    }


    String floristID = "FI000";
    String status = "pending";

    @FXML
    void saveActionOnClick(MouseEvent event) {
        double fullAmount = Double.parseDouble(txtTotal.getText());
        double payment = Double.parseDouble(txtPayAmount.getText());
        int orderId = Integer.parseInt(txtOrderId.getText());
        int paymentId = Integer.parseInt(txtPaymentId.getText());

        String discount = txtDiscount.getText();
//        int qty=Integer.parseInt(txtQty.getText());
        String date = txtDate.getText();
        String time = txtTime.getText();
        int custId = Integer.parseInt(txtCustomerId.getText());


        PaymentDTO paymentDTO = new PaymentDTO(paymentId, fullAmount, date, discount, txtSelect.getText());
        System.out.println(paymentDTO);
        OrderDTO orderDTO = new OrderDTO(orderId, date, status,time, custId,floristID, paymentId, Integer.parseInt(receptionId.getText()));
        System.out.println(orderDTO);
        List<FlowerDetailsDTO> flowerDetailsDTOS = new ArrayList<>();
        for (int i = 0; i < selectItemTable.getItems().size(); i++) {
            int itemCode = (Integer) selectItemTable.getColumns().get(0).getCellObservableValue(i).getValue();
            System.out.println("code" + itemCode);
            String descrip = (String) selectItemTable.getColumns().get(1).getCellObservableValue(i).getValue();
            double unitPrice = (Double) selectItemTable.getColumns().get(2).getCellObservableValue(i).getValue();
            int qty = (Integer) selectItemTable.getColumns().get(3).getCellObservableValue(i).getValue();

            flowerDetailsDTOS.add(new FlowerDetailsDTO(qty, unitPrice, orderId, itemCode, descrip));
            System.out.println(flowerDetailsDTOS);
        }
        CommanDTO commanDTO = new CommanDTO(paymentDTO, orderDTO, flowerDetailsDTOS);
        System.out.println(commanDTO);

        boolean isAdded = false;
        try {
            isAdded = orderService.add(commanDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (isAdded) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Added Success", ButtonType.OK);
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Added Not Success", ButtonType.OK);
            alert.showAndWait();
        }
    }


    @FXML
    void totalActionOnClick(ActionEvent event) {

    }

    @FXML
    void txtOrderIdActionOnClick(ActionEvent event) {

    }

    @Override
    public void update(String mesage) throws Exception {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Platform.runLater(()->{
                    loodTablr();
                });
            }
        }).start();
    }


//    private void loardComboCategory() {
//        try {
//            ArrayList<String> array = flowerCategoryService.getCategory();
//            for (String type : array) {
//                boolean add = comboFlowerCategory.getItems().add(type);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }
//        try {
//            List<FlowerCategoryDTO> flowerCategoryDTOS = flowerCategoryService.getAll();
//            ArrayList<String> strings = new ArrayList<>();
//            for (FlowerCategoryDTO flowerCategoryDTO : flowerCategoryDTOS) {
//                strings.add(flowerCategoryDTO.getStatus());
//            }
//            for (String s : strings) {
//                while (s.equals("BirthDay")) {
//                    comboFlowerCategory.getItems().add(s);
//
//
//                }
//            }
        }




