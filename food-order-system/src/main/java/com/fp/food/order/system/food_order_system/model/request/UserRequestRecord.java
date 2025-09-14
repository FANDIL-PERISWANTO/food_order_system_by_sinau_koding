package com.fp.food.order.system.food_order_system.model.request;

import com.fp.food.order.system.food_order_system.model.enums.*;

public record UserRequestRecord(String id,
                                String nama,
                                String alamat,
                                String username,
                                String email,
                                String password,
                                Status status,
                                Role role) {
}
