package com.fp.food.order.system.food_order_system.service.app.impl;

import com.fp.food.order.system.food_order_system.entity.managementuser.User;
import com.fp.food.order.system.food_order_system.mapper.managementuser.UserMapper;
import com.fp.food.order.system.food_order_system.model.app.SimpleMap;
import com.fp.food.order.system.food_order_system.model.request.LoginRequestRecord;
import com.fp.food.order.system.food_order_system.model.request.UserRequestRecord;
import com.fp.food.order.system.food_order_system.repository.managementuser.UserRepository;
import com.fp.food.order.system.food_order_system.service.app.AuthService;
import com.fp.food.order.system.food_order_system.service.app.ValidatorService;
import com.fp.food.order.system.food_order_system.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final ValidatorService validatorService;
    private final UserMapper userMapper;

    @Override
    public SimpleMap login(LoginRequestRecord request) {
        validatorService.validator(request);

        var user = userRepository.findByUsername(request.username().toLowerCase()).orElseThrow(() -> new RuntimeException("Username atau password salah"));
        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
            throw new RuntimeException("Username atau password salah");
        }
        String token = jwtUtil.generateToken(user.getUsername());
        user.setToken(token);
        user.setExpiredTokenAt(LocalDateTime.now().plusHours(1));
        userRepository.save(user);
        SimpleMap result = new SimpleMap();
        result.put("token", token);
        return result;
    }

    @Override
    public void register(UserRequestRecord request) {
        // validasi mandatory
        validasiMandatory(request);

        // validasi data existing
        if (userRepository.existsByEmail(request.email().toLowerCase())) {
            throw new RuntimeException("Email [" + request.email() + "] sudah digunakan");
        }
        if (userRepository.existsByUsername(request.username().toLowerCase())) {
            throw new RuntimeException("Username [" + request.username() + "] sudah digunakan");
        }

        var user = userMapper.requestToEntity(request);
        user.setPassword(passwordEncoder.encode(request.password()));
        userRepository.save(user);
    }

    @Override
    public void logout(User userLogout) {
        userLogout.setToken(null);
        userLogout.setExpiredTokenAt(null);
        userRepository.save(userLogout);
    }

    private void validasiMandatory(UserRequestRecord request) {
        if (request.nama() == null || request.nama().isEmpty()) {
            throw new RuntimeException("Nama tidak boleh kosong");
        }
        if (request.alamat() == null || request.alamat().isEmpty()) {
            throw new RuntimeException("Alamat tidak boleh kosong");
        }
        if (request.username() == null || request.username().isEmpty()) {
            throw new RuntimeException("Username tidak boleh kosong");
        }
        if (request.email() == null || request.email().isEmpty()) {
            throw new RuntimeException("Email tidak boleh kosong");
        }
        if (request.password() == null || request.password().isEmpty()) {
            throw new RuntimeException("Password tidak boleh kosong");
        }
        if (request.status() == null) {
            throw new RuntimeException("Status tidak boleh kosong");
        }
        if (request.role() == null) {
            throw new RuntimeException("Role tidak boleh kosong");
        }
    }


}
