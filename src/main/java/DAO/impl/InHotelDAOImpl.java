package DAO.impl;

import DAO.InHotelDAO;
import DTO.InHotel;
import org.joda.time.DateTime;

import javax.sql.DataSource;
import java.awt.image.RescaleOp;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by edik2 on 15.05.2018.
 */
public class InHotelDAOImpl implements InHotelDAO{

    private DataSource dataSource;

    public InHotelDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public int addInHotel(InHotel inHotel) {
        String sql = "INSERT INTO in_hotel(guest, employee, date_of_settlement, date_of_eviction, room, cost) VALUES (?,?,?,?,?,?)";


        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

//            String name = booking.getPhoneGuest();
            preparedStatement.setInt(1, inHotel.getGuest());
            preparedStatement.setInt(2, inHotel.getEmployee());
            preparedStatement.setDate(3, new Date(inHotel.getDateOfSettlement().toDate().getTime()));
            preparedStatement.setDate(4, new Date(inHotel.getDateOfEviction().toDate().getTime()));
            preparedStatement.setInt(5, inHotel.getRoom());
            preparedStatement.setInt(6, inHotel.getCost());


            return preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
//            logger.error("Error adding record to Account table ", e);

        }
        return 0;
    }

    @Override
    public int deleteInHotel(InHotel inHotel) {
        return 0;
    }

    @Override
    public List<InHotel> getAllInHotel() {

        String getInHotel = "SELECT id, guest, employee, room, cost, date_of_settlement, date_of_eviction, class_room " +
                "FROM in_hotel";
        Connection connection ;
        PreparedStatement preparedStatement;
        List<InHotel> inHotelList = new ArrayList<>();

        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(getInHotel);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                int guest = resultSet.getInt("guest");
                int employee = resultSet.getInt("employee");
                int room = resultSet.getInt("room");
                int cost = resultSet.getInt("cost");
                int classRoom = resultSet.getInt("class_room");

                DateTime dateSettlement = new DateTime(resultSet.getDate("date_of_settlement").getTime());
                DateTime dateEviction = new DateTime(resultSet.getDate("date_of_eviction").getTime());

                InHotel inHotel = new InHotel(id,guest,employee,dateSettlement,dateEviction,room,classRoom);
                inHotelList.add(inHotel);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return inHotelList;
    }
}
