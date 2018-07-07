package DTO;

import org.joda.time.DateTime;

import java.util.Date;

/**
 * Created by edik2 on 15.05.2018.
 */
public class History {

    private int id;

    private int room;

    private int cost;

    private String  guest;

    private String  employee;

    private DateTime dateSettlement;

    private DateTime dateEviction;

    private int guestId;

    private int employeeId;


    public History(int id, int room, int cost, String guest, String employee, DateTime dateSettlement, DateTime dateEviction) {
        this.id = id;
        this.room = room;
        this.cost = cost;
        this.guest = guest;
        this.employee = employee;
        this.dateSettlement = dateSettlement;
        this.dateEviction = dateEviction;
    }

    public History(int id, int room, int cost, String guest, String employee, DateTime dateSettlement, DateTime dateEviction, int guestId, int employeeId) {
        this.room = room;
        this.id = id;
        this.cost = cost;
        this.guest = guest;
        this.employee = employee;
        this.dateSettlement = dateSettlement;
        this.dateEviction = dateEviction;
        this.guestId = guestId;
        this.employeeId = employeeId;
    }

    public History(int room, int cost, String guest, String employee, DateTime dateSettlement, DateTime dateEviction, int guestId, int employeeId) {
        this.room = room;
        this.cost = cost;
        this.guest = guest;
        this.employee = employee;
        this.dateSettlement = dateSettlement;
        this.dateEviction = dateEviction;
        this.guestId = guestId;
        this.employeeId = employeeId;
    }

    public int getGuestId() {
        return guestId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public String getGuest() {
        return guest;
    }

    public String getEmployee() {
        return employee;
    }

    public int getCost() {
        return cost;
    }

    public DateTime getDateSettlement() {
        return dateSettlement;
    }

    public DateTime getDateEviction() {
        return dateEviction;
    }
}
