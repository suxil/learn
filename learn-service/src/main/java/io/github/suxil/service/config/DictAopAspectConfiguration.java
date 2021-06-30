package io.github.suxil.service.config;

import io.github.suxil.dict.api.annotation.DictEnable;
import io.github.suxil.dict.core.util.DictServerUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

@Aspect
public class DictAopAspectConfiguration {

    /**
     * 定义一个切入点.
     * 解释下：
     * <p>
     * ~ 第一个 * 代表任意修饰符及任意返回值.
     * ~ 第二个 * 任意包名
     * ~ 第三个 * 代表任意方法.
     * ~ 第四个 * 定义在web包或者子包
     * ~ 第五个 * 任意方法
     * ~ .. 匹配任意数量的参数.
     */
    @Around("execution(public * io.github.suxil.service.web..*.*(..))")
    public Object webDictConvert(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result = proceedingJoinPoint.proceed();
        Signature signature = proceedingJoinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        DictEnable dictEnable = method.getAnnotation(DictEnable.class);
        if (dictEnable == null) {
            return result;
        }
        if (!dictEnable.value()) {
            return result;
        }
        DictServerUtil.convert(result);
        return result;
    }

}
