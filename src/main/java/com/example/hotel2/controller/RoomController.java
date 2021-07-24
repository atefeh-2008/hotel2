package com.example.hotel2.controller;

import com.example.hotel2.domain.Room;
import com.example.hotel2.sevice.RoomService;
import com.example.hotel2.sevice.RoomServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/room")
public class RoomController {

    RoomService roomService;

    @Autowired
    public RoomController(RoomServiceImp roomService) {
        this.roomService = roomService;
    }

   Logger logger = LoggerFactory.getLogger(RoomController.class);



    @DeleteMapping("/{id}")
    public void handleItemDelete(@PathVariable("id") String id) {
        roomService.deleteRoomById(id);
    }
    @GetMapping(value ="/{id}",produces = "application/json")
    public Room handleRoomById(@PathVariable("id") String id) {

       return roomService.getRoomById(id);
    }


    @GetMapping(value = "/rooms",produces = "application/json")
   public List<Room> all() {

        logger.info("An INFO Message");
        return roomService.getAllRooms();
    }


    @PatchMapping("/roomStatus/{status}/{id}")
    public void handleRoomStatusById(@PathVariable("status") String status, @PathVariable("id") String id) {

        roomService.checkUpdatRoomStatusPossibility(status,id);

    }



    @PatchMapping("/roomCondition/{condition}/{id}")
    public void handleRoomConditionById(@PathVariable("condition") String condition, @PathVariable("id") String id) {

        roomService.UpdateRoomConditionById(condition,id);

    }


    @PatchMapping("/roomLevel/{level}//{id}")
    public void handleRoomLevelById(@PathVariable("level") String level, @PathVariable("id") String id) {

        roomService.UpdateRoomLevelById(level,id);

    }

    @PatchMapping("/rentr/{nationalId}/{roomId}")
    public void handleRenterInfo(@PathVariable("nationalId") String nationalId, @PathVariable("roomId") String id) {

        roomService.CheckNationalId(nationalId,id);

    }




  @PostMapping("/{roomNumber}")
 public  void newRoom(@PathVariable("roomNumber") String roomNumber) {
      Room newRoom =new Room(roomNumber);
     roomService.addRoom(newRoom);
  }




}