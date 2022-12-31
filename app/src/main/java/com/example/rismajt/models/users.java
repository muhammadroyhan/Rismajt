package com.example.rismajt.models;

public class users {
    private String edtnama, edtAngkatan, edtEmail, edtPassword, edtWA;

    private users(){

    }

    public users(String edtnama, String edtAngkatan, String edtEmail, String edtPassword, String edtWA){
        this.edtnama = edtnama;
        this.edtAngkatan = edtAngkatan;
        this.edtEmail = edtEmail;
        this.edtPassword = edtPassword;
        this.edtWA = edtWA;
    }

    public String getEdtnama() {
        return edtnama;
    }

    public void setEdtnama(String edtnama) {
        this.edtnama = edtnama;
    }

    public String getEdtAngkatan() {
        return edtAngkatan;
    }

    public void setEdtAngkatan(String edtAngkatan) {
        this.edtAngkatan = edtAngkatan;
    }

    public String getEdtEmail() {
        return edtEmail;
    }

    public void setEdtEmail(String edtEmail) {
        this.edtEmail = edtEmail;
    }

    public String getEdtPassword() {
        return edtPassword;
    }

    public void setEdtPassword(String edtPassword) {
        this.edtPassword = edtPassword;
    }

    public String getEdtWA() {
        return edtWA;
    }

    public void setEdtWA(String edtWA) {
        this.edtWA = edtWA;
    }
}
