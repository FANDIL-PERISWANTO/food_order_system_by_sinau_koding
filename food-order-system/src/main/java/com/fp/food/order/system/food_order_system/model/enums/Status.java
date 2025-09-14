package com.fp.food.order.system.food_order_system.model.enums;

import lombok.Getter;

@Getter
public enum Status {

    AKTIF("Aktif"),
    TIDAK_AKTIF("Tidak Aktif");

    private final String label;

    Status(String label) {
        this.label = label;
    }

}
