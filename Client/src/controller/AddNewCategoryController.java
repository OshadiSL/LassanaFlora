package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dto.FlowerCategoryDTO;
import dto.FlowerCategoryTupeDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.hibernate.Session;
import proxy.ProxyHandeler;
import resources.HibUtil;
import service.ServiceFactory;
import service.custom.FlowerCategoryService;
import service.custom.FlowerCategoryTypeService;

import java.io.IOException;
import java.net.URL;
import java.rmi.Remote;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AddNewCategoryController implements Initializable, Remote {

  FlowerCategoryService flowerCategoryService;
  FlowerCategoryTypeService flowerCategoryTypeService;


    {
        try {
          flowerCategoryTypeService=ProxyHandeler.getInstance().getSuperService(ServiceFactory.ServiceTypes.FLOWERCATEGORYTYPE);
           flowerCategoryService= ProxyHandeler.getInstance().getSuperService(ServiceFactory.ServiceTypes.FLOWERCATEGORY);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        getFlowerCategory();
//
        getLoardCombo();






    }
    @FXML
    private Label addnewCategoryBtn;

    @FXML
    void nexPageActionOnClick(MouseEvent event) throws IOException {
//        AnchorPane root = FXMLLoader.load(this.getClass().getResource("/views/AddItem.fxml"));
//        Scene scene = new Scene(root);
//
//        Stage stage= (Stage) this.addnewCategoryBtn.getScene().getWindow();
//        stage.centerOnScreen();
//        stage.setScene(scene);
//        stage.show();
        Parent parent=FXMLLoader.load(this.getClass().getResource("/views/AddItem.fxml"));
        Scene scene=new Scene(parent);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }

    private void getLoardCombo() {
        List<FlowerCategoryTupeDTO>flowerCategoryTupeDTOS= null;
        try {
            flowerCategoryTupeDTOS = flowerCategoryTypeService.getAll();

        ArrayList<String>arrayList=new ArrayList<>();
        for(FlowerCategoryTupeDTO flowerCategoryTupeDTO:flowerCategoryTupeDTOS){
            arrayList.add(flowerCategoryTupeDTO.getName());

        }
        for (String f:arrayList){
            categoryCombo.getItems().add(f);
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void getFlowerCategory() {
        tableCategory.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("FCID"));
        tableCategory.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("description"));
        tableCategory.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        tableCategory.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("status"));


        try {
            tableCategory.setItems(FXCollections.observableArrayList(flowerCategoryService.getAll()));
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    @FXML
    private JFXTextField txtFlowerId;

    @FXML
    private JFXTextField txtFlowerName;

    @FXML
    private TableView<?> FlowerItemTable;

    @FXML
    private JFXButton btnCategoryAdd;

    @FXML
    private JFXButton btnCtegoryDelete;

    @FXML
    private JFXButton btnCategoryUpdate;

    @FXML
    private TableView<FlowerCategoryDTO> tableCategory;

    @FXML
    private JFXTextField txtCategoryId;

    @FXML
    private JFXTextField txtDescription;

    @FXML
    private JFXTextField txtUnitPriceCatrgory;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton updatebtn;
    @FXML
    private JFXTextField txtTypeCategory;
    @FXML
    private JFXComboBox<String> categoryCombo;
    @FXML
    void UpdateActionOnClick(ActionEvent event) {

    }

    @FXML
    void addOnActionClick(ActionEvent event) {
//
    }

    @FXML
    void deleteActionOnClick(ActionEvent event) {

    }

    @FXML
    void searchOnAction(ActionEvent event) {

    }

    @FXML
    void AddActionOnClick(ActionEvent event) {
        try{
            FlowerCategoryDTO flowerCategoryDTO=new FlowerCategoryDTO(Integer.parseInt(txtCategoryId.getText()),txtDescription.getText(),Double.parseDouble(txtUnitPriceCatrgory.getText()),categoryCombo.getSelectionModel().getSelectedItem());
            boolean isAdded=flowerCategoryService.add(flowerCategoryDTO);
            if(isAdded){
                Alert alert=new Alert(Alert.AlertType.INFORMATION,"Added Success", ButtonType.OK);
                alert.showAndWait();
                getFlowerCategory();
            }else {
                Alert alert=new Alert(Alert.AlertType.INFORMATION,"Added NotSuccess", ButtonType.OK);
                alert.showAndWait();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    void SearchAcitionOnClick(ActionEvent event) {
        try{
            FlowerCategoryDTO flowerDTO=flowerCategoryService.search(Integer.parseInt(txtCategoryId.getText()));

            if(flowerDTO!=null){
                txtDescription.setText(""+flowerDTO.getDescription());
                txtUnitPriceCatrgory.setText(""+flowerDTO.getUnitPrice());
                categoryCombo.getItems().add(""+flowerDTO.getStatus());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void detectAcrionOnClick(ActionEvent event) {
        FlowerCategoryDTO flowerCategoryDTO=new FlowerCategoryDTO(Integer.parseInt(txtCategoryId.getText()),txtDescription.getText(),Double.parseDouble(txtUnitPriceCatrgory.getText()),categoryCombo.getSelectionModel().getSelectedItem());


        try {
            boolean isdelete = flowerCategoryService.delete(flowerCategoryDTO);

            if (isdelete) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Delete SuccessFull", ButtonType.OK);
                alert.showAndWait();
                getFlowerCategory();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Delete Not SuccessFull", ButtonType.OK);
                alert.showAndWait();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

       }

    @FXML
    void updateActionOnClick(ActionEvent event) {
        try {
            FlowerCategoryDTO flowerCategoryDTO = new FlowerCategoryDTO(Integer.parseInt(txtCategoryId.getText()), txtDescription.getText(), Double.parseDouble(txtUnitPriceCatrgory.getText()),categoryCombo.getSelectionModel().getSelectedItem());
            boolean isupdate=flowerCategoryService.update(flowerCategoryDTO);
            if (isupdate){
                Alert alert=new Alert(Alert.AlertType.INFORMATION,"Update Category",ButtonType.OK);
                alert.show();
                getFlowerCategory();
            }else {
                Alert alert=new Alert(Alert.AlertType.INFORMATION,"Update Field",ButtonType.OK);
                alert.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
