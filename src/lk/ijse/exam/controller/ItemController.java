/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) UMart. All rights reserved.
 *  *  Licensed under the MIT License. See License.txt in the project root for license information.
 *  *--------------------------------------------------------------------------------------------
 */

package lk.ijse.exam.controller;

import lk.ijse.exam.model.Item;
import lk.ijse.exam.utils.CrudUtil;

import java.sql.SQLException;

/**
 * @author Ushan Shanilka <ushanshanilka80@gmail.com>
 * @since 10/9/2021
 **/
public class ItemController {
    public boolean saveItem(Item item) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO Item VALUES (?,?,?,?)",item.getCode(),item.getDescription(),item.getUntPrice(),item.getQtyOnHand());

    }
}
