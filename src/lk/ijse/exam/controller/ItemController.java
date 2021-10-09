/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) UMart. All rights reserved.
 *  *  Licensed under the MIT License. See License.txt in the project root for license information.
 *  *--------------------------------------------------------------------------------------------
 */

package lk.ijse.exam.controller;

import lk.ijse.exam.model.Customer;
import lk.ijse.exam.model.Item;
import lk.ijse.exam.utils.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Ushan Shanilka <ushanshanilka80@gmail.com>
 * @since 10/9/2021
 **/
public class ItemController {
    public boolean saveItem(Item item) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO Item VALUES (?,?,?,?)",item.getCode(),item.getDescription(),item.getUntPrice(),item.getQtyOnHand());

    }

    public Item searchItem(String code) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Item WHERE code=?",code);
        if (rst.next()) {
            return new Item(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getDouble(3),
                    rst.getInt(4)
            );
        }
        return null;
    }

    public boolean deleteItem(String code) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM Item WHERE code=?", code);
    }

    public boolean updateItem(Item i) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?", i.getDescription(),i.getUntPrice(),i.getQtyOnHand(), i.getCode());

    }
}
