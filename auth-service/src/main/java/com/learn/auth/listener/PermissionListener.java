package com.learn.auth.listener;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.learn.auth.domain.UaaOperate;
import com.learn.auth.domain.UaaPermission;
import com.learn.auth.service.UaaOperateService;
import com.learn.auth.service.UaaPermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;
import java.util.*;

@Component
public class PermissionListener implements ApplicationListener<ApplicationStartedEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(PermissionListener.class);

    @Value("${spring.application.name}")
    private String serviceName;

    @Autowired
    private UaaOperateService uaaOperateService;
    @Autowired
    private UaaPermissionService uaaPermissionService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        LOGGER.debug("========================== START INIT PERMISSION ==========================");

        ApplicationContext applicationContext = applicationStartedEvent.getApplicationContext();
        BeanFactory beanFactory = applicationStartedEvent.getApplicationContext().getBeanFactory();
        if (beanFactory instanceof DefaultListableBeanFactory) {
            DefaultListableBeanFactory listableBeanFactory = (DefaultListableBeanFactory) beanFactory;

        }

        UaaPermission permission = getPermission();
        uaaPermissionService.saveOrUpdate(permission);

        List<UaaOperate> uaaOperateList = new ArrayList<>();
        List<UaaPermission> childPermissionList = new ArrayList<>();

        Map<String, UaaPermission> parentPermissionMap = new HashMap<>();
        Map<String, List<UaaOperate>> operateMap = new HashMap<>();

        RequestMappingHandlerMapping requestMappingHandlerMapping = applicationContext.getBean(RequestMappingHandlerMapping.class);
        Map<RequestMappingInfo, HandlerMethod> handlerMethodMap = requestMappingHandlerMapping.getHandlerMethods();
        for (RequestMappingInfo requestMappingInfo : handlerMethodMap.keySet()) {
            HandlerMethod handlerMethod = handlerMethodMap.get(requestMappingInfo);

            UaaOperate uaaOperate = convertToOperate(requestMappingInfo, handlerMethod);
            uaaOperateList.add(uaaOperate);

            String beanName = handlerMethod.getBean().toString();
            if (!parentPermissionMap.containsKey(beanName)) {
                UaaPermission uaaPermission = convertToPermission(handlerMethod);
                parentPermissionMap.put(beanName, uaaPermission);
            }
            if (operateMap.containsKey(beanName)) {
                operateMap.get(beanName).add(uaaOperate);
            } else {
                List<UaaOperate> list = new ArrayList<>();
                list.add(uaaOperate);
                operateMap.put(beanName, list);
            }
        }

        for (String key : parentPermissionMap.keySet()) {
            UaaPermission uaaPermission = parentPermissionMap.get(key);
            uaaPermission.setParentId(permission.getId());
            uaaPermissionService.saveOrUpdate(uaaPermission);

            List<UaaOperate> operateList = operateMap.get(key);
            for (UaaOperate uaaOperate : operateList) {
                UaaPermission childPermission = convertToPermission(uaaOperate);
                childPermission.setParentId(uaaPermission.getId());
                childPermissionList.add(childPermission);
            }
        }

        uaaOperateService.saveOrUpdateBatch(uaaOperateList);
        uaaPermissionService.saveOrUpdateBatch(childPermissionList);

        LOGGER.debug("========================== PERMISSION INIT SUCCESS ==========================");
    }

    private UaaPermission getPermission() {
        QueryWrapper<UaaPermission> permissionQueryWrapper = new QueryWrapper<>();
        permissionQueryWrapper.eq(UaaPermission.PERMISSION_CODE, serviceName);
        UaaPermission permission = uaaPermissionService.getOne(permissionQueryWrapper);
        if (permission == null) {
            permission = new UaaPermission();
            permission.setParentId("");
            permission.setSeq(1);
            permission.setPermissionCode(serviceName);
            permission.setPermissionName(serviceName);
            permission.setPermissionType("api");
            permission.setDescription(serviceName);
        }
        return permission;
    }

    private UaaOperate convertToOperate(RequestMappingInfo requestMappingInfo, HandlerMethod handlerMethod) {
        String operateType = Optional.of(requestMappingInfo.getMethodsCondition().toString()).orElse("");
        String apiUrl = requestMappingInfo.getPatternsCondition().toString();

        String operateCode = handlerMethod.getBean().toString() + "_" + apiUrl + "_" + operateType;

        QueryWrapper<UaaOperate> operateQueryWrapper = new QueryWrapper<>();
        operateQueryWrapper.eq(UaaOperate.OPERATE_CODE, operateCode);
        UaaOperate uaaOperate = uaaOperateService.getOne(operateQueryWrapper);
        if (uaaOperate == null) {
            uaaOperate = new UaaOperate();
            uaaOperate.setSeq(1);
            uaaOperate.setOperateType(operateType);
            uaaOperate.setOperateCode(operateCode);
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
        }
        return uaaOperate;
    }

    private UaaPermission convertToPermission(HandlerMethod handlerMethod) {
        Api api = handlerMethod.getBeanType().getAnnotation(Api.class);
        RequestMapping apiRequestMapping = handlerMethod.getBeanType().getAnnotation(RequestMapping.class);
        String permissionCode = Arrays.toString(apiRequestMapping.value());

        QueryWrapper<UaaPermission> permissionQueryWrapper = new QueryWrapper<>();
        permissionQueryWrapper.eq(UaaPermission.PERMISSION_CODE, permissionCode);
        UaaPermission uaaPermission = uaaPermissionService.getOne(permissionQueryWrapper);
        if (uaaPermission == null) {
            uaaPermission = new UaaPermission();
            uaaPermission.setSeq(1);
            uaaPermission.setPermissionCode(permissionCode);
            uaaPermission.setPermissionType("api");
            if (api != null) {
                uaaPermission.setPermissionName(api.value());
                uaaPermission.setDescription(api.value());
            } else {
                uaaPermission.setPermissionName(handlerMethod.getBean().toString());
                uaaPermission.setDescription(handlerMethod.getBean().toString());
            }
        }
        return uaaPermission;
    }

    private UaaPermission convertToPermission(UaaOperate uaaOperate) {
        QueryWrapper<UaaPermission> permissionQueryWrapper = new QueryWrapper<>();
        permissionQueryWrapper.eq(UaaPermission.PERMISSION_CODE, uaaOperate.getOperateCode());
        UaaPermission childPermission = uaaPermissionService.getOne(permissionQueryWrapper);
        if (childPermission == null) {
            childPermission = new UaaPermission();
            childPermission.setSeq(1);
            childPermission.setPermissionCode(uaaOperate.getOperateCode());
            childPermission.setPermissionName(uaaOperate.getOperateName());
            childPermission.setPermissionType("api");
            childPermission.setDescription(uaaOperate.getDescription());
        }
        return childPermission;
    }

}
