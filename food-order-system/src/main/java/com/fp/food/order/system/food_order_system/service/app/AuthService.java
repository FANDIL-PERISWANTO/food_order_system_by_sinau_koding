package com.fp.food.order.system.food_order_system.service.app;

import com.fp.food.order.system.food_order_system.entity.managementuser.User;
import com.fp.food.order.system.food_order_system.model.app.SimpleMap;
import com.fp.food.order.system.food_order_system.model.request.LoginRequestRecord;
import com.fp.food.order.system.food_order_system.model.request.UserRequestRecord;

public interface AuthService {

    SimpleMap login(LoginRequestRecord request);

    void register(UserRequestRecord request);

    void logout(User userLogout);

}
