package cn.hyperchain.browser.config;

import cn.hyperchain.browser.bean.AccountEntity;
import cn.hyperchain.browser.mapper.AccountEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * File: MyUserDetailService.java
 * Description:
 * Company:
 *
 * @Author: yyz
 * Datetime: 2021-01-22
 */
public class MyUserDetailService implements UserDetailsService {

    @Bean
    public PasswordEncoder create() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private AccountEntityMapper accountEntityMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        AccountEntity accountEntity = accountEntityMapper.selectByName(s);
        String pwd = passwordEncoder.encode(s);
        System.out.println(pwd);
        return new User(s, pwd, AuthorityUtils.createAuthorityList("admin"));
    }
}
