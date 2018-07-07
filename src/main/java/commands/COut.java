package commands;

/**
 * Created by edik2 on 01.07.2018.
 */
public class COut {

    private String phone;
    private String passport;
    private String name;
    private String surname;
    private String dateSettlement;
    private String dateEviction;
    private int room;
    private int cost;

    public COut(String phone, String passport, String name, String surname, String dateSettlement, String dateEviction, int room, int cost) {
        this.phone = phone;
        this.passport = passport;
        this.name = name;
        this.surname = surname;
        this.dateSettlement = dateSettlement;
        this.dateEviction = dateEviction;
        this.room = room;
        this.cost = cost;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassport() {
        return passport;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDateSettlement() {
        return dateSettlement;
    }

    public String getDateEviction() {
        return dateEviction;
    }

    public int getRoom() {
        return room;
    }

    public int getCost() {
        return cost;
    }
}
