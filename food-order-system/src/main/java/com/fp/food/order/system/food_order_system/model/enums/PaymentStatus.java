package com.fp.food.order.system.food_order_system.model.enums;

import lombok.Getter;

@Getter
public enum PaymentStatus {
    DRAFT ("Draft"),
    PAID ("Paid");

    private final String label;
    PaymentStatus(String label){ this.label = label;}
}
