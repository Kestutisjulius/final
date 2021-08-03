//package com.java.bend.config;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import javax.sql.DataSource;
//
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    public static final String SELECT_USER = "SELECT username, password, enabled from user where username = ?";
//    public static final String SELECT_AUTHORITY = "SELECT u.username, a.authority FROM authority a, user u WHERE u.username = ? AND u.id = a.user_id";
//    @Autowired
//    private DataSource dataSource;
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .withDefaultSchema()
//                .passwordEncoder(passwordEncoder())
//                .usersByUsernameQuery(SELECT_USER)
//                .authoritiesByUsernameQuery(SELECT_AUTHORITY);
//
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.cors().and().csrf().disable();
//        http.formLogin();
//        http.headers().frameOptions().disable(); //for h2 database visiblity in browser
//        http.authorizeRequests()
//                .antMatchers("/register").permitAll()
//                .antMatchers("/users").hasAnyAuthority("USER", "ADMIN")
//                .antMatchers("/adminPage").hasAuthority("ADMIN")
//                .antMatchers("/**").authenticated();
//    }
//}
