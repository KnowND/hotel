package DTO;

/**
 * Created by edik2 on 15.05.2018.
 */
public class Guest {

    private int id;

    private String name;

    private String surname;

    private String phone;

    private String passport;

    public Guest(String name, String surname, String phone, String passport) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.passport = passport;
    }

    public Guest(int id, String name, String surname, String phone, String passport) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.passport = passport;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }
}
