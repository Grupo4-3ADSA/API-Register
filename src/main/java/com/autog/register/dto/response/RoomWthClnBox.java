package com.autog.register.dto.response;

public class RoomWthClnBox {

    private Integer idRoom;
    private String name;
    private Integer floor;
    private Integer idClnBox;

    public RoomWthClnBox(Integer idRoom, String name, Integer floor, Integer idClnBox) {
        this.idRoom = idRoom;
        this.name = name;
        this.floor = floor;
        this.idClnBox = idClnBox;
    }

    public Integer getIdClnBox() {
        return idClnBox;
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
