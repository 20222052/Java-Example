package com.example.demo.Model;

public class Student {
    private int id;
    private String fullname;
    private String phone;
    private String address;

    public Student() {
    }

    public Student(int id, String fullname, String phone, String address) {
        this.id = id;
        this.fullname = fullname;
        this.phone = phone;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
