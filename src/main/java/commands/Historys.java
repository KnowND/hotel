package commands;

import org.joda.time.DateTime;

/**
 * Created by edik2 on 03.07.2018.
 */
public class Historys {

    int id;
    String guest;
    String phoneGuest;
    String employee;
    DateTime dateSettlement;
    DateTime dateEviction;
    int room;
    int cost;
    int guestId;
    int employeeId;

    public Historys(int id, String guest, String phoneGuest, DateTime dateSettlement, DateTime dateEviction, int room, int cost, int guestId, int employeeId, String employee) {
        this.id = id;
        this.guest = guest;
        this.phoneGuest = phoneGuest;
        this.dateSettlement = dateSettlement;
        this.dateEviction = dateEviction;
        this.room = room;
        this.cost = cost;
        this.guestId = guestId;
        this.employeeId = employeeId;
        this.employee = employee;
    }

    public String getEmployee() {
        return employee;
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

    public String getGuest() {
        return guest;
    }

    public String getPhoneGuest() {
        return phoneGuest;
    }

    public String getDateSettlement() {

        return dateSettlement.getDayOfMonth() + "." + dateSettlement.getMonthOfYear() + "." + dateSettlement.getYear();
    }

    public String getDateEviction() {
        return dateEviction.getDayOfMonth() + "." + dateEviction.getMonthOfYear() + "." + dateEviction.getYear();
    }

    public int getRoom() {
        return room;
    }

    public int getCost() {
        return cost;
    }
}
