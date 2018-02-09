package com.vic.ophelia.prop;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 对应于 properties或者yml文件属性
 * 欧菲利亚的属性
 *
 * @author vicdor
 * @create 2018-02-02 13:51
 */
@Component
@ConfigurationProperties(prefix = "ophelia")
@EnableConfigurationProperties(HerProperties.class)
@Getter
@Setter
public class HerProperties {
    private String firstName;
    private String age;
    private String sex;
}
