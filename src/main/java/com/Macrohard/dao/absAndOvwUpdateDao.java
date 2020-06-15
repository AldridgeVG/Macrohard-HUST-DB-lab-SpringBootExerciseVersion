package com.Macrohard.dao;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class absAndOvwUpdateDao {

    private String reloadSql = "DROP PROCEDURE\n" +
            "IF\n" +
            "\tEXISTS proc_initData;\n" +
            "\n" +
            "DELIMITER $\n" +
            "CREATE PROCEDURE proc_initData () BEGIN\n" +
            "\tDECLARE\n" +
            "\t\ti INT DEFAULT 1000;\n" +
            "\tDECLARE\n" +
            "\t\tj INT DEFAULT 1;\n" +
            "\tWHILE\n" +
            "\t\t\t( i < 1020 ) DO\n" +
            "\t\t\t\n" +
            "\t\t\tSET i = i + 1;\n" +
            "\t\tWHILE\n" +
            "\t\t\t\t( j < 13 ) DO\n" +
            "\t\t\t\tUPDATE mthsalaryrecord msr \n" +
            "\t\t\t\tSET msr.mthsalary = (\n" +
            "\t\t\t\tSELECT\n" +
            "\t\t\t\t\tpf1.mthbasesalary \n" +
            "\t\t\t\tFROM\n" +
            "\t\t\t\t\tprofessioninfo pf1,\n" +
            "\t\t\t\t\temployerinfo emp1 \n" +
            "\t\t\t\tWHERE\n" +
            "\t\t\t\t\tpf1.deptname = emp1.deptname \n" +
            "\t\t\t\t\tAND pf1.profname = emp1.profname \n" +
            "\t\t\t\t\tAND emp1.employerno = i \n" +
            "\t\t\t\t) \n" +
            "\t\t\tWHERE\n" +
            "\t\t\t\tmsr.employerno = i \n" +
            "\t\t\t\tAND msr.mthno = j;\n" +
            "\t\t\t\n" +
            "\t\t\tSET j = j + 1;\n" +
            "\t\t\t\n" +
            "\t\tEND WHILE;\n" +
            "\t\t\n" +
            "\t\tSET j = 1;\n" +
            "\t\t\n" +
            "\tEND WHILE;\n" +
            "\n" +
            "END $ CALL proc_initData";

    private String absUpdSql = "UPDATE mthsalaryrecord msr \n" +
            "SET msr.mthsalary = msr.mthsalary - (\n" +
            "\t(\n" +
            "\t\tSELECT\n" +
            "\t\t\tifnull( abr.absenceday, 0 ) \n" +
            "\t\tFROM\n" +
            "\t\t\tabsencerecord abr \n" +
            "\t\tWHERE\n" +
            "\t\t\tabr.employerno = msr.employerno \n" +
            "\t\t\tAND abr.mthno = msr.mthno \n" +
            "\t\t)* 200 \n" +
            "\t) \n" +
            "WHERE\n" +
            "\tmsr.mthno = ( SELECT abr1.mthno FROM absencerecord abr1 WHERE abr1.mthno = msr.mthno AND abr1.employerno = msr.employerno ) \n" +
            "\tAND msr.employerno = ( SELECT abr1.employerno FROM absencerecord abr1 WHERE abr1.mthno = msr.mthno AND abr1.employerno = msr.employerno )";

    private String ovwVoluntarySql = "UPDATE mthsalaryrecord msr \n" +
            "SET msr.mthsalary = msr.mthsalary + (\n" +
            "\t(\n" +
            "\t\tSELECT\n" +
            "\t\t\tifnull( owi.owhr, 0 ) \n" +
            "\t\tFROM\n" +
            "\t\t\toverworkinfo owi \n" +
            "\t\tWHERE\n" +
            "\t\t\towi.employerno = msr.employerno \n" +
            "\t\t\tAND owi.mthno = msr.mthno \n" +
            "\t\t\tAND owi.owtype = 'voluntary' \n" +
            "\t\t\t) * (\n" +
            "\t\tSELECT\n" +
            "\t\t\tpfi.hrbasesalary \n" +
            "\t\tFROM\n" +
            "\t\t\tprofessioninfo pfi,\n" +
            "\t\t\temployerinfo emp \n" +
            "\t\tWHERE\n" +
            "\t\t\tpfi.deptname = emp.deptname \n" +
            "\t\t\tAND pfi.profname = emp.profname \n" +
            "\t\t\tAND emp.employerno = msr.employerno \n" +
            "\t\t) * 2 \n" +
            "\t) \n" +
            "WHERE\n" +
            "\tmsr.mthno = (\n" +
            "\tSELECT\n" +
            "\t\towi2.mthno \n" +
            "\tFROM\n" +
            "\t\toverworkinfo owi2 \n" +
            "\tWHERE\n" +
            "\t\towi2.mthno = msr.mthno \n" +
            "\t\tAND owi2.employerno = msr.employerno \n" +
            "\t\tAND owi2.owtype = 'voluntary' \n" +
            "\t) \n" +
            "\tAND msr.employerno = (\n" +
            "\tSELECT\n" +
            "\t\towi2.employerno \n" +
            "\tFROM\n" +
            "\t\toverworkinfo owi2 \n" +
            "\tWHERE\n" +
            "\t\towi2.mthno = msr.mthno \n" +
            "\t\tAND owi2.employerno = msr.employerno \n" +
            "\tAND owi2.owtype = 'voluntary' \n" +
            "\t)";

    private String ovwCompulsiveSql = "UPDATE mthsalaryrecord msr \n" +
            "SET msr.mthsalary = msr.mthsalary + (\n" +
            "\t(\n" +
            "\t\tSELECT\n" +
            "\t\t\tifnull( owi.owhr, 0 ) \n" +
            "\t\tFROM\n" +
            "\t\t\toverworkinfo owi \n" +
            "\t\tWHERE\n" +
            "\t\t\towi.employerno = msr.employerno \n" +
            "\t\t\tAND owi.mthno = msr.mthno \n" +
            "\t\t\tAND owi.owtype = 'compulsive' \n" +
            "\t\t\t) * (\n" +
            "\t\tSELECT\n" +
            "\t\t\tpfi.hrbasesalary \n" +
            "\t\tFROM\n" +
            "\t\t\tprofessioninfo pfi,\n" +
            "\t\t\temployerinfo emp \n" +
            "\t\tWHERE\n" +
            "\t\t\tpfi.deptname = emp.deptname \n" +
            "\t\t\tAND pfi.profname = emp.profname \n" +
            "\t\t\tAND emp.employerno = msr.employerno \n" +
            "\t\t) * 1\n" +
            "\t) \n" +
            "WHERE\n" +
            "\tmsr.mthno = (\n" +
            "\tSELECT\n" +
            "\t\towi2.mthno \n" +
            "\tFROM\n" +
            "\t\toverworkinfo owi2 \n" +
            "\tWHERE\n" +
            "\t\towi2.mthno = msr.mthno \n" +
            "\t\tAND owi2.employerno = msr.employerno \n" +
            "\t\tAND owi2.owtype = 'compulsive' \n" +
            "\t) \n" +
            "\tAND msr.employerno = (\n" +
            "\tSELECT\n" +
            "\t\towi2.employerno \n" +
            "\tFROM\n" +
            "\t\toverworkinfo owi2 \n" +
            "\tWHERE\n" +
            "\t\towi2.mthno = msr.mthno \n" +
            "\t\tAND owi2.employerno = msr.employerno \n" +
            "\tAND owi2.owtype = 'compulsive' \n" +
            "\t)";

    public int realculateSalary() {

        String url = "Jdbc:mysql://localhost:3306/macrohard?useSSL=false&serverTimezone=UTC";
        String usr = "root";
        String pwd = "galland990531";

        Statement stmt = null;
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // load specific driver class
            connection = DriverManager.getConnection(url, usr, pwd);

            stmt = connection.createStatement();
            int ret = 0;
            int ret1 = stmt.executeUpdate(reloadSql);
            int ret2 = stmt.executeUpdate(absUpdSql);
            int ret3 = stmt.executeUpdate(ovwCompulsiveSql);
            int ret4 = stmt.executeUpdate(ovwVoluntarySql);
            ret = (ret1 * ret2 * ret3 * ret4);
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
