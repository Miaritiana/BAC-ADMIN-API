package com.managementbac.bacadmin.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConf extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .antMatchers(HttpMethod.GET).permitAll()
                .antMatchers(HttpMethod.POST).authenticated()
                .antMatchers(HttpMethod.PATCH).authenticated()
                .antMatchers(HttpMethod.PUT).authenticated()
                .antMatchers(HttpMethod.DELETE).hasRole("admin")
                .and()
                .formLogin()
                .and()
                .logout().permitAll()
                .and()
                .csrf().disable()
                .httpBasic();
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        UserDetails corrector = User.builder()
                .username("Corrector")
                .password(passwordEncoder().encode("kaifaHaluk"))
                .roles("corrector")
                .build();
        UserDetails admin = User.builder()
                .username("Admin")
                .password(passwordEncoder().encode("Marhaban"))
                .roles("admin")
                .build();

        return new InMemoryUserDetailsManager(corrector,admin);
    }
}
