package controller;

import com.jfoenix.controls.JFXTextField;
import dto.FlowerCategoryDTO;
import dto.FlowerDetailsDTO;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import proxy.ProxyHandeler;
import service.ServiceFactory;
import service.custom.OrderDetailsService;

import java.net.URL;
import java.rmi.Remote;
import java.util.List;
import java.util.ResourceBundle;

public class ItemSearchController  implements Initializable, Remote {
    OrderDetailsService orderDetailsService;


    {
        try {
            orderDetailsService= ProxyHandeler.getInstance().getSuperService(ServiceFactory.ServiceTypes.FLOWERDETAILS);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private JFXTextField txtSearchBar;

    @FXML
    private TableView<FlowerDetailsDTO> itemTable;

    @FXML
    void enterSearchOnActionClick(ActionEvent event) {
        itemTable.getItems().clear();
        List<FlowerDetailsDTO> all = null;
        try {
            all = orderDetailsService.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (FlowerDetailsDTO flowerCategoryDTO : all) {
            System.out.println(flowerCategoryDTO.getOid());
            if (txtSearchBar.getText().equalsIgnoreCase(""+flowerCategoryDTO.getOid())) {
                itemTable.getItems().addAll(flowerCategoryDTO);
            }

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loardTable();
    }

    private void loardTable() {

        itemTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("oid"));
        itemTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        itemTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("orderQty"));
        itemTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        itemTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("flowerName"));
//        itemTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));


        try {
            itemTable.setItems(FXCollections.observableArrayList(orderDetailsService.getAll()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
