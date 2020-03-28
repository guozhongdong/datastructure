package com.gzd.datastructure.suanfatujie.dynatic;

/**
 * @author guozhongdong
 * @date 2020/3/28 15:59
 * 设置工作起始时间和结束时间及收益
 */
public class Meet {

    private int start;
    private int end;
    private int income;
    public Meet(int start,int end,int income){
        this.start = start;
        this.end = end;
        this.income = income;
    }
    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }
}
