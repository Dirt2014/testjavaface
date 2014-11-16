/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import java.sql.*;
import java.util.ArrayList;
import static sql.CreateDB.*;

/**
 *
 * @author fanyuting
 */
public class SearchStudent {
    private ArrayList<model.Visit> stuVisitList = new ArrayList<model.Visit>();
    //flag is used to check whether this student has visit history
    public boolean flag=false;
    
    public SearchStudent(int ID) {
        //receive the studentID, fromDate, toDate and category index from VisitorFrame
        //search database
        //store the result in arraylist and pass to VisitorFrame
        CreateDB createdb=new CreateDB();
        try {
            createdb.createConnection();
            createdb.createDB();
            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM FaceDB.visit WHERE STUDENTID=" + ID);
            
            while (results.next()) {
                //int id = results.getInt(1);
                flag=true;
                long date = results.getLong(2);
                String category=results.getString(3);
                int solved=results.getInt(4);
                
                model.Visit stuVisit = new model.Visit();
                stuVisit.setStudentID(ID);
                stuVisit.setDate(date);
                stuVisit.setCategory(category);
                stuVisit.setSolved(solved);
                stuVisitList.add(stuVisit);
                System.out.println(ID);
                System.out.println(date);
                System.out.println(category);
                System.out.println(solved);
            }
            results.close();
            stmt.close();
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }
        createdb.shutdown();
    }
}
