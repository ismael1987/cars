package com.cars.demo.security;

import com.cars.demo.model.User;
import com.cars.demo.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) {
        Optional<User> user = userRepository.findOneByLogin(login);
        if (!user.isPresent()) {
            throw new UsernameNotFoundException(login);
        }
        return new UserPrincipal(user.get());
    }
}
