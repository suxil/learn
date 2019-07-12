package com.learn.generate;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;

public class CodeGenerate {

    private static final String BAST_MODULE_NAME = "generate";
    private static final String JAVA_PATH = String.format("/%s/src/main/java", BAST_MODULE_NAME);
    private static final String MAPPER_PATH = String.format("/%s/src/main/resources/mapper/", BAST_MODULE_NAME);
    private static final String AUTHOR = "luxq";

    private static final String URL = "jdbc:mysql://101.132.110.185:3306/public?verifyServerCertificate=false&useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&autoReconnect=true";
    private static final String USERNAME = "learn";
    private static final String PASSWORD = "learn-m";
    private static final String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";

    private static final String MODAL_NAME = "example";
    private static final String PARENT = "com.learn.generate.code";
    private static final String INCLUDE_TABLE_NAME = "user";

    // 如果模板引擎是 freemarker
    private static final String TEMPLATE_PATH = "/templates/mapper.xml.ftl";



    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator autoGenerator = new AutoGenerator();

        // 全局配置
        autoGenerator.setGlobalConfig(getGlobalConfig());

        // 数据源配置
        autoGenerator.setDataSource(getDataSourceConfig());

        // 包配置
        autoGenerator.setPackageInfo(getPackageConfig());

        // 自定义配置
        autoGenerator.setCfg(getInjectionConfig());

        // 配置模板
        autoGenerator.setTemplate(getTemplateConfig());

        // 策略配置
        autoGenerator.setStrategy(getStrategyConfig());

        autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine());

        autoGenerator.execute();
    }

    private static GlobalConfig getGlobalConfig() {
        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        globalConfig.setOutputDir(projectPath + JAVA_PATH);
        globalConfig.setAuthor(AUTHOR);
        globalConfig.setOpen(false);
        globalConfig.setSwagger2(true); // 实体属性 Swagger2 注解
        return globalConfig;
    }

    private static DataSourceConfig getDataSourceConfig() {
        // 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        // dsc.setSchemaName("public");
        dataSourceConfig.setUrl(URL);
        dataSourceConfig.setUsername(USERNAME);
        dataSourceConfig.setPassword(PASSWORD);
        dataSourceConfig.setDriverName(DRIVER_CLASS_NAME);
        return dataSourceConfig;
    }

    private static PackageConfig getPackageConfig() {
        // 包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setModuleName(MODAL_NAME);
        packageConfig.setParent(PARENT);
        return packageConfig;
    }

    private static InjectionConfig getInjectionConfig() {
        // 自定义配置
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        String projectPath = System.getProperty("user.dir");

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(TEMPLATE_PATH) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + MAPPER_PATH + MODAL_NAME + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录");
                return false;
            }
        });
        */
        injectionConfig.setFileOutConfigList(focList);
        return injectionConfig;
    }

    private static TemplateConfig getTemplateConfig() {
        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();

        templateConfig.setXml(null);
        return templateConfig;
    }

    private static StrategyConfig getStrategyConfig() {
        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setSuperEntityClass("com.learn.core.common.BaseDomain");
        strategyConfig.setEntityLombokModel(true);
        strategyConfig.setRestControllerStyle(true);
        // 公共父类
        strategyConfig.setSuperControllerClass("com.learn.core.common.BaseController");
        // 写于父类中的公共字段
        strategyConfig.setSuperEntityColumns("id");
        strategyConfig.setInclude(INCLUDE_TABLE_NAME);
        strategyConfig.setControllerMappingHyphenStyle(true);
        strategyConfig.setTablePrefix(MODAL_NAME + "_");

        return strategyConfig;
    }

}
