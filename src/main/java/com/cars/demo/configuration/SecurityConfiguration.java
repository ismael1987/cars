package com.cars.demo.configuration;


import com.cars.demo.security.UserDetailsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter  {


    @Autowired
    private UserDetailsServiceImp userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.authorizeRequests().any;

         http.authorizeRequests()
                 .antMatchers("/").permitAll()
                 .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                 .antMatchers("/color").hasAuthority("ADMIN")
                 .antMatchers("/gear").hasAuthority("ADMIN")
                 .antMatchers("/fuel").hasAuthority("ADMIN")
                 .antMatchers("/country").hasAuthority("ADMIN")
                 .antMatchers("/state").hasAuthority("ADMIN")
                 .antMatchers("/brand").hasAuthority("ADMIN")
                 .antMatchers("/model").hasAuthority("ADMIN")
                 .and()
                 .formLogin().loginPage("/login").failureUrl("/login").permitAll()
                 .and()
                 .logout().permitAll()
                 .and().csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        auth.authenticationProvider(authenticationProviderUser());

      //  auth.authenticationProvider(authenticationProviderAdmin());
    }

    @Bean
    public DaoAuthenticationProvider authenticationProviderUser() {
        DaoAuthenticationProvider authProvider
                = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }


    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    //th:text="${loggedUserName}">Lidia</span></
    //th:if="${param.logout}">You have been logged out</p>

}
