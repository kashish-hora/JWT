package com.jwt.example.repository;

import com.jwt.example.Entitties.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Userrepository extends JpaRepository<Users,String> {
    public Optional<Users> findByEmail(String email);
}
