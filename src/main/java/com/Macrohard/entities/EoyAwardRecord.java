package com.Macrohard.entities;

public class EoyAwardRecord {
    private int empno;
    private String empname;
    private int salarysum;
    private int award;

    public EoyAwardRecord() {
    }

    public EoyAwardRecord(int empno, String empname,int salarysum, int award) {
        this.empno = empno;
        this.empname = empname;
        this.salarysum = salarysum;
        this.award = award;
    }

    public int getSalarysum() {
        return salarysum;
    }

    public void setSalarysum(int salarysum) {
        this.salarysum = salarysum;
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

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }
}
