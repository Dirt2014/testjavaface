/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Properties;
import static sql.CreateDB.*;

/**
 *
 * @author fanyuting
 */
public class SearchStudent {

    //public static Connection conn = null;
    static Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement psInsert;
    PreparedStatement psUpdate;
    Statement s;
    Statement s1;
    Statement s2;
    Statement s3;
    Statement s4;
    Properties props = new Properties();
    String dbName = "FaceRecognizeDB";

    //public SearchStudent() {
    private ArrayList<model.Visit> stuVisitList = new ArrayList<model.Visit>();
    //flag is used to check whether this student has visit history
    public boolean flag = false;

    public SearchStudent(int ID, String startDate, String endDate) {
        //receive the studentID, fromDate, toDate and category index from VisitorFrame
        //search database
        //store the result in arraylist and pass to VisitorFrame
        CreateDB createdb=new CreateDB();
        try {
            createdb.createConnection();
            stmt = conn.createStatement();
            String selectSql = "SELECT * FROM VISIT WHERE (StudentID=" + ID+") AND (DATE BETWEEN '"+startDate+"' AND '"+endDate+"')";
            ResultSet results = stmt.executeQuery(selectSql);

            while (results.next()) {
                flag = true;
                Date date = results.getDate("date");
                String category = results.getString(4);
                int solved = results.getInt(5);

                model.Visit stuVisit = new model.Visit();
                stuVisit.setStudentID(ID);
                stuVisit.setDate(date);
                stuVisit.setCategory(category);
                stuVisit.setSolved(solved);
                stuVisitList.add(stuVisit);
            }
            results.close();
            stmt.close();
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }
        createdb.shutdown();
    }

    public ArrayList<model.Visit> getVisitList(){
        return stuVisitList;
    }
    
    public int getFrequency(Calendar date1, Calendar date2, String category, String gender) {
        int frequency = 0;

        try {
            conn = DriverManager.getConnection("jdbc:derby" + dbName + "create = false" + props);
            s1 = conn.createStatement();
            rs = s1.executeQuery("SELECT COUNT(visitID) AS frequency FROM visit where date>" + date1.getTime().getTime()
                    + "AND date<" + date2.getTime().getTime());

            conn.commit();

            frequency = rs.getInt("frequency");
            System.out.println("frequency");

        } catch (SQLException ex) {

        }

        return frequency;

    }
}

//    public void close() throws SQLException {
//        conn.close();
//    }

