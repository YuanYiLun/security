package cn.hyperchain.browser.smslogin;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * File: SmsAuthcationFilter.java
 * Description:
 * Company:
 *
 * @Author: yyz
 * Datetime: 2021-01-29
 */
public class SmsAuthcationFilter extends AbstractAuthenticationProcessingFilter {
    public static final String MOBILE = "mobile";
    private String mobile = MOBILE;
    private boolean postOnly = true;


    public SmsAuthcationFilter() {
        super(new AntPathRequestMatcher("/smscode", "POST"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (this.postOnly && !request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        } else {
            String tmpMobile = this.obtainMobile(request);
            if (tmpMobile == null) {
                tmpMobile = "";
            }

            tmpMobile = tmpMobile.trim();
            SmsAuthcationToken authRequest = new SmsAuthcationToken(tmpMobile);
            this.setDetails(request, authRequest);
            return this.getAuthenticationManager().authenticate(authRequest);
        }
    }


    protected String obtainMobile(HttpServletRequest request) {
        return request.getParameter(this.mobile);
    }

    protected void setDetails(HttpServletRequest request, SmsAuthcationToken authRequest) {
        authRequest.setDetails(this.authenticationDetailsSource.buildDetails(request));
    }

    public void setMobile(String mobile) {
        Assert.hasText(mobile, "Username parameter must not be empty or null");
        this.mobile = mobile;
    }


    public void setPostOnly(boolean postOnly) {
        this.postOnly = postOnly;
    }

    public final String getMobile() {
        return this.mobile;
    }

}