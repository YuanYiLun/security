package cn.hyperchain.browser.config;

import cn.hyperchain.browser.handler.LoginFailHandler;
import cn.hyperchain.browser.handler.LoginSucessHandler;
import cn.hyperchain.browser.smslogin.SmsAuthcationFilter;
import cn.hyperchain.browser.smslogin.SmsAuthcationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * File: SecurityCoreConfig.java
 * Description:
 * Company:
 *
 * @Author: yyz
 * Datetime: 2021-01-29
 */
@Configuration
public class SecurityCoreConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    @Autowired
    private LoginSucessHandler loginSucessHandler;

    @Autowired
    private LoginFailHandler loginFailHandler;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        SmsAuthcationFilter smsAuthcationFilter = new SmsAuthcationFilter();
        AuthenticationManager authenticationManager = http.getSharedObject(AuthenticationManager.class);
        smsAuthcationFilter.setAuthenticationManager(authenticationManager);


        smsAuthcationFilter.setAuthenticationSuccessHandler(loginSucessHandler);
        smsAuthcationFilter.setAuthenticationFailureHandler(loginFailHandler);

        SmsAuthcationProvider smsAuthcationProvider = new SmsAuthcationProvider();

        http.authenticationProvider(smsAuthcationProvider)
                .addFilterAfter(smsAuthcationFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
