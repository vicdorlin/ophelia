package com.vic.ophelia.aspect;

import com.vic.ophelia.exception.GlobalException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author vicdor
 * @create 2018-02-07 10:57
 */
@Aspect
@Component
@Slf4j
public class HttpAspect {
//    private static final Logger log = LoggerFactory.getLogger(HttpAspect.class);

    /**
     * 匹配包、类型
     * 匹配vic包 及其子包下所有类的方法
     */
    /*@Pointcut("within(com.vic..*)")
    public void ex1() {
    }

    @Pointcut("this(com.vic.ophelia.controller.CatController)")
    public void ex2() {
    }

    @Pointcut("target(com.vic.ophelia.*)")//这里指定接口
    public void ex3() {
    }

    @Pointcut("bean(*Service)")
    public void ex4() {
    }

    *//**
     * 匹配任意以find开头且只有一个Long参数的方法
     *//*
    @Pointcut("execution(* *..find*(Long))")
    public void ex5() {
    }

    *//**
     * 匹配任只有一个Long参数的方法
     *//*
    @Pointcut("args(Long)")
    public void ex6() {
    }

    *//**
     * 匹配任意以find开头且第一个参数为Long的方法
     *//*
    @Pointcut("execution(* *..find*(Long,..))")
    public void ex7() {
    }

    *//**
     * 匹配第一个参数为Long的方法
     *//*
    @Pointcut("args(Long,..) && within(com.vic.ophelia.controller..*)")
    public void ex8() {
    }

    *//**
     * 匹配标注有Repository的类底下的方法，要求RetenPolicy级别为CLASS
     *//*
    @Pointcut("@within(org.springframework.stereotype.Repository)")
    public void ex9() {
    }

    *//**
     * 匹配标注有Repository的类底下的方法，要求RetenPolicy级别为RUNTIME
     *//*
    @Pointcut("@target(org.springframework.stereotype.Repository)")
    public void ex10() {
    }

    *//**
     * 匹配传入的参数标注有Repository注解的方法
     *//*
    @Pointcut("@args(org.springframework.stereotype.Repository)")
    public void ex11() {
    }*/

    /**
     * ..表示任何参数都拦截 只要是这个方法
     */
    @Pointcut("execution(public * com.vic.ophelia.controller.CatController.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        log.info("url={}", request.getRequestURL());
        //method
        log.info("method={}", request.getMethod());
        //ip
        log.info("ip={}", request.getRemoteAddr());
        //class method
        log.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName());
        //param
        log.info("args={}", joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter() {
        log.info("事后");
    }

    @AfterReturning(returning = "o", pointcut = "log()")
    public void doAfterReturning(Object o) {
        log.info("response={}", o.toString());
    }

    @Pointcut("@annotation(AdminOnly)")
    public void adminOnly() {
    }

    @Before("adminOnly()")
    public void adminOnlyBefore() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String userId = (String) request.getParameter("userId");
        if (userId == null) {
            throw new GlobalException("没有权限");
        }
    }

}
