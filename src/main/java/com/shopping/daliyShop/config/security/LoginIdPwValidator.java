package com.shopping.daliyShop.config.security;

import com.shopping.daliyShop.mapper.TestMapper;
import com.shopping.daliyShop.model.TestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginIdPwValidator implements UserDetailsService {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private TestMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String insertedId) throws UsernameNotFoundException {
        TestModel user = mapper.selectById(insertedId);

        if (user == null) {
            return null;
        }

        String pw = user.getUsrPw();
        String roles = user.getRoles();

        return User.builder()
                .username(insertedId)
                .password(pw)
                .roles(roles)
                .build();
    }
}
