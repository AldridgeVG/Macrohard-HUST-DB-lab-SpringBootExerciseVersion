package com.Macrohard.entities;

public class GeneralSalaryRecord {
    private int empno;
    private String empname;
    private String empdept;
    private String empprof;
    private int mthno;
    private int salary;

    public GeneralSalaryRecord() {
    }

    public GeneralSalaryRecord(int empno, String empname, String empdept, String empprof, int mthno, int salary) {
        this.empno = empno;
        this.empname = empname;
        this.empdept = empdept;
        this.empprof = empprof;
        this.mthno = mthno;
        this.salary = salary;
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getEmpdept() {
        return empdept;
    }

    public void setEmpdept(String empdept) {
        this.empdept = empdept;
    }

    public String getEmpprof() {
        return empprof;
    }

    public void setEmpprof(String empprof) {
        this.empprof = empprof;
    }

    public int getMthno() {
        return mthno;
    }

    public void setMthno(int mthno) {
        this.mthno = mthno;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
