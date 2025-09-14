package com.fp.food.order.system.food_order_system.service.managementuser;

import com.fp.food.order.system.food_order_system.model.app.SimpleMap;
import com.fp.food.order.system.food_order_system.model.filter.UserFilterRecord;
import com.fp.food.order.system.food_order_system.model.request.UserRequestRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    void add(UserRequestRecord request);

    void edit(UserRequestRecord request);

    Page<SimpleMap> findAll(UserFilterRecord filterRequest, Pageable pageable);

    SimpleMap findById(String id);

}
