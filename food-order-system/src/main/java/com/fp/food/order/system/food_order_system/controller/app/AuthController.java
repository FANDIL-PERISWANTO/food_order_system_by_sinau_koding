package com.fp.food.order.system.food_order_system.controller.app;

import com.fp.food.order.system.food_order_system.config.UserLoggedInConfig;
import com.fp.food.order.system.food_order_system.model.request.LoginRequestRecord;
import com.fp.food.order.system.food_order_system.model.request.UserRequestRecord;
import com.fp.food.order.system.food_order_system.model.response.BaseResponse;
import com.fp.food.order.system.food_order_system.service.app.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("login")
    public BaseResponse<?> login(@RequestBody LoginRequestRecord request) {
        return BaseResponse.ok(null, authService.login(request));
    }

    @PostMapping("register")
    public BaseResponse<?> register(@RequestBody UserRequestRecord request) {
        authService.register(request);
        return BaseResponse.ok("Data berhasil disimpan", null);
    }

    @GetMapping("logout")
    public BaseResponse<?> logout(@AuthenticationPrincipal UserLoggedInConfig userLoggedInConfig) {
        var userLoggedIn = userLoggedInConfig.getUser();
        authService.logout(userLoggedIn);
        return BaseResponse.ok("Berhasil logout", null);
    }
}
