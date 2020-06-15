package com.Macrohard.entities;

public class MyEmployee {
    private Integer empno;
    private String empname;
    private String empgender;
    private Integer empage;
    private String empdept;
    private String empprof;

    public MyEmployee(Integer empno, String empname, String empgender, Integer empage, String empdept, String empprof) {
        this.empno = empno;
        this.empname = empname;
        this.empgender = empgender;
        this.empage = empage;
        this.empdept = empdept;
        this.empprof = empprof;
    }

    public MyEmployee() {
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getEmpgender() {
        return empgender;
    }

    public void setEmpgender(String empgender) {
        this.empgender = empgender;
    }

    public Integer getEmpage() {
        return empage;
    }

    public void setEmpage(Integer empage) {
        this.empage = empage;
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
}
