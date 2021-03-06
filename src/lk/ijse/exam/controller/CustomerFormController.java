/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) UMart. All rights reserved.
 *  *  Licensed under the MIT License. See License.txt in the project root for license information.
 *  *--------------------------------------------------------------------------------------------
 */

package lk.ijse.exam.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import lk.ijse.exam.model.Customer;
import lk.ijse.exam.view.tm.CustomerTM;

import java.sql.SQLException;
import java.util.ArrayList;

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

    public void initialize() throws SQLException, ClassNotFoundException {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));

        loadAllCustomers();
    }

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
        CustomerController customerController = new CustomerController();
        try {
            Customer customer = customerController.searchCustomer(txtId.getText());
            if (customer!=null){
                if (new CustomerController().deleteCustomer(txtId.getText()))
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
        Customer c1 = new Customer(
                txtId.getText(), txtName.getText(), txtAddress.getText()
                , Double.parseDouble(txtSalary.getText())
        );
        try {
            if (new CustomerController().updateCustomer(c1)) {
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
        try {
            loadAllCustomers();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void loadAllCustomers() throws SQLException, ClassNotFoundException {
        ArrayList<Customer> list= new CustomerController().getAllCustomers();
        ObservableList<CustomerTM> obList = FXCollections.observableArrayList();
        for (Customer temp:list
        ) {
            obList.add(
                    new CustomerTM(temp.getId(),temp.getName(),temp.getAddress(),temp.getSalary())
            );
        }
        tblCustomer.setItems(obList);
    }
}
