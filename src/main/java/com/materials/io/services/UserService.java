package com.materials.io.services;

import com.materials.io.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private static final String EXISTING_EMAIL = "admin@admin.com";
    private static final String OTHER_EMAIL = "user@user.com";

    public Optional<UserEntity> findByEmail(String email) {
        //TODO: All these has to be in DB
        if (EXISTING_EMAIL.equalsIgnoreCase(email)) {
            UserEntity user = new UserEntity();
            user.setId(1L);
            user.setEmail(EXISTING_EMAIL);
            user.setPassword("admin"); // test
            user.setRole("ROLE_ADMIN");
            user.setExtraInfo("My nice admin user");
            return Optional.of(user);
        } else if (OTHER_EMAIL.equalsIgnoreCase(email)) {
            UserEntity user = new UserEntity();
            user.setId(99L);
            user.setEmail(OTHER_EMAIL);
            user.setPassword("user"); // test
            user.setRole("ROLE_USER");
            user.setExtraInfo("My nice simple user");
            return Optional.of(user);
        } else {
            return Optional.empty();
        }
    }
}