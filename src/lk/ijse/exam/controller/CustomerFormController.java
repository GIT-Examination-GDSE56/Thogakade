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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.exam.model.Customer;

import java.sql.SQLException;

/**
 * @author Ushan Shanilka <ushanshanilka80@gmail.com>
 * @since 10/9/2021
 **/
public class CustomerFormController {
    public AnchorPane root;
    public JFXTextField txtId;
    public JFXTextField txtName;
    public JFXTextField txtAddress;
    public JFXTextField txtSalary;
    public JFXButton btnSaveCustomer;
    public JFXButton btnDelete;
    public JFXButton btnUpdate;
    public JFXButton btnGetAll;
    public TableView tblCustomer;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colSalary;
    public ImageView btnHome;

    public void searchCustomer(ActionEvent actionEvent) {
        try {

            Customer c1= new CustomerController().searchCustomer(txtId.getText());

            if (c1!=null){
                txtName.setText(c1.getName());
                txtAddress.setText(c1.getAddress());
                txtSalary.setText(String.valueOf(c1.getSalary()));
            }else{
                new Alert(Alert.AlertType.WARNING, "Empty Result").show();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void SaveCustomerOnAction(ActionEvent actionEvent) {
        Customer c1 = new Customer(
                txtId.getText(),
                txtName.getText(),
                txtAddress.getText(),
                Double.parseDouble(txtSalary.getText())
        );
        try {

            if (new CustomerController().saveCustomer(c1))
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
    }

    public void UpdateOnAction(ActionEvent actionEvent) {
    }

    public void getAllOnAction(ActionEvent actionEvent) {
    }

    public void btnHomeOnAction(MouseEvent mouseEvent) {
    }
}
