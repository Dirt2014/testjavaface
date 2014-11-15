/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import static sql.Database.*;
import java.sql.*;
import java.util.Calendar;
import java.util.Properties;

/**
 *
 * @author fanyuting
 */
public class SearchStudent {

    String dbName = "FaceDB";

    public SearchStudent() {

        /*
         * This connection specifies create=true in the connection URL to
         * cause the database to be created when connecting for the first
         * time. 
         */
        //receive the studentID, fromDate, toDate and category index from VisitorFrame
        //search database
        //store the result in arraylist and pass to VisitorFrame
    }

    public void close() throws SQLException {
        conn.close();
    }

}
