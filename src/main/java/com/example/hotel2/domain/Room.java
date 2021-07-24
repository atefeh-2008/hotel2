package com.example.hotel2.domain;

import javax.persistence.*;

@Entity
@Table(name = "rooms")
public class Room   {

    public Room(){}

    public Room(String roomNumber) {
        this.roomNumber = roomNumber;
        level = "NO VIP";
        status = "EMPTY";
        condition = "CLEAN";
    }

    @Id
    @Column(name="roomNumber")
    private String roomNumber;

    @Column(name="level")
    private String level;

    @Column(name="status")
    private String status;

    @Column(name="condition")
    private String condition;

    @Column(name="nationalId")
    private String nationalId;



    @Id
    public String getRoomNumber() {
        return roomNumber;
    }

    public String getLevel() {
        return level;
    }

    public String getStatus() {
        return status;
    }

    public String getCondition() {
        return condition;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }




    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

}
