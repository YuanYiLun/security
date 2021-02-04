package cn.hyperchain.demo;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * File: Application.java
 * Description:
 * Company:
 *
 * @Author: yyzSecurityDemoApplication
 * Datetime: 2021-01-13
 */
@SpringBootApplication(
        scanBasePackages = {"cn.hyperchain.demo",
                "cn.hyperchain.browser"
        }
)
@MapperScan("cn.hyperchain.browser.mapper")
@EnableSwagger2
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
