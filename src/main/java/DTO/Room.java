package DTO;

/**
 * Created by edik2 on 15.05.2018.
 */
public class Room {

    private int id;

    private int level;

    private int floor;

    private int number;

    private int cost;

    private boolean busy;

    public Room(int id, int floor, int number, int cost, boolean busy) {
        this.id = id;
        this.floor = floor;
        this.number = number;
        this.cost = cost;
        this.busy = busy;
    }

    public Room(int floor, int number, int cost, boolean busy) {
        this.floor = floor;
        this.number = number;
        this.cost = cost;
        this.busy = busy;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public boolean isBusy() {
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
