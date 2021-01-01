package com.mysecurity.springbootJpaMysqlSecurityDemo.security;

import com.mysecurity.springbootJpaMysqlSecurityDemo.entity.UserCred;
import com.mysecurity.springbootJpaMysqlSecurityDemo.repository.UserCredRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserCredRepo userCredRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserCred userCred = userCredRepo.findByUsername(username);
        return new MyUserDetails(userCred);
    }
}
