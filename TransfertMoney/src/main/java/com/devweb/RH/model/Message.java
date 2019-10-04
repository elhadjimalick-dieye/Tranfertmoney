package com.tranfertmoney.tranfertmoney.model;

public class Message {
    private int status;
    private String lire;
    private String ajouter;

    public Message(int status, String lire, String ajouter){
        this.status = status;
        this.lire = lire;
        this.ajouter = ajouter;
    }

    public Message(int i, String msg) {
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

    public String getAjouter() {
        return ajouter;
    }

    public void setAjouter(String ajouter) {
        this.ajouter = ajouter;
    }
}
