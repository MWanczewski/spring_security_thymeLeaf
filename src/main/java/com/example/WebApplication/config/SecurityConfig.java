package com.example.WebApplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(
                  "/",
                  "/css/**",
                        "/h2-console/**",
                        "/localhost3306/**",
                        "/images/**"
                ).permitAll()
                .antMatchers("/customer","/customer/all").hasRole("USER")
                .anyRequest().authenticated().and().formLogin().permitAll()
                .and().logout().invalidateHttpSession(true)
        .clearAuthentication(true)
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        .logoutSuccessUrl("/")
                .permitAll();

        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

    @Override//role
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = new BCryptPasswordEncoder();

       auth.inMemoryAuthentication()
               .withUser("user")
               .password(encoder.encode("password"))
               .roles("USER")
                .and()
                .withUser( "manager" )
                .password(encoder.encode("password"))
                .roles("MANAGER");
       auth.inMemoryAuthentication()
               .withUser("user3")
               .password(encoder.encode("password"))
               .roles("USER");
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
