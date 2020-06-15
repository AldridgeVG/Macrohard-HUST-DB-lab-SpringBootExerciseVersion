package com.Macrohard.dao;

import com.Macrohard.entities.EoyAwardRecord;
import com.Macrohard.entities.GeneralSalaryRecord;
import com.Macrohard.entities.IDRecord;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GeneralLabDao {

    public List<GeneralSalaryRecord> getGeneralRecords(){
        List<GeneralSalaryRecord> ret = new ArrayList<>();

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
            String sql = "select emp.employerno,emp.empname,emp.deptname,emp.profname,msr.mthno,msr.mthsalary " +
                    "from employerinfo emp,mthsalaryrecord msr " +
                    "where emp.employerno = msr.employerno"; // query into sheet1
            rs = stmt.executeQuery(sql); // return result set

            while (rs.next()) {
                Integer empno1 = rs.getInt("employerno");
                String empname1 = rs.getString("empname");
                String empdept1 = rs.getString("deptname");
                String empprof1 = rs.getString("profname");
                Integer mthno1 = rs.getInt("mthno");
                Integer salary1 = rs.getInt("mthsalary");
                GeneralSalaryRecord tmp = new GeneralSalaryRecord(empno1, empname1, empdept1, empprof1, mthno1, salary1);
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

    public List<EoyAwardRecord> getEoyAwardRecords(){
        List<EoyAwardRecord> ret = new ArrayList<>();

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
            String sql = "select emp.employerno,emp.empname,sum(msr.mthsalary) " +
                    "from employerinfo emp,mthsalaryrecord msr " +
                    "where emp.employerno = msr.employerno "+
                    "group by employerno"; // query into sheet1
            rs = stmt.executeQuery(sql); // return result set

            while (rs.next()) {
                Integer empno1 = rs.getInt("employerno");
                String empname1 = rs.getString("empname");
                Integer sum1 = rs.getInt("sum(msr.mthsalary)");
                Integer eoya1 = sum1/12;
                EoyAwardRecord tmp = new EoyAwardRecord(empno1,empname1,sum1,eoya1);
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
