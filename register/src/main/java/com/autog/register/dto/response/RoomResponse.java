package com.autog.register.dto.response;

public class RoomResponse {

    private Integer idRoom;
    private String name;
    private Integer floor;

    public RoomResponse(Integer idRoom, String name, Integer floor) {
        this.idRoom = idRoom;
        this.name = name;
        this.floor = floor;
    }

    public Integer getIdRoom() {
        return idRoom;
    }

    public String getName() {
        return name;
    }

    public Integer getFloor() {
        return floor;
    }
}
