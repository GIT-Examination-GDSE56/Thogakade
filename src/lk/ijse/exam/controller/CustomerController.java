/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) UMart. All rights reserved.
 *  *  Licensed under the MIT License. See License.txt in the project root for license information.
 *  *--------------------------------------------------------------------------------------------
 */

package lk.ijse.exam.controller;

import lk.ijse.exam.model.Customer;
import lk.ijse.exam.utils.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Ushan Shanilka <ushanshanilka80@gmail.com>
 * @since 10/9/2021
 **/
public class CustomerController {
    public boolean saveCustomer(Customer c) throws ClassNotFoundException, SQLException {
        return CrudUtil.execute("INSERT INTO Customer VALUES (?,?,?,?)",c.getId(),c.getName(),c.getAddress(),c.getSalary());
    }


}
