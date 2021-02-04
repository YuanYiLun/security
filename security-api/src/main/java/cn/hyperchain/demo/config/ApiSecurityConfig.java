package cn.hyperchain.demo.config;

import cn.hyperchain.browser.config.SecurityCoreConfig;
import cn.hyperchain.browser.handler.LoginFailHandler;
import cn.hyperchain.browser.handler.LoginSucessHandler;
import cn.hyperchain.browser.smslogin.SmsAuthcationFilter;
import cn.hyperchain.browser.smslogin.SmsAuthcationProvider;
import cn.hyperchain.browser.smslogin.ValidateCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * File: SecurityConfig.java
 * Description:
 * Company:
 *
 * @Author: yyz
 * Datetime: 2021-01-14
 */
@Configuration
@EnableWebSecurity
public class ApiSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private LoginSucessHandler loginSucessHandler;
    @Autowired
    private LoginFailHandler loginFailHandler;
    @Autowired
    private ValidateCodeFilter validateCodeFilter;

    @Autowired
    private SecurityCoreConfig securityCoreConfig;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class);


        http.formLogin()
                .loginPage("/to/login")
                .loginProcessingUrl("/signin")
                .successHandler(loginSucessHandler)
                .failureHandler(loginFailHandler);

        http.authorizeRequests()
                .antMatchers("/**", "/to/login", "/imooc-signIn.html", "/smscode")
                .permitAll()
                .anyRequest()
                .authenticated();

        http.apply(securityCoreConfig);
        http.csrf().disable();
    }

}
