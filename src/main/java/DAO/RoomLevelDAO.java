package DAO;

import DTO.RoomLevel;

import java.util.List;

/**
 * Created by edik2 on 15.05.2018.
 */
public interface RoomLevelDAO {

    List<RoomLevel> getRoomLevelByPrice(int price);


    List<RoomLevel> getAllRoomLevel();




//    List<RoomLevel> getRoomLevelByPriceAndBathroom(int price, boolean bathroom);
//
//    List<RoomLevel> getRoomLevelByPriceAndBathroomAndBalcony(int price, boolean bathroom, boolean balcony);
//
//    List<RoomLevel> getRoomLevelByPriceAndBathroomAndBalconyAndSize(int price, boolean bathroom, boolean balcony, int size);
//
//    List<RoomLevel> getRoomLevelByPriceAndBathroomAndBalconyAndSizeAndTV(int price, boolean bathroom, boolean balcony, int size, boolean tv);
//
//    List<RoomLevel> getRoomLevelByPriceAndBathroomAndBalconyAndSizeAndTVAndShover(int price, boolean bathroom, boolean balcony, int size, boolean tv, boolean shower);
//
//    List<RoomLevel> getRoomLevelByPriceAndBathroomAndBalconyAndSizeAndTVAndShoverAndBath(int price, boolean bathroom, boolean balcony, int size, boolean tv, boolean shower, boolean bath);

    //    List<RoomLevel> getRoomLevelByPriceAndBathroomAndBalconyAndSizeAndTVAndShoverAndBath(int price, boolean bathroom, boolean balcony, int size, boolean tv, boolean shower, boolean bath);

}
