package DAO.impl;

import DAO.RoomDAO;
import DAO.RoomLevelDAO;
import DTO.History;
import DTO.Room;
import DTO.RoomLevel;

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
public class RoomLevelDAOImpl implements RoomLevelDAO {

    DataSource dataSource;

    public RoomLevelDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<RoomLevel> getRoomLevelByPrice(int price) {

        String sql = "SELECT * FROM room_level WHERE price <= ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setInt(1, price);
            List<RoomLevel> roomLevels = new ArrayList<>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
//                int id, int numberLevel, int price, int photo, boolean bathroom, boolean balcony, int size, boolean tv, int totalRooms, boolean shower, boolean bath, boolean isFree
                    RoomLevel roomLevel = new RoomLevel(resultSet.getInt("id"), resultSet.getInt("level_number"),
                            resultSet.getInt("price"), resultSet.getBoolean("bathroom"),
                            resultSet.getBoolean("balcony"), resultSet.getInt("size"),
                            resultSet.getBoolean("tv"),resultSet.getBoolean("shower"),
                            resultSet.getBoolean("bath"));
                roomLevels.add(roomLevel);
            }
            return roomLevels;
        } catch (SQLException e) {
            e.printStackTrace();
//            logger.error("Error getting all records from Food table", e);
        }
        return null;
    }

    @Override
    public List<RoomLevel> getAllRoomLevel() {
        String sql = "SELECT * FROM room_level";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {

            List<RoomLevel> roomLevels = new ArrayList<>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
//                int id, int numberLevel, int price, int photo, boolean bathroom, boolean balcony, int size, boolean tv, int totalRooms, boolean shower, boolean bath, boolean isFree
                RoomLevel roomLevel = new RoomLevel(resultSet.getInt("id"), resultSet.getInt("level_number"),
                        resultSet.getInt("price"), resultSet.getBoolean("bathroom"),
                        resultSet.getBoolean("balcony"), resultSet.getInt("size"),
                        resultSet.getBoolean("tv"),resultSet.getBoolean("shower"),
                        resultSet.getBoolean("bath"));
                roomLevels.add(roomLevel);
            }
            return roomLevels;
        } catch (SQLException e) {
            e.printStackTrace();
//            logger.error("Error getting all records from Food table", e);
        }
        return null;
    }

}