package DTO;

/**
 * Created by edik2 on 15.05.2018.
 */
public class RoomLevel {

    private int id;

    private int numberLevel;

    private int price;

//    private int photo;

    private boolean bathroom;

    private boolean balcony;
    private String balcony1;

    private int size;

    private boolean tv;
    private String tv1;

    private boolean shower;
    private String shower1;

    private boolean bath;
    private String bath1;

    public RoomLevel(int id, int numberLevel, int price, boolean bathroom, boolean balcony, int size, boolean tv,boolean shower, boolean bath) {
        this.id = id;
        this.numberLevel = numberLevel;
        this.price = price;
//        this.photo = photo;
        this.bathroom = bathroom;
        this.balcony = balcony;
        this.size = size;
        this.tv = tv;
        this.shower = shower;
        this.bath = bath;
        tv1 = tv ?"+":"-";
        shower1 = shower?"+":"-";
        bath1 = bath?"+":"-";
        balcony1 = balcony?"+":"-";
    }

    public String getBalcony1() {
        return balcony1;
    }

    public String getTv1() {
        return tv1;
    }

    public String getShower1() {
        return shower1;
    }

    public String getBath1() {
        return bath1;
    }

    public RoomLevel(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberLevel() {
        return numberLevel;
    }

    public void setNumberLevel(int numberLevel) {
        this.numberLevel = numberLevel;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
//
//    public int getPhoto() {
//        return photo;
//    }
//
//    public void setPhoto(int photo) {
//        this.photo = photo;
//    }

    public boolean isBathroom() {
        return bathroom;
    }

    public void setBathroom(boolean bathroom) {
        this.bathroom = bathroom;
    }

    public boolean getBalcony() {
        return balcony;
    }

    public void setBalcony(boolean balcony) {
        this.balcony = balcony;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean getTv() {
        return tv;
    }

    public void setTv(boolean tv) {
        this.tv = tv;
    }

    public boolean getShower() {
        return shower;
    }

    public void setShower(boolean shower) {
        this.shower = shower;
    }

    public boolean getBath() {
        return bath;
    }

    public void setBath(boolean bath) {
        this.bath = bath;
    }

}
