package cn.hyperchain.browser.config;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * File: CustomPasswordEncoder.java
 * Description:
 * Company:
 *
 * @Author: yyz
 * Datetime: 2021-01-22
 */
//@Component
public class CustomPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }


    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}
