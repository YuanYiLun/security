//package cn.hyperchain.browser.config;
//
//import cn.hyperchain.browser.handler.LoginFailHandler;
//import cn.hyperchain.browser.handler.LoginSucessHandler;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
///**
// * File: SecurityConfig.java
// * Description:
// * Company:
// *
// * @Author: yyz
// * Datetime: 2021-01-22
// */
//@EnableWebSecurity
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private LoginSucessHandler loginSucessHandler;
//
//    @Autowired
//    private LoginFailHandler loginFailHandler;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.formLogin()
//                .loginPage("/imooc-signIn.html")
//                .loginProcessingUrl("/signin")
//                .successHandler(loginSucessHandler)
//                .failureHandler(loginFailHandler);
//
//        http.authorizeRequests()
//                .antMatchers("/imooc-signIn.html","/loginTs","/get/**")
//                .permitAll()
//                .anyRequest()
//                .authenticated();
//
//        http.cors().disable();
//    }
//}
//
//
