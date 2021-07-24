package com.example.hotel2.sevice;


import com.example.hotel2.domain.Room;
import java.util.List;

public interface RoomService {

    void addRoom(Room room);
    Room getRoomById(String id);
    void checkUpdatRoomStatusPossibility(String status, String id);
    List<Room> getAllRooms();
    void deleteRoomById(String id);
 //   void UpdateRoomStatusById(String status,String id);
    void UpdateRoomConditionById(String condition,String id);
    void UpdateRoomLevelById(String level,String id);
    String CheckNationalId(String nationalId, String id);
}

