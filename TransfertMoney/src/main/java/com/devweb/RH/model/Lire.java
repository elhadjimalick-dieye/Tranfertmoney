package com.tranfertmoney.tranfertmoney.model;

public class Lire {
    private int status;
    private String lire;

    public Lire(int status, String lire){
        this.status = status;
        this.lire = lire;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getLire() {
        return lire;
    }

    public void setLire(String lire) {
        this.lire = lire;
    }
}
