/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sql;

import java.net.URL;
import java.sql.*;
import java.util.Calendar;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static sql.CreateDB.conn;
import static sql.SearchStudent.stmt;
/**
 *
 * @author jianlin
 */
public class StudentInfo {
    static Statement stmt=null;
    static ResultSet rs;
    static CreateDB createdb=new CreateDB();
    
    public static model.Student getInfo(int student_id){   
        createdb.createConnection();
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
        }
        model.Student student=new model.Student();
        // Get info from the database
        try {
            rs=stmt.executeQuery("select * from student where studentid="+student_id);
            rs.next();
            
            student.setStudentID(student_id);
            student.setName(rs.getString("name"));
            student.setAge(rs.getInt("age"));
            student.setGender(rs.getString("gender"));
            student.setProgram(rs.getString("program"));
            student.setNationality(rs.getString("nationalities"));
            student.setUrl(rs.getString("url"));
            //conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return student;
    }
    
    public static void setInfo(model.Student student){
//        CreateDB createdb=new CreateDB();
//        createdb.createConnection();
//        try {
//            stmt = conn.createStatement();
//        } catch (SQLException ex) {
//        }
        
        try {
            String sql="update student set name='"+student.getName()
                    +"', age="+student.getAge()
                    +", nationalities='"+student.getNationality()
                    +"', program='"+student.getProgram()
                    +"', gender='"+student.getGender()
                    +"' where studentid="+student.getStudetID();
            int result = stmt.executeUpdate(sql);
            
           if (result >0) JOptionPane.showConfirmDialog(null, "Successfully saved!");
          // conn.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    
}
