package com.jwt.example.Service;

import com.jwt.example.Entitties.Users;
import com.jwt.example.repository.Userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private Userrepository userrepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       //load user from database
        Users user=userrepo.findByEmail(username).orElseThrow(()->new RuntimeException("user not found"));
        return user;
    }
}
