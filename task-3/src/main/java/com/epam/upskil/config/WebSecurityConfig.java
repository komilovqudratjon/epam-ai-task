package com.epam.upskil.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
/**
 * @className: WebSecurityConfig  $
 * @description: TODO
 * @date: 06 November 2023 $
 * @time: 11:01 PM 06 $
 * @author: Qudratjon Komilov
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/users/**").permitAll() // You would secure these endpoints appropriately
                .antMatchers("/posts/**").permitAll() // You would secure these endpoints appropriately
                .anyRequest().authenticated()
                .and()
                .httpBasic(); // For the sake of simplicity in this example
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Set up the user details service or in-memory authentication for the example
        auth.inMemoryAuthentication()
                .withUser("user")
                .password(passwordEncoder().encode("password"))
                .authorities("ROLE_USER");
    }
}