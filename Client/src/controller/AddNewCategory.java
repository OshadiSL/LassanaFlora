package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dto.FlowerCategoryTupeDTO;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import proxy.ProxyHandeler;
import service.ServiceFactory;
import service.custom.FlowerCategoryTypeService;

import java.net.URL;
import java.rmi.Remote;
import java.util.ResourceBundle;

public class AddNewCategory  implements Initializable, Remote {
    FlowerCategoryTypeService flowerCategoryTypeService;


    {
        try {
            flowerCategoryTypeService= ProxyHandeler.getInstance().getSuperService(ServiceFactory.ServiceTypes.FLOWERCATEGORYTYPE);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getAllCategory();
    }

    private void getAllCategory() {


        FlowerItemTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        FlowerItemTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));


            try {
                FlowerItemTable.setItems(FXCollections.observableArrayList(flowerCategoryTypeService.getAll()));
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    @FXML
    private JFXTextField txtFlowerId;

    @FXML
    private JFXTextField txtFlowerName;

    @FXML
    private TableView<FlowerCategoryTupeDTO> FlowerItemTable;

    @FXML
    private JFXButton btnCategoryAdd;

    @FXML
    private JFXButton btnCtegoryDelete;

    @FXML
    private JFXButton btnCategoryUpdate;

    @FXML
    void UpdateActionOnClick(ActionEvent event) {

    }

    @FXML
    void addOnActionClick(ActionEvent event) {
        FlowerCategoryTupeDTO flowerCategoryDTO=new FlowerCategoryTupeDTO(txtFlowerId.getText(),txtFlowerName.getText());
        boolean isAdded= false;
        try {
            isAdded = flowerCategoryTypeService.addCategoryType(flowerCategoryDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(isAdded){
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Added Success",ButtonType.OK);
            alert.showAndWait();
            getAllCategory();
        }else {
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Not Added", ButtonType.OK);
            alert.showAndWait();
        }
    }

    @FXML
    void deleteActionOnClick(ActionEvent event) {
        FlowerCategoryTupeDTO flowerCategoryDTO=new FlowerCategoryTupeDTO(txtFlowerId.getText(),txtFlowerName.getText());


        try {
            boolean isdelete = flowerCategoryTypeService.delete(flowerCategoryDTO);

            if (isdelete) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Delete SuccessFull", ButtonType.OK);
                alert.showAndWait();
                getAllCategory();
//                getFlowerCategory();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Delete Not SuccessFull", ButtonType.OK);
                alert.showAndWait();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    void searchOnAction(ActionEvent event) {
        try{
            FlowerCategoryTupeDTO flowerDTO=flowerCategoryTypeService.search2(txtFlowerId.getText());

            if(flowerDTO!=null){
                txtFlowerName.setText(""+flowerDTO.getName());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
