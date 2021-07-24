package com.example.hotel2.repository;


import com.example.hotel2.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RoomRepository extends JpaRepository<Room, String> {



    @Transactional
    @Modifying
    @Query("update Room Room set Room.status = :status where Room.roomNumber = :roomNumber")
    void setRoomStatus(@Param("status") String status, @Param("roomNumber") String roomNumber);

    @Transactional
    @Modifying
    @Query("update Room Room set Room.level = :level where Room.roomNumber = :roomNumber")
    void setRoomLevel(@Param("level") String level, @Param("roomNumber") String roomNumber);


    @Transactional
    @Modifying
    @Query("update Room Room set Room.condition = :condition where Room.roomNumber = :roomNumber")
    void setRoomCondition(@Param("condition") String condition, @Param("roomNumber") String roomNumber);


    @Transactional
    @Modifying
    @Query("update Room Room set Room.nationalId = :nationalId where Room.roomNumber = :roomNumber")
    void setRenterNationalId(@Param("nationalId") String nationalId, @Param("roomNumber") String roomNumber);




   @Query("SELECT Room.status FROM Room Room WHERE Room.roomNumber = :roomNumber")
    String getRoomStatus(@Param("roomNumber") String roomNumber);




}
