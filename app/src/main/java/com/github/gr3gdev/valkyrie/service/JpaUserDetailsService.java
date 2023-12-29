package com.github.gr3gdev.valkyrie.service;

import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.github.gr3gdev.valkyrie.dao.bean.User;
import com.github.gr3gdev.valkyrie.dao.repository.UserRepository;
import com.github.gr3gdev.valkyrie.model.UserModel;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public JpaUserDetailsService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDetails save(UserModel userModel) {
        final User user = new User();
        user.setUsername(userModel.getUsername());
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));
        user.setFirstname(userModel.getFirstname());
        user.setLastname(userModel.getLastname());
        user.setEmail(userModel.getEmail());
        return mapTo(userRepository.save(user));
    }

    public boolean exists(String username) {
        return userRepository.existsById(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findById(username)
                .map(this::mapTo)
                .orElse(null);
    }

    private UserDetails mapTo(User user) {
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities(user.getAuthorities().stream()
                        .map(auth -> new SimpleGrantedAuthority(auth.getAuthority()))
                        .collect(Collectors.toList()))
                .accountExpired(user.isAccountExpired())
                .accountLocked(user.isAccountLocked())
                .credentialsExpired(user.isCredentialsExpired())
                .disabled(user.isDisabled())
                .build();
    }

}
