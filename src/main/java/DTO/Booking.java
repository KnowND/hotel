package DTO;

import org.joda.time.DateTime;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by edik2 on 15.05.2018.
 */
public class Booking implements Serializable{

    public Booking(int employeeId, String phoneGuest, String nameGuest, String surnameGuest,
                   int roomClass, DateTime dateOfSettlement, DateTime dateOfEviction) {
        this.employeeId = employeeId;
        this.phoneGuest = phoneGuest;
        this.status = "not confirmed";
        this.nameGuest = nameGuest;
        this.surnameGuest = surnameGuest;
        this.roomClass = roomClass;
        this.dateOfSettlement = dateOfSettlement;
        this.dateOfEviction = dateOfEviction;
        dateSettlement =  dateOfSettlement.getDayOfMonth()+ "." + dateOfSettlement.getMonthOfYear() + "."+ dateOfSettlement.getYear();
        dateEviction =  dateOfEviction.getDayOfMonth()+ "." + dateOfEviction.getMonthOfYear() + "." + dateOfEviction.getYear();
        bookingDate = new DateTime();
        bookDate =  bookingDate.getDayOfMonth()+ "." + bookingDate.getMonthOfYear() + "." + bookingDate.getYear();

    }

    public Booking(int id, int employeeId, String phoneGuest, String status, String nameGuest, String surnameGuest,
                   int roomClass, DateTime dateOfSettlement, DateTime dateOfEviction) {
        this.id = id;
        this.employeeId = employeeId;
        this.phoneGuest = phoneGuest;
        this.status = status;
        this.nameGuest = nameGuest;
        this.surnameGuest = surnameGuest;
        this.roomClass = roomClass;
        this.dateOfSettlement = dateOfSettlement;
        this.dateOfEviction = dateOfEviction;
        dateSettlement =  dateOfSettlement.getDayOfMonth()+ "." + dateOfSettlement.getMonthOfYear() + "."+ dateOfSettlement.getYear();
        dateEviction =  dateOfEviction.getDayOfMonth()+ "." + dateOfEviction.getMonthOfYear() + "." + dateOfEviction.getYear();
        bookingDate = new DateTime();

        bookDate =  bookingDate.getDayOfMonth()+ "." + bookingDate.getMonthOfYear() + "." + bookingDate.getYear();

    }

    public Booking(String phoneGuest, String status, String nameGuest, String surnameGuest,
                   int roomClass, DateTime dateOfSettlement, DateTime dateOfEviction, int id, DateTime bookingDate) {
        this.phoneGuest = phoneGuest;
        this.status = status;
        this.nameGuest = nameGuest;
        this.surnameGuest = surnameGuest;
        this.roomClass = roomClass;
        this.dateOfSettlement = dateOfSettlement;
        this.dateOfEviction = dateOfEviction;
        this.id = id;
        dateSettlement =  dateOfSettlement.getDayOfMonth()+ "." + dateOfSettlement.getMonthOfYear() + "."+ dateOfSettlement.getYear();
        dateEviction =  dateOfEviction.getDayOfMonth()+ "." + dateOfEviction.getMonthOfYear() + "." + dateOfEviction.getYear();
        this.bookingDate = bookingDate;
        bookDate =  bookingDate.getDayOfMonth()+ "." + bookingDate.getMonthOfYear() + "." + bookingDate.getYear();


    }

    private DateTime bookingDate;

    private int id;

    private int employeeId;

    private String phoneGuest;

    private String status;

    private String bookDate;

    private String nameGuest;

    private String surnameGuest;

    private int roomClass;

    private DateTime dateOfSettlement;

    private DateTime dateOfEviction;

    private String dateSettlement;
    private String dateEviction;

    public String getBookDate() {
        return bookDate;
    }

    public DateTime getBookingDate() {
        return bookingDate;
    }

    public String getDateSettlement() {
        return dateSettlement;
    }

    public String getDateEviction() {
        return dateEviction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneGuest() {
        return phoneGuest;
    }

    public void setPhoneGuest(String phoneGuest) {
        this.phoneGuest = phoneGuest;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getRoomClass() {
        return roomClass;
    }

    public void setRoomClass(int roomClass) {
        this.roomClass = roomClass;
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

    public String getNameGuest() {
        return nameGuest;
    }

    public String getSurnameGuest() {
        return surnameGuest;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setDateOfEviction(DateTime dateOfEviction) {
        this.dateOfEviction = dateOfEviction;
    }
}
