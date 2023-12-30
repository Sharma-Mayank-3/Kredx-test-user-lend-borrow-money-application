package com.kredx.Kredx.security;

import com.kredx.Kredx.entity.UserEntity;
import com.kredx.Kredx.exception.ResourceNotFoundException;
import com.kredx.Kredx.repo.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = this.userEntityRepository.findByUserName(username).orElseThrow(() -> new ResourceNotFoundException("user", "userName : " + username, 0));
        return user;
    }
}
