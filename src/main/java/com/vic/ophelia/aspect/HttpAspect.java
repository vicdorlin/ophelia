package com.vic.ophelia.aspect;

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
}
