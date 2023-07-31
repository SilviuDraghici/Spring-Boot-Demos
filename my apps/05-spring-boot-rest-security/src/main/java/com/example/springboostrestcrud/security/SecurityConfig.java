package com.example.springboostrestcrud.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsManager dbUsersPlainText(DataSource datasource){
        System.out.println("Creating user details manager!");

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(datasource);

        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "SELECT user_id, pw, active FROM employee_directory.members WHERE user_id = ?"
        );

        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "SELECT user_id, role FROM employee_directory.roles WHERE user_id = ?"
        );

        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
            configurer
                    .requestMatchers(HttpMethod.GET, "/**").hasRole("EMPLOYEE")
                    .requestMatchers(HttpMethod.POST, "/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/**").hasRole("ADMIN")
        );
        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }

    /*@Bean
    public InMemoryUserDetailsManager createUsersManager(){
        System.out.println("Creating Authentication Users!");

        UserDetails admin1 = User.builder()
                .username("admin1")
                .password("{noop}pass1")
                .roles("EMPLOYEE","ADMIN")
                .build();

        UserDetails john = User.builder()
                .username("john")
                .password("{noop}pass1")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}pass1")
                .roles("EMPLOYEE")
                .build();

        return new InMemoryUserDetailsManager(admin1,john,mary);
    }*/
}
