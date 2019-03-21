package com.xiaoming.springbootlearning.service.impl;

import com.xiaoming.springbootlearning.bo.JwtUserDetails;
import com.xiaoming.springbootlearning.domain.UmUser;
import com.xiaoming.springbootlearning.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Xiaoming.
 * Created on 2019/03/11 23:25.
 */
@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UmUser user = userRepository.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("用户名或密码错误");
        }else{
            return new JwtUserDetails(user);
        }
    }
}
