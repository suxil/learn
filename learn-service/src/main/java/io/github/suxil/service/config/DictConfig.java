package io.github.suxil.service.config;

import io.github.suxil.dict.api.DictServiceFactory;
import io.github.suxil.dict.api.constant.DictConstant;
import io.github.suxil.dict.core.DefaultDictServiceFactory;
import io.github.suxil.service.service.dict.DictBaseService;
import io.github.suxil.service.service.dict.DictCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DictConfig {

    @Autowired
    private DictBaseService dictBaseService;
    @Autowired
    private DictCategoryService dictCategoryService;

    @Bean
    public DictServiceFactory dictServiceFactory() {
        DictServiceFactory dictServiceFactory = new DefaultDictServiceFactory();

        // 添加数据字典加载服务
        dictServiceFactory.addDictService(DictConstant.DICT_KEY, dictBaseService);
        // 添加其它字典服务
        dictServiceFactory.addDictService(DictConstant.DICT_OTHER_KEY, dictCategoryService);

        return dictServiceFactory;
    }

}
