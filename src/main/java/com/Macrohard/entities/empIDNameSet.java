package com.Macrohard.entities;

public class empIDNameSet {
    private int empno;
    private String empname;

    public empIDNameSet(int empno, String empname) {
        this.empno = empno;
        this.empname = empname;
    }

    public empIDNameSet() {
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
}
