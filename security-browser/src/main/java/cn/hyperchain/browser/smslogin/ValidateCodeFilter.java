package cn.hyperchain.browser.smslogin;

import cn.hyperchain.browser.handler.LoginFailHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * File: ValidateCodeFilter.java
 * Description:
 * Company:
 *
 * @Author: yyz
 * Datetime: 2021-01-29
 */
@Configuration
public class ValidateCodeFilter extends OncePerRequestFilter {

    @Autowired
    private LoginFailHandler loginFailHandler;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String requestURI = httpServletRequest.getRequestURI();
        String method = httpServletRequest.getMethod();
        if ("/smscode".equalsIgnoreCase(requestURI) && "post".equalsIgnoreCase(method)) {
            try {
                validate(new ServletWebRequest(httpServletRequest));
            } catch (ValidateException e) {
                loginFailHandler.onAuthenticationFailure(httpServletRequest, httpServletResponse, e);
                return;
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private void validate(ServletWebRequest servletWebRequest) {

        //throw new ValidateException("验证码错误");
    }
}
