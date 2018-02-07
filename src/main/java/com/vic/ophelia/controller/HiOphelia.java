package com.vic.ophelia.controller;

import com.vic.ophelia.prop.HerProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * hi my dear
 * 先建立Controller
 * 再pom添加thymeleaf模板依赖
 * 再resources添加html
 * <p>
 * 由于现在开发都是前后端分离，使用模板会给性能带来很大损耗，故不推荐使用
 *
 * @author vicdor
 * @create 2018-02-02 14:59
 */
@Controller
@RequestMapping("hi")
public class HiOphelia {
    @Resource
    private HerProperties herProperties;

    //    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @RequestMapping("ophelia")
    @ResponseBody
    public String sayHi() {
        return herProperties.getFirstName() + " is a " + herProperties.getSex() + " with age of " + herProperties.getAge();
    }

//    @RequestMapping(value = {"oph", "elia"}, method = RequestMethod.POST)
//    @GetMapping(value = {"oph", "elia"})
    @PostMapping(value = {"oph", "elia"})
    public String sayHello() {
        return "index";
    }
}
