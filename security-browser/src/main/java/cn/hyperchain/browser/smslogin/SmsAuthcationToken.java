package cn.hyperchain.browser.smslogin;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * File: SmsAuthcationToken.java
 * Description:
 * Company:
 *
 * @Author: yyz
 * Datetime: 2021-01-29
 */
public class SmsAuthcationToken extends AbstractAuthenticationToken {
    private final Object principal;

    public SmsAuthcationToken(Object principal) {
        super((Collection) null);
        this.principal = principal;
        this.setAuthenticated(false);
    }

    public SmsAuthcationToken(Object principal, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        super.setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return this.principal;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        if (isAuthenticated) {
            throw new IllegalArgumentException("Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
        } else {
            super.setAuthenticated(false);
        }
    }

    @Override
    public void eraseCredentials() {
        super.eraseCredentials();
    }
}