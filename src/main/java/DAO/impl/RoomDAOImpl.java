package DAO.impl;

import DAO.RoomDAO;
import DTO.Booking;
import DTO.Room;
import org.joda.time.DateTime;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by edik2 on 15.05.2018.
 */
public class RoomDAOImpl  implements RoomDAO{

    private DataSource dataSource;

    public RoomDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Room> getAllRoomThisLevel(int level){

        String sql = "SELECT id, floor, numberRoom, cost, busy FROM room WHERE class = ? AND busy = FALSE";
        List<Room> rooms = new ArrayList<>();

        try (Connection connection = dataSource.getConnection()
        ) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, level);
//            List<Booking> bookingList = new ArrayList<>();

            Room room = null;
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                int id = resultSet.getInt("id");

                int floor = resultSet.getInt("floor");
                int numberRoom = resultSet.getInt("numberRoom");
                int cost = resultSet.getInt("cost");
                boolean busy = resultSet.getBoolean("busy");


                room = new Room(id,floor,numberRoom,cost, busy);

                rooms.add(room);

            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return rooms;
    }

    @Override
    public Room getRoomById(int id) {
        String sql = "SELECT floor, numberRoom, cost, busy FROM room WHERE id = ?";
        Room room = null;

        try (Connection connection = dataSource.getConnection()
        ) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
//            List<Booking> bookingList = new ArrayList<>();

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                int floor = resultSet.getInt("floor");
                int numberRoom = resultSet.getInt("numberRoom");
                int cost = resultSet.getInt("cost");
                boolean busy = resultSet.getBoolean("busy");


                room = new Room(floor,numberRoom,cost, busy);

            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return room;
    }

    @Override
    public int addRoom(Room room) {
        return 0;
    }
}
