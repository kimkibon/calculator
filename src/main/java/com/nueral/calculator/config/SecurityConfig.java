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
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
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
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/**").permitAll()
//                .antMatchers("/users").hasRole(Role.ADMIN.getAuthority())
                .antMatchers("/insert/**" , "/update/**").hasAnyRole(Role.USER.getAuthority() , Role.ADMIN.getAuthority())

                .and()
                .formLogin()
                .loginPage("/loginForm")
                .usernameParameter("username")
                .passwordParameter("password")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/")
                .successHandler((request, response, authentication) -> {
                    System.out.println("authentication : " + authentication.getName() + "  " + authentication);
                    response.sendRedirect("/");
                })
                .failureHandler((request, response, exception) -> {
                    System.out.println("exception : " + exception.getMessage());
                    response.sendRedirect("/loginForm");
                })
                .permitAll()
        ;

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer WebSecurityCustomizer () {
        //권한 없이 접근 가능한 파일 설정
        return (web) -> web.ignoring().antMatchers("/static/js/**","/static/css/**","/static/img/**");
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
