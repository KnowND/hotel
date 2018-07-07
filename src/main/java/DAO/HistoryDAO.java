package DAO;

import DTO.History;

import java.util.List;

/**
 * Created by edik2 on 15.05.2018.
 */
public interface HistoryDAO {

    int addHistoryRecord(History history);

    List<History> getAllHistory();

    List<History> getAllHistoryForGuest(int id);
}
