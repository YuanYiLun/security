package cn.hyperchain.browser.smslogin;

import cn.hyperchain.browser.config.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * File: SmsAuthcationProvider.java
 * Description:
 * Company:
 *
 * @Author: yyz
 * Datetime: 2021-01-29
 */
@Configuration
public class SmsAuthcationProvider implements AuthenticationProvider {


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        MyUserDetailService myUserDetailService = new MyUserDetailService();
        SmsAuthcationToken smsAuthcationToken = (SmsAuthcationToken) authentication;
        String mobile = (String) smsAuthcationToken.getPrincipal();
        UserDetails userDetails = myUserDetailService.loadUserByUsername(mobile);
        SmsAuthcationToken token = new SmsAuthcationToken(userDetails, userDetails.getAuthorities());
        return token;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return SmsAuthcationToken.class.isAssignableFrom(aClass);
    }
}
