package com.learn.teamlog.config;

import com.learn.core.domain.ResponseDomain;
import com.learn.core.utils.WebUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/7/4 0004 23:16
 */
@Aspect
@Component
public class HttpCsrfAspect {

    private final String POINT_CUT = "";

    @Pointcut("execution(* com.learn.teamlog.api..*.*(..))")
    private void csrfPointCut() {}

    @After("csrfPointCut()")
    public void csrfAfter() {
        WebUtils.getResponse().setHeader("Access-Control-Allow-Origin", "*");
        WebUtils.getResponse().setHeader("Access-Control-Allow-Methods", "*");
    }

    @Around("csrfPointCut()")
    public Object csrfAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object value = proceedingJoinPoint.proceed();
        if (value instanceof ResponseDomain) {
            ResponseDomain responseDomain = (ResponseDomain) value;
            Object pageObj = responseDomain.getData();
            if (pageObj instanceof Page) {
                Page page = (Page) pageObj;
                Map<String, Object> pageResMap = new HashMap<>();
                pageResMap.put("content", page.getContent());
                pageResMap.put("total", page.getTotalElements());
                pageResMap.put("pages", page.getTotalPages());
                responseDomain.setData(pageResMap);
            }
        }
        return value;
    }

}
