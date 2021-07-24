package com.example.hotel2.sevice;

import com.example.hotel2.Exeption.TransactionnotValid;
import com.example.hotel2.domain.Room;
import com.example.hotel2.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImp implements RoomService {

    RoomRepository roomRepository;

    @Autowired
    public RoomServiceImp(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }


    @Override
    public void addRoom(Room room) {
         roomRepository.save(room);
    }

    @Override
    public Room getRoomById(String id)
        {
            Room room =  null;
            return room;
    }

    @Override
    public List<Room> getAllRooms() {
        List<Room> roomList = roomRepository.findAll();
        return roomList;
    }

    @Override
    public void deleteRoomById(String id) {
        {
            roomRepository.deleteById(id);

        }
    }

    @Override
    public void checkUpdatRoomStatusPossibility(String status, String id) {

        UpdateRoomStatusById(status,id);


    }



     void UpdateRoomStatusById(String status, String id) {

         String a = roomRepository. getRoomStatus(id);
if((status == "RESERVE")||
        (status == "EMPTY")||
        (status == "OUT OF ORDER")||
        (status == "FULL")) {

    switch (a) {
        case "RESERVE":
            roomRepository.setRoomStatus(status, id);
            break;
        case "EMPTY":
            roomRepository.setRoomStatus(status, id);
            break;
        case "OUT OF ORDER":
            if ((status.equals("EMPTY"))) {
                roomRepository.setRoomStatus(status, id);
            } else {

                throw new TransactionnotValid(
                        "Invalid input or transaction");
            }
            break;
        case "FULL":
            if ((status.equals("EMPTY")) || (status.equals("OUT_OF_ORDER"))) {
                roomRepository.setRoomStatus(status, id);
            } else {

                throw new TransactionnotValid(
                        "Invalid input or transaction");
            }
            break;

    }
         }
          else{

                 throw new TransactionnotValid(
                    "Invalid input or transaction");

               }


    }


    @Override
    public void UpdateRoomConditionById(String condition, String id) {
        roomRepository.setRoomCondition(condition,id);
    }

    @Override
    public void UpdateRoomLevelById(String level, String id) {
        roomRepository.setRoomLevel(level,id);
    }

    @Override
    public String CheckNationalId(String nationalId, String id) {
        roomRepository.setRenterNationalId(nationalId,id);
return "1";
    }


}
