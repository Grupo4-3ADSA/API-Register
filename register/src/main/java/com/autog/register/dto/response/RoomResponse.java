package com.autog.register.dto.response;

public class RoomResponse {

    private String name;
    private Integer floor;

    public RoomResponse(String name, Integer floor) {
        this.name = name;
        this.floor = floor;
    }

    public String getName() {
        return name;
    }

    public Integer getFloor() {
        return floor;
    }
}
