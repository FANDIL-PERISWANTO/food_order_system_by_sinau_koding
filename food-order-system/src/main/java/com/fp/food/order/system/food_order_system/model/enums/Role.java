package com.fp.food.order.system.food_order_system.model.enums;

import lombok.Getter;

@Getter
public enum Role {

    PEMBELI("Pembeli"),
    PENJUAL("Penjual"),
    ADMIN("Admin");

    private final String label;

    Role(String label) {
        this.label = label;
    }

}
