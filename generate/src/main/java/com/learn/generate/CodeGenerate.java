package com.learn.generate;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.LikeTable;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CodeGenerate {

    public static final String MAPPER_NAME = "repository";
    private static final String BAST_MODULE_NAME = "generate";
    public static final String BAST_PATH = String.format("/%s/src/main/resources/generatecode/src/main/", BAST_MODULE_NAME);
    public static final String BAST_TEST_PATH = String.format("/%s/src/main/resources/generatecode/src/test/", BAST_MODULE_NAME);
    private static final String JAVA_PATH = BAST_PATH + "java/";
    private static final String MAPPER_PATH = BAST_PATH + "resources/mapper/";
    private static final String AUTHOR = "generate";

    public static final String DATASOURCE_PATH = "classpath:datasource.properties";

    private static final String[] EXCLUDE_SUPER_ENTITY_FIELD = {
            "id", "tenant_id", "office_code",
            "created_by", "created_at", "updated_by", "updated_at",
            "create_by", "create_date", "update_by", "update_date",
            "version", "is_deleted"
    };
    private static final String PARENT = "com.learn.auth";

    // cdm, tem, zyj
    private static final boolean CLEAN_DIR = true; // 是否删除之前生成的代码
    private static final String MODAL_NAME = "uaa";
    private static final boolean IS_SUB_MODAL = false;
    private static final String TABLE_PREFIX_STR = MODAL_NAME + "_";
    private static final String TABLE_PREFIX = TABLE_PREFIX_STR + "%";

    public static void main(String[] args) {
        cleanDir();

        // 代码生成器
        AutoGenerator autoGenerator = new AutoGenerator();

        // 全局配置
        autoGenerator.setGlobalConfig(getGlobalConfig());

        // 数据源配置
        autoGenerator.setDataSource(getDataSourceConfig());

        // 包配置
        autoGenerator.setPackageInfo(getPackageConfig());

        // 配置模板
        autoGenerator.setTemplate(getTemplateConfig());

        // 策略配置
        autoGenerator.setStrategy(getStrategyConfig());

        autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine());

        // 自定义配置
        autoGenerator.setCfg(getInjectionConfig(autoGenerator));

        autoGenerator.execute();

//        autoGenerator.getTemplateEngine();
    }

    private static void cleanDir() {
        if (!CLEAN_DIR) {
            return;
        }

        String projectPath = System.getProperty("user.dir");
        try {
            FileUtils.deleteDirectory(new File(projectPath + "/generate/src/main/resources/generatecode"));
        } catch (IOException e) {
            System.err.println("清除老目录异常");
        }
    }

    private static GlobalConfig getGlobalConfig() {
        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        globalConfig.setOutputDir(projectPath + JAVA_PATH);
        globalConfig.setAuthor(AUTHOR);
        globalConfig.setOpen(false);
        globalConfig.setSwagger2(true); // 实体属性 Swagger2 注解
        globalConfig.setBaseColumnList(true);

        globalConfig.setServiceName("%sService");
        globalConfig.setMapperName("%sRepository");

        return globalConfig;
    }

    private static DataSourceConfig getDataSourceConfig() {
        // 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        // dsc.setSchemaName("public");

        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource(DATASOURCE_PATH);
        try {
            Properties datasourceProps = PropertiesLoaderUtils.loadProperties(resource);

            dataSourceConfig.setUrl(datasourceProps.getProperty("datasource.url"));
            dataSourceConfig.setUsername(datasourceProps.getProperty("datasource.username"));
            dataSourceConfig.setPassword(datasourceProps.getProperty("datasource.password"));
            dataSourceConfig.setDriverName(datasourceProps.getProperty("datasource.driver-class-name"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataSourceConfig;
    }

    private static PackageConfig getPackageConfig() {
        // 包配置
        PackageConfig packageConfig = new PackageConfig();

        packageConfig.setParent(PARENT);

        String modalPkg = "";
        if (IS_SUB_MODAL) {
            modalPkg = "." + MODAL_NAME;
        }
        packageConfig.setEntity("domain" + modalPkg);
        packageConfig.setService("service" + modalPkg);
        packageConfig.setServiceImpl("service" + modalPkg + ".impl");
        packageConfig.setMapper(MAPPER_NAME + modalPkg);
        packageConfig.setXml(modalPkg + "mapper.xml");
        packageConfig.setController("web.api" + modalPkg);

        return packageConfig;
    }

    private static InjectionConfig getInjectionConfig(AutoGenerator autoGenerator) {
        PackageConfig packageConfig = autoGenerator.getPackageInfo();

        // 自定义配置
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        String projectPath = System.getProperty("user.dir");

        String modalPkg = "";
        if (IS_SUB_MODAL) {
            modalPkg = MODAL_NAME + "/";
        }

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + MAPPER_PATH + modalPkg + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        // RepositoryTest.java
        focList.add(new FileOutConfig("/templates/repositoryTest.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + BAST_TEST_PATH + (PARENT + "." + packageConfig.getMapper()).replace(".", "/") + "/" + modalPkg + tableInfo.getEntityName() + "RepositoryTest" + StringPool.DOT_JAVA;
            }
        });
        // ServiceTest.java
        focList.add(new FileOutConfig("/templates/serviceTest.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + BAST_TEST_PATH + (PARENT + "." + packageConfig.getService()).replace(".", "/") + "/" + modalPkg + tableInfo.getEntityName() + "ServiceTest" + StringPool.DOT_JAVA;
            }
        });
        // ControllerTest.java
        focList.add(new FileOutConfig("/templates/controllerTest.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + BAST_TEST_PATH + (PARENT + "." + packageConfig.getController()).replace(".", "/") + "/" + modalPkg + tableInfo.getEntityName() + "ControllerTest" + StringPool.DOT_JAVA;
            }
        });

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
//         templateConfig.setController("/resources/templates/controller.java");

        templateConfig.setXml(null);
        return templateConfig;
    }

    private static StrategyConfig getStrategyConfig() {
        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setSuperEntityClass("com.learn.mybatis.domain.BaseDomain");
        strategyConfig.setEntityLombokModel(true);
        strategyConfig.setEntityBuilderModel(true);
        strategyConfig.setRestControllerStyle(true);

        // 公共父类
//        strategyConfig.setSuperControllerClass("com.learn.mybatis.web.BaseController");
        strategyConfig.setSuperMapperClass("com.learn.mybatis.repository.BaseRepository");

        // 写于父类中的公共字段
        strategyConfig.setSuperEntityColumns(EXCLUDE_SUPER_ENTITY_FIELD);
        strategyConfig.setControllerMappingHyphenStyle(true);
        LikeTable likeTable = new LikeTable(TABLE_PREFIX);
        strategyConfig.setLikeTable(likeTable);

        return strategyConfig;
    }

}
