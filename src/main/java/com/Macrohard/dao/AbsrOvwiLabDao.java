package com.Macrohard.dao;

import com.Macrohard.entities.AbsRecord;
import com.Macrohard.entities.OvwRecord;
import com.Macrohard.entities.empIDNameSet;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AbsrOvwiLabDao {

    public List<AbsRecord> getAllAbsRecords() {
        List<AbsRecord> ret = new ArrayList<>();

        //here use root to get users, after this we use our username
        String url = "Jdbc:mysql://localhost:3306/macrohard?useSSL=false&serverTimezone=UTC";
        String usr = "root";
        String pwd = "galland990531";

        Statement stmt = null;
        Connection connection = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // load specific driver class
            connection = DriverManager.getConnection(url, usr, pwd);

            stmt = connection.createStatement();
            String sql = "select * from absencerecord"; // query into sheet1
            rs = stmt.executeQuery(sql); // return result set

            while (rs.next()) {
                Integer empno1 = rs.getInt("employerno");
                Integer mthno1 = rs.getInt("mthno");
                Integer absdy1 = rs.getInt("absenceday");
                AbsRecord tmp = new AbsRecord(empno1, mthno1, absdy1);
                ret.add(tmp);
            }
            return ret;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (stmt != null)
                    stmt.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public int insertOneAbsr(AbsRecord absRecord) {

        String url = "Jdbc:mysql://localhost:3306/macrohard?useSSL=false&serverTimezone=UTC";
        String usr = "root";
        String pwd = "galland990531";

        Statement stmt = null;
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // load specific driver class
            connection = DriverManager.getConnection(url, usr, pwd);

            stmt = connection.createStatement();
            String sql = "INSERT INTO absencerecord " +
                    "VALUES( " +
                    absRecord.getEmpno() + "," +
                    absRecord.getMthno() + "," +
                    absRecord.getAbsdy() + ");";
            int ret = stmt.executeUpdate(sql); // return result set
            return ret;

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public int deleteOneAbsr(Integer empno, Integer mthno) {

        String url = "Jdbc:mysql://localhost:3306/macrohard?useSSL=false&serverTimezone=UTC";
        String usr = "root";
        String pwd = "galland990531";

        Statement stmt = null;
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // load specific driver class
            connection = DriverManager.getConnection(url, usr, pwd);

            stmt = connection.createStatement();
            String sql = "DELETE FROM absencerecord WHERE employerno = " + empno + " AND mthno = " + mthno;
            int ret = stmt.executeUpdate(sql); // return result set
            return ret;

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<OvwRecord> getAllOvwRecords() {
        List<OvwRecord> ret = new ArrayList<>();

        //here use root to get users, after this we use our username
        String url = "Jdbc:mysql://localhost:3306/macrohard?useSSL=false&serverTimezone=UTC";
        String usr = "root";
        String pwd = "galland990531";

        Statement stmt = null;
        Connection connection = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // load specific driver class
            connection = DriverManager.getConnection(url, usr, pwd);

            stmt = connection.createStatement();
            String sql = "select * from overworkinfo"; // query into sheet1
            rs = stmt.executeQuery(sql); // return result set

            while (rs.next()) {
                Integer empno1 = rs.getInt("employerno");
                Integer mthno1 = rs.getInt("mthno");
                String owtype1 = rs.getString("owtype");
                Integer owhr1 = rs.getInt("owhr");
                OvwRecord tmp = new OvwRecord(empno1, mthno1, owtype1, owhr1);
                ret.add(tmp);
            }
            return ret;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (stmt != null)
                    stmt.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public int insertOneOvwi(OvwRecord ovwRecord) {
        String url = "Jdbc:mysql://localhost:3306/macrohard?useSSL=false&serverTimezone=UTC";
        String usr = "root";
        String pwd = "galland990531";

        Statement stmt = null;
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // load specific driver class
            connection = DriverManager.getConnection(url, usr, pwd);

            stmt = connection.createStatement();
            String sql = "INSERT INTO overworkinfo " +
                    "VALUES( " +
                    ovwRecord.getEmpno() + "," +
                    ovwRecord.getMthno() + ",'" +
                    ovwRecord.getOwtype() + "'," +
                    ovwRecord.getOwhr() + ");";
            int ret = stmt.executeUpdate(sql); // return result set
            return ret;

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public int deleteOneOvwi(Integer empno,Integer mthno,String owtype){

        String url = "Jdbc:mysql://localhost:3306/macrohard?useSSL=false&serverTimezone=UTC";
        String usr = "root";
        String pwd = "galland990531";

        Statement stmt = null;
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // load specific driver class
            connection = DriverManager.getConnection(url, usr, pwd);

            stmt = connection.createStatement();
            String sql = "DELETE FROM overworkinfo WHERE employerno = " + empno + " AND mthno = " + mthno+" AND owtype = '"+owtype+"';";
            int ret = stmt.executeUpdate(sql); // return result set
            return ret;

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
