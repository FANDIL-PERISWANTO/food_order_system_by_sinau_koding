package com.fp.food.order.system.food_order_system.mapper.managementuser;

import com.fp.food.order.system.food_order_system.entity.managementuser.User;
import com.fp.food.order.system.food_order_system.model.request.UserRequestRecord;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User requestToEntity(UserRequestRecord request) {
        return User.builder()
                .nama(request.nama().toUpperCase())
                .alamat(request.alamat())
                .username(request.username().toLowerCase())
                .email(request.email().toLowerCase())
                .password(request.password())
                .status(request.status())
                .role(request.role())
                .build();
    }

}
