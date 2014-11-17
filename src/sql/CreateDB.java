package sql;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author fuyun
 */
import java.sql.*;
import java.util.Calendar;
import java.util.Properties;

public class CreateDB {

    //static String dbURL = "jdbc:derby:faceDB;create=true;user=fan;password=fan";
    static Connection conn = null;
    //static Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement psInsert;
    PreparedStatement psUpdate;
    static Statement s;
    //static Statement s1;
    static Statement s2;
//    static Statement s3;
//    static Statement s4;
    static Properties props = new Properties();
    static String dbName = "FaceRecognizeDB";

    public static void createConnection() {
        props.put("user", "");
        props.put("password", "");
        try {
            conn = DriverManager.getConnection("jdbc:derby:" + dbName
                    + ";create=true", props);
            conn.setAutoCommit(false);
            s = conn.createStatement();
//            s.executeQuery("DROP table student");
//            s.executeQuery("DROP table visit");
        } catch (SQLException e) {
            //e.printStackTrace();
        }
    }

    public void CreateDB() {
        // table student
        createConnection();
        try {
            s.executeUpdate("create table student(StudentID int, Name varchar(40), "
                    + "Gender varchar(40), Program varchar(40), Age int, "
                    + "Nationalities varchar(40), primary key(StudentID))");

        } catch (SQLException e) {
            System.out.println("Table student already exists.");
        }

        try {
            s = conn.createStatement();
            rs = s.executeQuery("SELECT * FROM student");
            conn.commit();

            if (!rs.next()) {
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
                    conn.commit();
                }
            }
        } catch (SQLException e) {
            System.out.println("Table student doesn't exist.");
        }

        //table visit
        try {
            s2 = conn.createStatement();
            s2.executeUpdate("create table visit(VisitID int, StudentID int, "
                    + "date date, category varchar(40),solved int)");
            conn.commit();
        } catch (SQLException e) {
            System.out.println("Table visit already exists.");
        }

        try {
            s2 = conn.createStatement();
            //s2.execute("DROP TABLE VISIT");
            //conn.commit();
            rs = s2.executeQuery("SELECT * FROM visit");
            conn.commit();

            if (!rs.next()) {
                psInsert = conn.prepareStatement("insert into visit values (?, ?, ?, ?, ?)");
                String[] Categories = {"stapler", "tuition fee", "complaints", "collect assignments", "meet people"};

                for (int i = 1; i < 1001; i++) {
                    psInsert.setInt(1, i);
                    int index2 = (int) (Math.random() * 85);
                    psInsert.setInt(2, index2);
                    Calendar calender = Calendar.getInstance();
                    calender.set(2000, 1, 1);
                    java.util.Date calender1 = calender.getTime();
                    calender.set(2014, 12, 31);
                    java.util.Date calender2 = calender.getTime();
                    java.util.Date calendarUtil = randomDate(calender1, calender2);
                    java.sql.Date calenderSql = new java.sql.Date(calendarUtil.getTime());
                    psInsert.setDate(3, calenderSql);
                    int index4 = (int) (Math.random() * Categories.length);
                    psInsert.setString(4, Categories[index4]);
                    double rd = Math.random();
                    int solved;
                    //solved=0 means unsolved; solved=1 means solved.
                    if (rd < 0.5) {
                        solved = 0;
                    } else {
                        solved = 1;
                    }
                    psInsert.setInt(5, solved);
                    psInsert.executeUpdate();
                }
                conn.commit();
            }

        } catch (SQLException ex) {
            System.out.println("Table visit doesn't exist.");
        }
        shutdown();
    }

    public static java.util.Date randomDate(java.util.Date start, java.util.Date end) {
        try {

            if (start.getTime() >= end.getTime()) {
                return null;
            }
            long date = random(start.getTime(), end.getTime());
            return new java.util.Date(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * random is the method to generate the value in the begin and end range
     *
     * @param begin the minimum value of the range
     * @param end the maximum value of the range
     * @return
     */
    public static long random(long begin, long end) {
        long rtn = begin + (long) (Math.random() * (end - begin));
        //execute this function if returns begin and end date
        if (rtn == begin || rtn == end) {
            return random(begin, end);
        }
        return rtn;
    }

    public static void shutdown() {
        try {
            if (s != null && s2 != null) {
                s.close();
                s2.close();
            }
            if (conn != null) {
                //DriverManager.getConnection(dbURL + ";shutdown=true");
                conn.close();
            }
        } catch (SQLException sqlExcept) {

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
}
