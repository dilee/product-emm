/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.emm.agent.omadm.dm.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.wso2.emm.agent.omadm.dm.core.dmtree.beans.MgmtTree;
import org.wso2.emm.agent.utils.Constants;
import org.wso2.emm.agent.utils.DatabaseHelper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * This is a mock DAO class written to mimic a RDBMS
 */
public class DeviceMODao {

    private static final String TAG = DeviceMODao.class.getSimpleName();

    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;

    public DeviceMODao(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public void open() throws SQLException {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    /**
     * Adds a Management Tree to the database
     *
     * @param tree Management Tree object
     */
    public void addMO(MgmtTree tree) {
        ContentValues values = new ContentValues();
        values.put(Constants.OMADMTable.MO_NAME, tree.getName());
        values.put(Constants.OMADMTable.VALUE, serialize(tree));
    }

    /**
     * Retrieves a Management Tree from the database
     *
     * @param moName Name of the Management Tree
     * @return Requested Management tree
     */
    public MgmtTree getTree(String moName) {
        Cursor result = db.rawQuery("SELECT * FROM " + Constants.OMADMTable.NAME +
                " WHERE moname = " + moName, null);
        if (result.getCount() > 0) {
            result.moveToFirst();

            MgmtTree tree = (MgmtTree) deserialize(result.getBlob(result.getColumnIndex(
                    Constants.OMADMTable.VALUE)));
            return tree;
        }
        return null;
    }

    /**
     * Updates a Management Tree in the Database
     *
     * @param tree Management Tree Object
     * @return True if successful, False if failed
     */
    public boolean updateTree(MgmtTree tree) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constants.OMADMTable.VALUE, serialize(tree));
        return db.update(Constants.NotificationTable.NAME, contentValues, Constants.OMADMTable.
                MO_NAME + "=" + tree.getName(), null) > 0;
    }

    /**
     * Serialize objects
     *
     * @param obj Object to be serialized
     * @return Object as a byte array
     */
    private static byte[] serialize(Object obj) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutput out = null;

        try {
            out = new ObjectOutputStream(bos);
            out.writeObject(obj);
            out.close();
            byte[] bytes = bos.toByteArray();

            return bytes;
        } catch (IOException e) {
            Log.e(TAG, e.getMessage(), e);
        }
        return null;
    }

    /**
     * Deserializes a byte array into an object
     *
     * @param bytes Object byte array
     * @return Deserialized object
     */
    private static Object deserialize(byte[] bytes) {
        ObjectInputStream in = null;
        Object object = null;
        try {
            in = new ObjectInputStream(new ByteArrayInputStream(bytes));
            object = in.readObject();
            in.close();

            return object;
        } catch (ClassNotFoundException e) {
            Log.e(TAG, e.getMessage(), e);
        } catch (IOException e) {
            Log.e(TAG, e.getMessage(), e);
        }
        return null;
    }

}
