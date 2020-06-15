package com.Macrohard.dao;

import com.Macrohard.entities.DeptRecord;
import com.Macrohard.entities.MthRecord;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.*;

@Repository
public class EmployeeLabDao {

    public List<MthRecord> getMthSalaryRecords(String mth) {

        List<MthRecord> ret = new ArrayList<>();

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
            String sql = "select * from "+mth+"salary"; // query into sheet1
            rs = stmt.executeQuery(sql); // return result set

            while (rs.next()) {
                Integer empno1 = rs.getInt("empno");
                //System.out.println(usr2);
                String empname1 = rs.getString("empname");
                //System.out.println(pwd2);
                Integer salary1 = rs.getInt("salary");
                MthRecord tmp = new MthRecord(empno1,empname1,salary1);
                ret.add(tmp);
            }

            return ret;
            //out.print("Login Failed, please register or check your username and password");

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

    public List<DeptRecord> getDeptMthRecord(String dept) {

        List<DeptRecord> ret = new ArrayList<>();

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
            String sql = "select * from "+dept+"salary"; // query into sheet1
            rs = stmt.executeQuery(sql); // return result set

            while (rs.next()) {
                String empdept1 = rs.getString("empdept");
                String empprof1 = rs.getString("empprof");
                Integer empno1 = rs.getInt("empno");
                String empname1 = rs.getString("empname");
                Integer mthno1 = rs.getInt("mthno");
                Integer salary1 = rs.getInt("salary");
                DeptRecord tmp = new DeptRecord(empdept1,empprof1,empno1,empname1,mthno1,salary1);
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

}
