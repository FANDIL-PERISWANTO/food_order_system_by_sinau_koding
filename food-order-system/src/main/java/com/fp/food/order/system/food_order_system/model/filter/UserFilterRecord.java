package com.fp.food.order.system.food_order_system.model.filter;

import com.fp.food.order.system.food_order_system.model.enums.*;

public record UserFilterRecord(String nama,
                               String email,
                               String alamat,
                               String username,
                               Status status,
                               Role role) {
}
