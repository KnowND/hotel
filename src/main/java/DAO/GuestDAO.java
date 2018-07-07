package DAO;

import DTO.Guest;

/**
 * Created by edik2 on 15.05.2018.
 */
public interface GuestDAO {

    int addGuest(Guest guest);

    Guest getGuestById(int id);


}
