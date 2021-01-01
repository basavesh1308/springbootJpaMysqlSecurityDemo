package com.mysecurity.springbootJpaMysqlSecurityDemo.repository;

import com.mysecurity.springbootJpaMysqlSecurityDemo.entity.UserCred;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserCredRepo extends JpaRepository<UserCred, Integer> {
    UserCred findByUsername(String username);
}
