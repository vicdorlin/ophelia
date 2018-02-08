package com.vic.ophelia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 */
//@ComponentScan(basePackages = { "com.vic.ophelia" })
@SpringBootApplication
//@MapperScan("com.vic.ophelia.mapper")//添加mybatis包扫描（也可以在mapper类上添加@Mapper）
public class OpheliaApplication {//implements EmbeddedServletContainerCustomizer {

    public static void main(String[] args) {
        SpringApplication.run(OpheliaApplication.class, args);
    }

    /*@Override
    public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
        configurableEmbeddedServletContainer.setPort(8999);
    }*/
}
