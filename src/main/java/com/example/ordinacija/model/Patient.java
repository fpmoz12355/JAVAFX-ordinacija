package com.example.ordinacija.model;

public class Patient extends Table {


    @Entity(type="INTEGER", size=32, primary = true)
    int ID;

    @Entity(type = "VARCHAR", size = 50, isnull = false)
    String name;

    @Entity(type = "VARCHAR", size = 50, isnull = false)
    String lastname;

    @Entity(type = "CHAR", size = 13, isnull = false)
    String uid;

    @Entity(type = "VARCHAR", size = 20, isnull = false)
    String phone;

    @Entity(type = "VARCHAR", size = 30, isnull = true)
    String mail;


    public int getID() {
        return ID;
    }


    public String getName() { return name; }

    public void setName(String name) { this.name = name; }


    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) { this.phone = phone; }


    public String getMail() {  return mail; }

    public void setMail(String mail) {
        this.mail = mail;
    }


}
