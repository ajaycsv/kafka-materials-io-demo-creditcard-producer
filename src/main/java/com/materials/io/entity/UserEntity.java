package com.materials.io.entity;

import lombok.Data;

/**
 * This would be JPA managed entity
 */
@Data
public class UserEntity {
    private Long id;

    private String email;

    private String password;

    private String role;

    private String extraInfo;
}