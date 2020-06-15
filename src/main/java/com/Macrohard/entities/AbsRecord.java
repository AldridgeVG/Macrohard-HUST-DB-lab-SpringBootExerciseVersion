package com.Macrohard.entities;

public class AbsRecord {
    private int empno;
    private int mthno;
    private int absdy;

    public AbsRecord(int empno, int mthno, int absdy) {
        this.empno = empno;
        this.mthno = mthno;
        this.absdy = absdy;
    }

    public AbsRecord() {
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

    public int getAbsdy() {
        return absdy;
    }

    public void setAbsdy(int absdy) {
        this.absdy = absdy;
    }
}
