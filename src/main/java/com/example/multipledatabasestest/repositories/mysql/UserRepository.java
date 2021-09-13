package com.example.multipledatabasestest.repositories.mysql;

import com.example.multipledatabasestest.entities.mysql.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
