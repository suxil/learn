//package com.learn.service.config;
//
//import brave.ScopedSpan;
//import brave.Tracer;
//import com.learn.core.aspect.WebLogAspect;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//@Aspect
//@Component
//@Order
//public class TracerAopConfig {
//
//    private static final Logger LOGGER = LogManager.getLogger(WebLogAspect.class);
//
//    @Autowired
//    private Tracer tracer;
//
//    /**
//     * 定义一个切入点.
//     * 解释下：
//     * <p>
//     * ~ 第一个 * 代表任意修饰符及任意返回值.
//     * ~ 第二个 * 任意包名
//     * ~ 第三个 * 代表任意方法.
//     * ~ 第四个 * 定义在web包或者子包
//     * ~ 第五个 * 任意方法
//     * ~ .. 匹配任意数量的参数.
//     */
//    //@Around("execution(public * com.learn.*.web..*.*(..)) && @within(org.springframework.transaction.annotation.Transactional)")
//    @Around("execution(public * com.learn.*.web..*.*(..))")
//    public Object webLog(ProceedingJoinPoint pjp) throws Throwable {
//        // Start a new trace or a span within an existing trace representing an operation
//        ScopedSpan span = tracer.startScopedSpan("encode");
//        try {
//            // The span is in "scope" meaning downstream code such as loggers can see trace IDs
//            Object result = pjp.proceed();
//            return result;
//        } catch (RuntimeException | Error e) {
//            span.error(e); // Unless you handle exceptions, you might not know the operation failed!
//            throw e;
//        } finally {
//            span.finish(); // always finish the span
//        }
//    }
//
//}
