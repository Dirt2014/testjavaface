/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import java.sql.*;
import java.sql.Date;
import java.util.*;

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

    public SearchStudent() {
    }
    private ArrayList<model.Visit> stuVisitList = new ArrayList<model.Visit>();

    public SearchStudent(int ID, String startDate, String endDate) {
        //receive the studentID, fromDate, toDate and category index from VisitorFrame
        //search database
        //store the result in arraylist and pass to VisitorFrame
        CreateDB createdb = new CreateDB();
        try {
            createdb.createConnection();
            stmt = conn.createStatement();
            String selectSql = "SELECT * FROM VISIT WHERE (StudentID=" + ID + ") AND (DATE BETWEEN '" + startDate + "' AND '" + endDate + "')";
            ResultSet results = stmt.executeQuery(selectSql);

            while (results.next()) {
                Date date = results.getDate("date");
                String category = results.getString(4);
                int solved = results.getInt(5);
                String comments=results.getString(6);

                model.Visit stuVisit = new model.Visit();
                //stuVisit.setStudentID(ID);
                stuVisit.setDate(date);
                stuVisit.setCategory(category);
                stuVisit.setSolved(solved);
                stuVisit.setComments(comments);
                stuVisitList.add(stuVisit);
            }
            results.close();
            stmt.close();
        } catch (SQLException sqlExcept) {
            System.out.println(sqlExcept.getMessage());
        }
        createdb.shutdown();
    }
    
    public ArrayList<model.Visit> searchVisitByCategory(int ID, String category, String startDate, String endDate) {
        //receive the studentID, fromDate, toDate and category index from VisitorFrame
        //search database
        //store the result in arraylist and pass to VisitorFrame
        CreateDB createdb = new CreateDB();
        System.out.println(category);
        try {
            createdb.createConnection();
            stmt = conn.createStatement();
            String selectSql = "SELECT * FROM VISIT WHERE (StudentID=" + ID + ") AND (DATE BETWEEN '" + startDate + "' AND '" + endDate + "') AND (CATEGORY='"+category+"')";
            ResultSet results = stmt.executeQuery(selectSql);

            while (results.next()) {
                Date date = results.getDate("date");
                //String category = results.getString(4);
                int solved = results.getInt(5);
                String comments=results.getString(6);

                model.Visit stuVisit = new model.Visit();
                //stuVisit.setStudentID(ID);
                stuVisit.setDate(date);
                stuVisit.setCategory(category);
                stuVisit.setSolved(solved);
                stuVisit.setComments(comments);
                stuVisitList.add(stuVisit);
            }
            results.close();
            stmt.close();
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }
        createdb.shutdown();
        return stuVisitList;
    }

    public ArrayList<model.Visit> getVisitList() {
        return stuVisitList;
    }

    public int getFrequency(java.util.Date date1, java.util.Date date2, String category, String gender) {
        int frequency = 0;
        try {
            conn = DriverManager.getConnection("jdbc:derby:" + dbName + ";create = false", props);
            s1 = conn.createStatement();

            psInsert = conn.prepareStatement("SELECT COUNT(visitID) AS frequency "
                    + "FROM visit LEFT JOIN student ON visit.StudentID = student.StudentID "
                    + "WHERE (date BETWEEN ? AND ?) AND category=? AND Gender=?");
            conn.commit();
            java.sql.Date date1Sql = new java.sql.Date(date1.getTime());
            java.sql.Date date2Sql = new java.sql.Date(date2.getTime());

            psInsert.setDate(1, date1Sql);
            psInsert.setDate(2, date2Sql);
            psInsert.setString(3, category);
            psInsert.setString(4, gender);

            rs = psInsert.executeQuery();

            rs.next();//default pointer return 0, even if you want to get the first data, you should use .next();
            frequency = rs.getInt("frequency");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return frequency;

    }
}
