package DAO;

import DTO.Guest;
import org.joda.time.DateTime;

import java.sql.SQLException;

/**
 * Created by edik2 on 27.05.2018.
 */
public interface DAOhard {

    int isFreeRoomLevel(DateTime dateSettlement, DateTime dateEviction, int level)throws SQLException;

    String checkIn(Guest guest, int room, int cost)throws SQLException;

    public boolean checkOut(String passport) throws SQLException;


}