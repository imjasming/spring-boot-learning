package com.xiaoming.springbootlearning.config;

import com.xiaoming.springbootlearning.service.impl.JwtUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Xiaoming.
 * Created on 2019/02/07 23:48.
 * Description :
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private JwtUserDetailsServiceImpl jwtUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //we use jwt
                .csrf().disable()
                //don't create session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .anyRequest()
                .permitAll()
        ;
        //添加自定义未授权和未登录结果返回
        /*.exceptionHandling().authenticationEntryPoint(null).accessDeniedHandler(null).and*/

        // 添加JWT filter
        /*http.addFilterBefore(null, UsernamePasswordAuthenticationFilter.class);*/
        // 禁用缓存
        http.headers().cacheControl();



        /*.fullyAuthenticated()
                .and()
                .formLogin()*/
        ;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(jwtUserDetailsService())
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public UserDetailsService jwtUserDetailsService() {
        return username -> {
            return null;
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
