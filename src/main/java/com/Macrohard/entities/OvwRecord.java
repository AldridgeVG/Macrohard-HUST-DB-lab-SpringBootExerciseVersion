package com.Macrohard.entities;

public class OvwRecord {
    private int empno;
    private int mthno;
    private String owtype;
    private int owhr;

    public OvwRecord(int empno, int mthno, String owtype, int owhr) {
        this.empno = empno;
        this.mthno = mthno;
        this.owtype = owtype;
        this.owhr = owhr;
    }

    public OvwRecord() {
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public int getMthno() {
        return mthno;
    }

    public void setMthno(int mthno) {
        this.mthno = mthno;
    }

    public String getOwtype() {
        return owtype;
    }

    public void setOwtype(String owtype) {
        this.owtype = owtype;
    }

    public int getOwhr() {
        return owhr;
    }

    public void setOwhr(int owhr) {
        this.owhr = owhr;
    }
}
