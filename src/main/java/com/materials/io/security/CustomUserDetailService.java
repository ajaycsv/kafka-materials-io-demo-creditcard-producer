package com.materials.io.security;

import com.materials.io.entity.UserEntity;
import com.materials.io.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> user = Optional.ofNullable(userService.findByEmail(username).orElseThrow(RuntimeException::new));
        UserEntity userEntity = user.get();

        return UserPrincipal.builder()
                .userId(userEntity.getId())
                .email(userEntity.getEmail())
                .password(userEntity.getPassword())
                .authorities(Collections.singletonList(new SimpleGrantedAuthority(userEntity.getRole())))
                .build();
    }
}
