package com.Macrohard.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.*;

@Repository
public class LoginDao {

    public List<Map<String, String>> getAllUsrPwd() {

        List<Map<String, String>> res = new ArrayList<>();

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

            // execute: update/ browse
            stmt = connection.createStatement();
            String sql = "select * from users"; // query into sheet1
            rs = stmt.executeQuery(sql); // return result set

            // result set is a sheet that contains the data that was in query
            // to get data from result set. pointer rs points to former line of result set
            // next(): 1.move pointer to next line 2.is null(contain data?)? t/f return
            // boolean
            // rs.getXXX(): get data from current line that rs points to
            // getString/getInt...

            while (rs.next()) {
                String usr2 = rs.getString("usr");
                //System.out.println(usr2);
                String pwd2 = rs.getString("pwd");
                //System.out.println(pwd2);
                Map<String, String> elem = new HashMap<>();
                elem.put("usr", usr2);
                elem.put("pwd", pwd2);
                res.add(elem);
            }
            return res;
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
}
