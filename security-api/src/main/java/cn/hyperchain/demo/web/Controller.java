package cn.hyperchain.demo.web;

import cn.hyperchain.browser.bean.AccountEntity;
import cn.hyperchain.browser.bean.AppLogEntity;
import cn.hyperchain.browser.mapper.AccountEntityMapper;
import cn.hyperchain.browser.mapper.AppLogEntityMapper;
import io.swagger.annotations.ApiOperation;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * File: Controller.java
 * Description:
 * Company:
 *
 * @Author: yyz
 * Datetime: 2021-01-13
 */
@ApiOperation("test")
@RestController
public class Controller {

    private final String HTML = ".html";

    @Autowired
    private AppLogEntityMapper appLogEntityMapper;
    @Autowired
    private AccountEntityMapper accountEntityMapper;

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    private RequestCache requestCache = new HttpSessionRequestCache();

    @GetMapping("/to/login")
    public Object hello(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SavedRequest cacheRequest = requestCache.getRequest(request, response);
        String redirectUrl = cacheRequest.getRedirectUrl();
        if (redirectUrl.endsWith(HTML)) {
            redirectStrategy.sendRedirect(request, response, "/imooc-signIn.html");
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("code", "500");
        hashMap.put("message", "请登录");
        //设置返回请求头
        return hashMap;
    }


    @GetMapping("/index")
    @ApiOperation("主页")
    public String getLog() {
        ModelAndView modelAndView = new ModelAndView("imooc-signIn");

        return "imooc-signIn";
    }

    @PostMapping("/get/{id}")
    public Object getByLogId(AppLogEntity appLogEntity) {

        AppLogEntity appLogEntitie = appLogEntityMapper.selectByPrimaryKey(appLogEntity.getId());
        return appLogEntitie;


    }

    @GetMapping("/getLog")
    public Object getByLogId2(AppLogEntity appLogEntity) {

        AppLogEntity appLogEntitie = appLogEntityMapper.selectByPrimaryKey(appLogEntity.getId());
        return appLogEntitie;
    }

    @PostMapping("/loginTs")
    public Object getByLogId2(@Validated @RequestBody AccountEntity accountEntity) {
        AccountEntity accountEntity1 = accountEntityMapper.selectByNameAndPassword(accountEntity.getName(), accountEntity.getPassword());
        return accountEntity1;
    }

}
