package com.example.rismajt;

public class Member {

    String nama, angkatan, alamat, bisnis, email, kampus, jenjang, jurusan;
    int imageId;

    public Member(String nama, String angkatan, String alamat, String bisnis, String email, String kampus, String jenjang, String jurusan, int imageId) {
        this.nama = nama;
        this.angkatan = angkatan;
        this.alamat = alamat;
        this.bisnis = bisnis;
        this.email = email;
        this.kampus = kampus;
        this.jenjang = jenjang;
        this.jurusan = jurusan;
        this.imageId = imageId;
    }
}
