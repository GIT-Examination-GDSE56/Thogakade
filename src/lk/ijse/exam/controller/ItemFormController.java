/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) UMart. All rights reserved.
 *  *  Licensed under the MIT License. See License.txt in the project root for license information.
 *  *--------------------------------------------------------------------------------------------
 */

package lk.ijse.exam.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import lk.ijse.exam.model.Customer;
import lk.ijse.exam.model.Item;


import java.sql.SQLException;

/**
 * @author Ushan Shanilka <ushanshanilka80@gmail.com>
 * @since 10/9/2021
 **/
public class ItemFormController {
    public JFXTextField txtCode;
    public JFXTextField txtDesc;
    public JFXTextField txtUnitPrice;
    public JFXTextField txtQtyOnHand;
    public JFXButton btnSaveItem;
    public JFXButton btnDelete;
    public JFXButton btnUpdate;
    public JFXButton btnGetAll;
    public TableView tblItem;
    public TableColumn colCode;
    public TableColumn colDesc;
    public TableColumn colUnitPrice;
    public TableColumn colQtyOnHand;

    public void searchItem(ActionEvent actionEvent) {
        try {

            Item i1= new ItemController().searchItem(txtCode.getText());

            if (i1!=null){
                txtDesc.setText(i1.getDescription());
                txtUnitPrice.setText(String.valueOf(i1.getUntPrice()));
                txtQtyOnHand.setText(String.valueOf(i1.getQtyOnHand()));
            }else{
                new Alert(Alert.AlertType.WARNING, "Empty Result").show();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void SaveItemOnAction(ActionEvent actionEvent) {
        Item i1 = new Item(
                txtCode.getText(),
                txtDesc.getText(),
                Double.parseDouble(txtUnitPrice.getText()),
                Integer.parseInt(txtQtyOnHand.getText())
        );
        try {
            if (new ItemController().saveItem(i1))
                new Alert(Alert.AlertType.CONFIRMATION, "Saved").show();
            else
                new Alert(Alert.AlertType.WARNING, "Try Again").show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void DeleteOnAction(ActionEvent actionEvent) {
        ItemController itemController = new ItemController();
        try {
            Item item = itemController.searchItem(txtCode.getText());
            if (item!=null){
                if (new ItemController().deleteItem(txtCode.getText()))
                    new Alert(Alert.AlertType.CONFIRMATION, "Deleted").show();
                else
                    new Alert(Alert.AlertType.WARNING, "Try Again").show();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void UpdateOnAction(ActionEvent actionEvent) {
        Item i1 = new Item(
                txtCode.getText(), txtDesc.getText(),Double.parseDouble(txtUnitPrice.getText()),
                Integer.parseInt(txtQtyOnHand.getText())
        );
        try {
            if (new ItemController().updateItem(i1)) {
                new Alert(Alert.AlertType.CONFIRMATION, "Updated...").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Try Again...").show();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void getAllOnAction(ActionEvent actionEvent) {
    }
}
