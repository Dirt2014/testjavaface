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
public class CreateDB {

    //static String dbURL = "jdbc:derby:faceDB;create=true;user=fan;password=fan";
    static Connection conn = null;
    static Statement stmt = null;
    static PreparedStatement psInsert;
    ResultSet rs = null;

    public static void createConnection() {
        Properties props = new Properties();
        String dbName = "FaceDB";
        props.put("user", "");
        props.put("password", "");
        try {
            conn = DriverManager.getConnection("jdbc:derby:" + dbName
                    + ";create=true", props);
        } catch (Exception except) {
            except.printStackTrace();
        }
    }

    public void createDB() {
        try {
            //create table student
            stmt.executeUpdate("create table student(StudentID int, Name varchar(40), "
                    + "Gender varchar(40), Program varchar(40), Age int, "
                    + "Nationalities varchar(40), primary key(StudentID))");
            psInsert = conn.prepareStatement("insert into student values (?, ?, ?, ?, ?, ?)");

            String[] FirstNames = {"Bob", "Jill", "Tom", "Brandon", "Joan", "Ethel", "Albert", "Hpward", "Roy", "Annie", "Alice", "Ruby", "Donald", "Carl", "Bonnie", "Lisa", "Scott", "Sean", "Morgan", "Oliva"};
            String[] LastNames = {"Matthew", "Nathan", "Aaron", "Zachary", "Jadon", "Matteo", "Harrison", "Titus", "Magnus", "Jax", "Jude", "Dexter", "Sawyer", "Beckett", "Miles", "Land", "Letitia", "Leopold", "Louise", "Lucretia"};
            String[] Gender = {"Male", "Female"};
            String[] Programs = {"MISM", "MSPPM", "MSIT"};
            String[] Nationalities = {"China", "Japan", "USA", "Korea", "Australia", "India"};

            for (int i = 1; i < 85; i++) {
                psInsert.setInt(1, i);
                int index1 = (int) (Math.random() * FirstNames.length);
                int index2 = (int) (Math.random() * LastNames.length);
                psInsert.setString(2, FirstNames[index1] + " " + LastNames[index2]);
                int index3 = (int) (Math.random() * Gender.length);
                psInsert.setString(3, Gender[index3]);
                int index4 = (int) (Math.random() * Programs.length);
                psInsert.setString(4, Programs[index4]);
                int age = (int) (20 + Math.random() * 10);
                psInsert.setInt(5, age);
                int index6 = (int) (Math.random() * Nationalities.length);
                psInsert.setString(6, Nationalities[index6]);

                psInsert.executeUpdate();
            }

            //create table visit
            stmt.executeUpdate("create table visit(VisitID int, StudentID int, "
                    + "date long(40), category varchar(40), primary key(VisitID))");
            psInsert = conn.prepareStatement("insert into visit values (?, ?, ?, ?)");  

            String[] Categories = {"stapler", "tuition fee", "complaints", "collect assignments", "meet people"};

            for (int i = 1; i < 1001; i++) {
                psInsert.setInt(1, i);
                int index2 = (int) (1 + Math.random() * 85);
                psInsert.setInt(2, index2);
                Calendar calendar = randomDateBetweenMinAndMax();
                psInsert.setLong(3, calendar.getTime().getTime());
                int index4 = (int) (Math.random() * Categories.length);
                psInsert.setString(4, Categories[index4]);
                psInsert.executeUpdate();
            }
            conn.commit();
        } catch (Exception except) {
            except.printStackTrace();
        }
    }

    public static Calendar randomDateBetweenMinAndMax() {
        Calendar calendar = Calendar.getInstance();
        //注意月份要减去1  
        calendar.set(2000, 11, 31);
        calendar.getTime().getTime();
        //根据需求，这里要将时分秒设置为0  
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        long min = calendar.getTime().getTime();
        calendar.set(2014, 11, 12);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.getTime().getTime();
        long max = calendar.getTime().getTime();
        //得到大于等于min小于max的double值  
        double randomDate = Math.random() * (max - min) + min;
        //将double值舍入为整数，转化成long类型  
        calendar.setTimeInMillis(Math.round(randomDate));
        return calendar;
    }

    public void shutdown() {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                //DriverManager.getConnection(dbURL + ";shutdown=true");
                conn.close();
            }
        } catch (SQLException sqlExcept) {

        }
    }
}
