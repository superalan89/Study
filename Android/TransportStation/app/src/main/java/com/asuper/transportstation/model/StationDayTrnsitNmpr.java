package com.asuper.transportstation.model;

/**
 * Created by super on 2017-10-17.
 */

public class StationDayTrnsitNmpr
{
    private RESULT RESULT;
    private String list_total_count;
    private Row[] row;

    public RESULT getRESULT () {
        return RESULT;
    }

    public void setRESULT (RESULT RESULT) {
        this.RESULT = RESULT;
    }

    public String getList_total_count () {
        return list_total_count;
    }

    public void setList_total_count (String list_total_count) {
        this.list_total_count = list_total_count;
    }

    public Row[] getRow () {
        return row;
    }

    public void setRow (Row[] row) {
        this.row = row;
    }

    @Override
    public String toString() {
        return "ClassPojo [RESULT = "+RESULT+", list_total_count = "+list_total_count+", row = "+row+"]";
    }
}
