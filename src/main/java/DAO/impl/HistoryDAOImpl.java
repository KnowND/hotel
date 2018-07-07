package DAO.impl;

import DAO.HistoryDAO;
import DTO.History;
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
public class HistoryDAOImpl implements HistoryDAO {

    private DataSource dataSource;

    public HistoryDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public int addHistoryRecord(History history) {
        String sql = "INSERT INTO history(room, cost, guest, employee, date_of_settlement, date_of_eviction) VALUES (?,?,?,?,?,?)";


        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

//            String name = booking.getPhoneGuest();
            preparedStatement.setInt(1, history.getRoom());
            preparedStatement.setInt(2, history.getCost());
            preparedStatement.setString(3, history.getGuest());
            preparedStatement.setString(4, history.getEmployee());
            preparedStatement.setDate(5, new java.sql.Date(history.getDateSettlement().toDate().getTime()));
            preparedStatement.setDate(6, new java.sql.Date(history.getDateEviction().toDate().getTime()));
            return preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
//            logger.error("Error adding record to Account table ", e);

        }
        return 0;
    }

    @Override
    public List<History> getAllHistory() {
        String sql = "SELECT id, room, cost, guest, employee, date_of_settlement, date_of_eviction, guestId, employeeId FROM history";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            List<History> historyList = new ArrayList<>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int guestId = resultSet.getInt("guestId");
                int employeeId = resultSet.getInt("employeeId");
                int room = resultSet.getInt("room");
                int cost = resultSet.getInt("cost");
                String guest = resultSet.getString("guest");
                String employee = resultSet.getString("employee");
                DateTime dateSettlement = new DateTime(resultSet.getDate("date_of_settlement").getTime());
                DateTime dateEviction = new DateTime(resultSet.getDate("date_of_eviction").getTime());

                History history = new History(id, room, cost, guest, employee, dateSettlement, dateEviction, guestId, employeeId);
                historyList.add(history);
            }
            return historyList;
        } catch (SQLException e) {
            e.printStackTrace();
//            logger.error("Error getting all records from Food table", e);
        }
        return null;
    }

    @Override
    public List<History> getAllHistoryForGuest(int guestId) {
        String sql = "SELECT (id, room, cost, guest, employee, date_of_settlement, date_of_eviction) FROM history WHERE guest = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setInt(1, guestId);
            List<History> historyList = new ArrayList<>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int room = resultSet.getInt("room");
                int cost = resultSet.getInt("cost");
                String guest = resultSet.getString("guest");
                String employee = resultSet.getString("employee");
                DateTime dateSettlement = new DateTime(resultSet.getDate("date_of_settlement").getTime());
                DateTime dateEviction = new DateTime(resultSet.getDate("date_of_eviction").getTime());

                History history = new History(id, room, cost, guest, employee, dateSettlement, dateEviction);
                historyList.add(history);
            }
            return historyList;
        } catch (SQLException e) {
//            e.printStackTrace();
//            logger.error("Error getting all records from Food table", e);
        }
        return null;
    }
}
