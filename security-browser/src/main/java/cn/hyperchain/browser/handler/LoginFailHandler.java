package cn.hyperchain.browser.handler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * File: LoginFailHandler.java
 * Description:
 * Company:
 *
 * @Author: yyz
 * Datetime: 2021-01-26
 */
@Component
public class LoginFailHandler extends SimpleUrlAuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        //登录失败信息返回
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("code", "500");
        paramMap.put("message", exception.getMessage());
        //设置返回请求头
        response.setContentType("application/json;charset=utf-8");
        //写出流
        PrintWriter out = response.getWriter();
        out.write(paramMap.toString());
        out.flush();
        out.close();
    }
}
