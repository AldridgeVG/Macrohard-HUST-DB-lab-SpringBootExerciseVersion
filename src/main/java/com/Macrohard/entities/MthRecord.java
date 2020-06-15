package com.Macrohard.entities;

public class MthRecord {
    private int empno;
    private String empname;
    private int salary;

    public int getEmpno() {
        return empno;
    }

    public String getEmpname() {
        return empname;
    }

    public int getSalary() {
        return salary;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public MthRecord(int empno, String empname, int salary) {
        this.empno = empno;
        this.empname = empname;
        this.salary = salary;
    }

    public MthRecord() {
    }

    @Override
    public String toString() {
        return "empno:" + empno + " empname:" + empname + " salary:" + salary;
    }
}
