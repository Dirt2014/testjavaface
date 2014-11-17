/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import java.sql.*;
import java.util.Calendar;
import java.util.Properties;

/**
 *
 * @author fanyuting
 */
public class SearchStudent {

    public static Connection conn = null;
    PreparedStatement psInsert;
    PreparedStatement psUpdate;
    Statement s;
    Statement s1;
    Statement s2;
    Statement s3;
    Statement s4;
    ResultSet rs = null;
    Properties props = new Properties();
    String dbName = "FaceRecognizeDB";

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

    public int getFrequency(Calendar date1, Calendar date2, String category, String gender){
        int frequency = 0;

        try{
            conn = DriverManager.getConnection("jdbc:derby"+dbName+"create = false"+props);
            s1 = conn.createStatement();
            rs = s1.executeQuery("SELECT COUNT(visitID) AS frequency FROM visit where date>"+date1.getTime().getTime()+
                    "AND date<"+date2.getTime().getTime());

            conn.commit();

            frequency = rs.getInt("frequency");
            System.out.println("frequency");

        }catch(SQLException ex){

        }

        return frequency;

    }

    public void close() throws SQLException {
        conn.close();
    }

}
