package DAO;

import DTO.Room;

import java.util.List;

/**
 * Created by edik2 on 15.05.2018.
 */
public interface RoomDAO {

    int addRoom(Room room);

    public List<Room> getAllRoomThisLevel(int level);

    Room getRoomById(int id);


    }
