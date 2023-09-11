package com.example.wifi_info_in_korea.dto;

public class HistoryTableRow {
    String ID;
    String X;
    String Y;
    String DATE;

    public HistoryTableRow(String ID, String x, String y, String DATE) {
        this.ID = ID;
        X = x;
        Y = y;
        this.DATE = DATE;
    }

    public String getID() {
        return ID;
    }

    public String getX() {
        return X;
    }

    public String getY() {
        return Y;
    }

    public String getDATE() {
        return DATE;
    }
}
