package com.autog.register.rest.setoreletrico;

import java.time.LocalDateTime;

public class ItemsResposta {

    private Integer id;
    private Integer flagType;
    private LocalDateTime month;
    private Integer value;

    public Integer getId() {
        return id;
    }

    public Integer getFlagType() {
        return flagType;
    }

    public LocalDateTime getMonth() {
        return month;
    }

    public Integer getValue() {
        return value;
    }

}
