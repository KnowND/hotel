package DTO;

/**
 * Created by edik2 on 15.05.2018.
 */
public class Employee {

    private int id;

    private String password;

    private String name;

    private String surname;

    private String phone;

    private String role;

    public Employee(int id, String name, String surname, String phone, String role, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.role = role;
        this.password = password;
    }

    public String getPassword() {
        return password;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
