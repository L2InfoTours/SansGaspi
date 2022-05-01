package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import data.User;

public interface UserRepo extends JpaRepository {
    User findByUsername(String username);
}