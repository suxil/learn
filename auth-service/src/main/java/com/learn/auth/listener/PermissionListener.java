package com.learn.auth.listener;

import com.learn.auth.domain.UaaOperate;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

@Component
public class PermissionListener implements ApplicationListener<ApplicationStartedEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        System.out.println("called");
        ApplicationContext applicationContext = applicationStartedEvent.getApplicationContext();
        BeanFactory beanFactory = applicationStartedEvent.getApplicationContext().getBeanFactory();
        if (beanFactory instanceof DefaultListableBeanFactory) {
            DefaultListableBeanFactory listableBeanFactory = (DefaultListableBeanFactory) beanFactory;

        }



        RequestMappingHandlerMapping requestMappingHandlerMapping = applicationContext.getBean(RequestMappingHandlerMapping.class);
        Map<RequestMappingInfo, HandlerMethod> handlerMethodMap = requestMappingHandlerMapping.getHandlerMethods();
        for (RequestMappingInfo requestMappingInfo : handlerMethodMap.keySet()) {
            HandlerMethod handlerMethod = handlerMethodMap.get(requestMappingInfo);

            String operateType = Optional.of(requestMappingInfo.getMethodsCondition().toString()).orElse("");
            RequestMapping apiRequestMapping = handlerMethod.getBeanType().getAnnotation(RequestMapping.class);
            String apiUrl = Optional.of(apiRequestMapping != null ? Arrays.toString(apiRequestMapping.value()) : "").orElse("") + requestMappingInfo.getPatternsCondition().toString();

            UaaOperate uaaOperate = new UaaOperate();
            uaaOperate.setSeq(1);
            uaaOperate.setOperateType(operateType);
            uaaOperate.setOperateCode(handlerMethod.getBeanType().getName() + "_" + apiUrl + operateType);
            uaaOperate.setOperateUrl(apiUrl);
            uaaOperate.setOperateParam(Arrays.toString(handlerMethod.getMethodParameters()));

            Method method = handlerMethod.getMethod();
            ApiModelProperty apiModelProperty = method.getAnnotation(ApiModelProperty.class);
            if (apiModelProperty != null) {
                uaaOperate.setOperateName(Optional.of(apiModelProperty.value()).orElse(""));
                uaaOperate.setDescription(Optional.of(apiModelProperty.value()).orElse(""));
            } else {
                uaaOperate.setOperateName(operateType);
                uaaOperate.setDescription(apiUrl);
            }

            System.out.println();
        }
//        beanFactory.get
    }

}
