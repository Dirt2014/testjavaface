/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import static sql.CreateDB.conn;
import static sql.StudentInfo.createdb;
import static sql.StudentInfo.rs;
import static sql.StudentInfo.stmt;

/**
 *
 * @author jianlin
 */
public class reg {
    static Statement stmt=null;
    static ResultSet rs;
    static CreateDB createdb=new CreateDB();
    
    public static int register(model.Student student){
        
        createdb.createConnection();
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
        }
        try{
            
            rs=stmt.executeQuery("select * from student");
            rs.last();
            String sql="insert into student (studentid, name, program,age, gender, nationalities,url) values("
                    + (rs.getInt("studentid")+1)
                    +", '"+student.getName()
                    +"', '"+student.getProgram()
                    +"', "+student.getAge()
                    + ", '"+student.getGender()
                    + "', '"+student.getNationality()
                    + "', '"+student.getUrl()
                    + "')";
                    
            int result = stmt.executeUpdate(sql);
            
           if (result >0) JOptionPane.showConfirmDialog(null, "Successfully registered!");
           return rs.getInt("studentid")+1;
        }
        catch(Exception e){
            System.out.println("Excepetion in reg.");
    }
    }
}
