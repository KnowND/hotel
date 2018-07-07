package DTO;

import org.joda.time.DateTime;

import java.util.Date;

/**
 * Created by edik2 on 15.05.2018.
 */
public class InHotel {

    private int id;

    private int guest;

    private int employee;

    private DateTime dateOfSettlement;

    private DateTime dateOfEviction;

    String dateSettlement;
    String dateEviction;

    private int room;

    private int cost;

    private int classRoom;

    public InHotel( int guest, int employee, DateTime dateOfSettlement, DateTime dateOfEviction, int room, int cost, int classRoom) {
        this.guest = guest;
        this.employee = employee;
        this.dateOfSettlement = dateOfSettlement;
        this.dateOfEviction = dateOfEviction;
        this.room = room;
        this.cost = cost;
        this.classRoom = classRoom;
        dateSettlement =  dateOfSettlement.getDayOfMonth()+ "." + dateOfSettlement.getMonthOfYear() + "."+ dateOfSettlement.getYear();
        dateEviction =  dateOfEviction.getDayOfMonth()+ "." + dateOfEviction.getMonthOfYear() + "." + dateOfEviction.getYear();
    }

    public InHotel( int id, int guest, int employee, DateTime dateOfSettlement, DateTime dateOfEviction, int room, int cost, int classRoom) {
        this.id = id;
        this.guest = guest;
        this.employee = employee;
        this.dateOfSettlement = dateOfSettlement;
        this.dateOfEviction = dateOfEviction;
        this.room = room;
        this.cost = cost;
        this.classRoom = classRoom;
        dateSettlement =  dateOfSettlement.getDayOfMonth()+ "." + dateOfSettlement.getMonthOfYear() + "."+ dateOfSettlement.getYear();
        dateEviction =  dateOfEviction.getDayOfMonth()+ "." + dateOfEviction.getMonthOfYear() + "." + dateOfEviction.getYear();
    }

    public InHotel(int id, int guest, int employee, DateTime dateOfSettlement, DateTime dateOfEviction, int room, int classRoom) {
        this.id = id;
        this.guest = guest;
        this.employee = employee;
        this.dateOfSettlement = dateOfSettlement;
        this.dateOfEviction = dateOfEviction;
        this.room = room;
        this.classRoom = classRoom;
        dateSettlement =  dateOfSettlement.getDayOfMonth()+ "." + dateOfSettlement.getMonthOfYear() + "."+ dateOfSettlement.getYear();
        dateEviction =  dateOfEviction.getDayOfMonth()+ "." + dateOfEviction.getMonthOfYear() + "." + dateOfEviction.getYear();
    }

    public String getDateSettlement() {
        return dateSettlement;
    }

    public void setDateSettlement(String dateSettlement) {
        this.dateSettlement = dateSettlement;
    }

    public String getDateEviction() {
        return dateEviction;
    }

    public void setDateEviction(String dateEviction) {
        this.dateEviction = dateEviction;
    }

    public void setClassRoom(int classRoom) {
        this.classRoom = classRoom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGuest() {
        return guest;
    }

    public void setGuest(int guest) {
        this.guest = guest;
    }

    public int getEmployee() {
        return employee;
    }

    public void setEmployee(int employee) {
        this.employee = employee;
    }

    public DateTime getDateOfSettlement() {
        return dateOfSettlement;
    }

    public void setDateOfSettlement(DateTime dateOfSettlement) {
        this.dateOfSettlement = dateOfSettlement;
    }

    public DateTime getDateOfEviction() {
        return dateOfEviction;
    }

    public void setDateOfEviction(DateTime dateOfEviction) {
        this.dateOfEviction = dateOfEviction;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getClassRoom() {
        return classRoom;
    }
}
