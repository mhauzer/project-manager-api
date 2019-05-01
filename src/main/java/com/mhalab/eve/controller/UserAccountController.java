package com.mhalab.eve.controller;

import com.mhalab.eve.model.UserAccount;
import com.mhalab.eve.model.UserAccountRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserAccountController {
    private UserAccountRepository userAccountRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserAccountController(UserAccountRepository userAccountRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userAccountRepository = userAccountRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/sign-up")
    public void signUp(@RequestBody UserAccount user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userAccountRepository.save(user);
    }
}
