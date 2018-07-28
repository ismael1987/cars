package com.cars.demo.configuration;


import com.cars.demo.security.UserDetailsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter  {

    @Autowired
    private UserDetailsServiceImp userDetailsService;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.authorizeRequests().any;

         http.authorizeRequests()
                 .antMatchers("/").permitAll()
//                 .antMatchers("/Color/**").hasAuthority("ADMIN")
                 .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
//                 .anyRequest().fullyAuthenticated()
                 .and()
                 .formLogin().loginPage("/login").failureUrl("/login").permitAll()
                 .and()
                 .logout().permitAll();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //th:text="${loggedUserName}">Lidia</span></
    //th:if="${param.logout}">You have been logged out</p>

}
