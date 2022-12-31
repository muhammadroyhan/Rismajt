package com.example.rismajt;

public class users {
    String name, angkatan, email, password, wa;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAngkatan() {
        return angkatan;
    }

    public void setAngkatan(String angkatan) {
        this.angkatan = angkatan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWa() {
        return wa;
    }

    public void setWa(String wa) {
        this.wa = wa;
    }

    public users(String name, String angkatan, String email, String password, String wa) {
        this.name = name;
        this.angkatan = angkatan;
        this.email = email;
        this.password = password;
        this.wa = wa;
    }

    public users() {
    }
}
