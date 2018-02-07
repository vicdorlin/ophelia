package com.vic.ophelia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 */
//@ComponentScan(basePackages = { "com.vic.ophelia" })
@SpringBootApplication
public class OpheliaApplication {//implements EmbeddedServletContainerCustomizer {

    public static void main(String[] args) {
        SpringApplication.run(OpheliaApplication.class, args);
    }

    /*@Override
    public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
        configurableEmbeddedServletContainer.setPort(8999);
    }*/
}
