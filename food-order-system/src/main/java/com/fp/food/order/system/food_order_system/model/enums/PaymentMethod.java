package com.fp.food.order.system.food_order_system.model.enums;

public enum PaymentMethod {
    TUNAI ("Tunai"),
    TRANSFER ("Transfer"),
    QRIS("Qris");

    private final String label;
    PaymentMethod(String label){ this.label = label;}
}
