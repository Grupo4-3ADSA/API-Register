package com.autog.register.dto.response;

public class MonthlyConsumption {

    private String name;
    private Integer floor;

    public MonthlyConsumption(String name, Integer floor) {
        this.name = name;
        this.floor = floor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }


    @Override
    public String toString() {
        return "MonthlyConsumption{" +
                "name='" + name + '\'' +
                ", floor=" + floor +
                '}';
    }
}
