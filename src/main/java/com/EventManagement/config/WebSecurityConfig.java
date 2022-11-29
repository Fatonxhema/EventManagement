package com.EventManagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    public static final String EDITOR = "EDITOR";
    public static final String ADMIN = "ADMIN";
    public static final String USER = "USER";
    public static final String LOGIN = "/login";

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").hasAnyAuthority(USER, EDITOR, ADMIN)
                .antMatchers("/new").hasAnyAuthority(ADMIN, EDITOR)
                .antMatchers("/edit/**").hasAnyAuthority(ADMIN, EDITOR)
                .antMatchers("/delete/**").hasAuthority(ADMIN)
                .antMatchers("/styles/**", "/js/**", "/images/**").permitAll()
                .antMatchers(LOGIN, "/register", "/process_register").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage(LOGIN).failureUrl("/login?error").permitAll()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl(LOGIN).permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/403");
    }
}
