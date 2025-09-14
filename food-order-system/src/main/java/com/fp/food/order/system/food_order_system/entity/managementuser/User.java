package com.fp.food.order.system.food_order_system.entity.managementuser;

import com.fp.food.order.system.food_order_system.entity.app.BaseEntity;
import com.fp.food.order.system.food_order_system.model.enums.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "m_users", indexes = {
        @Index(name = "idx_users_created_date", columnList = "createdDate"),
        @Index(name = "idx_users_modified_date", columnList = "modifiedDate"),
        @Index(name = "idx_users_username", columnList = "username"),
        @Index(name = "idx_users_email", columnList = "email"),
        @Index(name = "idx_users_status", columnList = "status"),
        @Index(name = "idx_users_role", columnList = "role"),
        @Index(name = "idx_users_alamat", columnList = "alamat")
})
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false, unique = true)
    private String nama;

    @Column(nullable = false)
    private String alamat;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    private String token;



    private LocalDateTime expiredTokenAt;

}
