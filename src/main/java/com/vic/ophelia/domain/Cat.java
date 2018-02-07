package com.vic.ophelia.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

/**
 * 测试jpa自动创建对象
 *
 * @author vicdor
 * @create 2018-02-05 15:23
 */
@Entity
@Getter
@Setter
public class Cat {
    @Id
    @GeneratedValue
    private Integer id;
    @NotEmpty(message = "姓名不能为空")
    private String name;
    @Min(value = 18,message = "未成年禁止入内")
    private Integer age;

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
