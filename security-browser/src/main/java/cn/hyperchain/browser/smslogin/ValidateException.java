package cn.hyperchain.browser.smslogin;

import org.springframework.security.core.AuthenticationException;

/**
 * File: ValidateException.java
 * Description:
 * Company:
 *
 * @Author: yyz
 * Datetime: 2021-01-29
 */
public class ValidateException extends AuthenticationException {

    public ValidateException(String msg) {
        super(msg);
    }
}
