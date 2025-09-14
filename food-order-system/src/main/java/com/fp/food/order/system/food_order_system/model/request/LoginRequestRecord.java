package com.fp.food.order.system.food_order_system.model.request;

import jakarta.validation.constraints.NotBlank;
public record LoginRequestRecord(@NotBlank String username,
                                 @NotBlank String password) {
}
