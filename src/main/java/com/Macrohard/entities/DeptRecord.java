package com.Macrohard.entities;

public class DeptRecord {
    private String empdept;
    private String empprof;
    private int empno;
    private String empname;
    private int mthno;
    private int salary;

    public DeptRecord(String empdept, String empprof, int empno, String empname, int mthno, int salary) {
        this.empdept = empdept;
        this.empprof = empprof;
        this.empno = empno;
        this.empname = empname;
        this.mthno = mthno;
        this.salary = salary;
    }

    public DeptRecord() {
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
