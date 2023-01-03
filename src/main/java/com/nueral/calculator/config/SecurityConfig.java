package com.nueral.calculator.config;

import com.nueral.calculator.securityAuthentication.UserDetailsServiceImpl;
import com.nueral.calculator.types.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

/*
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring()
                .antMatchers(
                        "/**"
                );
    }
*/

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable();
        http
                .authorizeRequests()
                .antMatchers("/users/**" , "/admin/**").hasAnyAuthority(Role.ADMIN.getAuthority())
                .antMatchers("/insert/**" , "/update/**")
                .hasAnyAuthority(Role.USER.getAuthority() , Role.ADMIN.getAuthority())
                .antMatchers("/**","/static/js/**","/static/css/**","/static/img/**").permitAll()
                .and()
                .formLogin()
                .loginPage("/loginForm")
                .usernameParameter("username")
                .passwordParameter("password")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/")
                .successHandler((request, response, authentication) -> response.sendRedirect("/"))
                .failureHandler((request, response, exception) -> response.sendRedirect("/loginForm"))
                .permitAll()
        ;

        return http.build();
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception{
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder())
                .and()
                .build();
    }

}
