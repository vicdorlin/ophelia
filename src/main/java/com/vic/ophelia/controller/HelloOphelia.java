package com.vic.ophelia.controller;

import com.vic.ophelia.prop.HerProperties;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * love my dear Ophelia
 *
 * @author vicdor
 * @create 2018-02-02 11:48
 */
@RestController
public class HelloOphelia {
    /*@Value("${fullName}")
    private String fullName;
    @Value("${fromHeart}")
    private String fromHeart;*/
    @Resource
    private HerProperties herProperties;

    @RequestMapping("hello/{id}")
    public String sayHello(@PathVariable("id") Integer id) {
        return herProperties.getFirstName()
                + " is a " + herProperties.getSex()
                + " with age of " + herProperties.getAge()
                + " and her id is " + id;
    }

    @RequestMapping("hello2")
    public String sayHello2(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
        return herProperties.getFirstName()
                + " is a " + herProperties.getSex()
                + " with age of " + herProperties.getAge()
                + " and her id is " + id;
    }

    @GetMapping("methodTest")
    public String testGet() {
        return "get";
    }

    @PostMapping("methodTest")
    public String testPost() {
        return "post";
    }

    @DeleteMapping("methodTest")
    public String testDelete() {
        return "delete";
    }
}
