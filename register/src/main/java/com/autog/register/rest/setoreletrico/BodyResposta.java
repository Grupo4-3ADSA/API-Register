package com.autog.register.rest.setoreletrico;

import java.util.List;

public class BodyResposta {

    private Integer total;
    private List<ItemsResposta> items;

    public Integer getTotal() {
        return total;
    }

    public List<ItemsResposta> getItems() {
        return items;
    }
}
