package DAO;

import DTO.InHotel;

import java.util.List;

/**
 * Created by edik2 on 15.05.2018.
 */
public interface InHotelDAO {

    int addInHotel(InHotel inHotel);

    int deleteInHotel(InHotel inHotel);

    List<InHotel> getAllInHotel();
}
