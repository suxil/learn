package com.learn.generator.utils;

import com.learn.core.utils.FileIOUtils;
import com.learn.core.utils.ReflectUtils;
import com.learn.core.utils.StringUtils;
import com.learn.generator.annotation.*;
import com.learn.generator.model.BaseXmlModel;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class GeneratorUtils {

	private static String REPLACE_RESULT_MAP = "#:resultMap";//返回结果默认替换
	// 文件后缀
	private static final String JAVA_SUFFIX = ".java";
	private static final String MAPPER_SUFFIX = "Mapper";
	private static final String SERVICE_SUFFIX = "Service";
	private static final String SERVICE_IMPL_SUFFIX = SERVICE_SUFFIX + "Impl";
	private static final String SERVICE_TEST_SUFFIX = SERVICE_SUFFIX + "Test";
	private static final String CONTROLLER_SUFFIX = "Controller";
	private static final String CONTROLLER_TEST_SUFFIX = CONTROLLER_SUFFIX + "Test";

	private static final String DEFAULT_GRP_FIELD_SUFFIX = "List";//默认集合字段后缀
	private static final String DEFAULT_GRP_FOR_ITEM_SUFFIX = "Item";//默认循环项后缀

	private static final String SP_IN_PARAM_PREFIX = "PI&";//存储过程入参前缀
	private static final String SP_OUT_PARAM_PREFIX = "PO&";//存储过程出参前缀

	private static final String IMPORT_BASE_PKG = "import com.coscon.dts";
	private static final String BASE_PKG = "com.coscon.dts.edi.";
	private static final String IMPORT_BASE_MODEL_PKG = IMPORT_BASE_PKG + ".edi.domain.vo.bridge.domain.*;";

	/**
	 * 根据类名生成mapper相关文件
	 * @param className
	 */
	public static void generatorMapping(String className) {
		try {
			Class<?> clazz = Class.forName(className);

			generatorJavaFile(clazz);
			String content = initGenerator(clazz);

			//System.out.println(content);

			FileIOUtils.writeFormat("mybatis/" + getMapperName(clazz) + ".xml", content);

			System.out.println("执行成功。");
		} catch (ClassNotFoundException e) {
			System.out.println("class not error.");
			e.printStackTrace();
		}
	}

	/**
	 * 获取mapper文件名称
	 * @return
	 */
	public static String getMapperName(Class<?> clazz) {
		GeneratorType generatorType = clazz.getAnnotation(GeneratorType.class);
		if (generatorType != null) {
			return generatorType.name() + MAPPER_SUFFIX;
		}
		return "";
	}

	/**
	 * 获取当前clazz命名空间
	 * @param clazz
	 * @return
	 */
	public static String getNamesbase(Class<?> clazz) {
		String str = getMapperName(clazz);
		if (StringUtils.isNotEmpty(str)) {
			return "" + BASE_PKG + ".mapper." + str;
		}
		return "";
	}

	/**
	 * sp回调接口
	 */
	public interface GeneratorCallback {
		void doInGenerator(String name, GeneratorSp[] sps, StringBuilder builder);
	}

	/**
	 * 模板方法提供基础dom根元素
	 * @param clazz
	 * @param action
	 * @return
	 */
	public static void executer(Class<?> clazz, GeneratorCallback action) {
		GeneratorType generatorType = clazz.getAnnotation(GeneratorType.class);
		if (generatorType != null) {
			GeneratorSp[] sps = generatorType.sp();
			if (action != null) {
				StringBuilder builder = new StringBuilder();
				action.doInGenerator(StringUtils.getFirstUpper(generatorType.name()), sps, builder);
			}
		}
	}

	/**
	 * 批量生成resultMap
	 * @param clazz
	 */
	public static String initGenerator(Class<?> clazz) {
		StringBuilder content = new StringBuilder();
		List<Class<?>> clazzList = ReflectUtils.initAllListType(clazz);
		if (clazzList != null && clazzList.size() > 0) {
			generatorMappingSelect(clazzList.get(0), content);
			for (Class<?> clz : clazzList) {
				generatorMappingResultMap(clazz, clz, content);
			}
		}
		initXmlWrap(getNamesbase(clazz), content);
		return content.toString();
	}

	/**
	 * 初始化xml最外层内容
	 * @param content
	 */
	public static void initXmlWrap(String namespace, StringBuilder content) {
		content.insert(0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
				"<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">" +
				"<mapper namespace=\"" + namespace + "\">");
		content.append("</mapper>");
	}

	/**
	 * 生成单个映射文件内容
	 * @param clazz
	 */
	public static void generatorMappingResultMap(Class<?> parentClazz, Class<?> clazz, StringBuilder content) {
		content.append("<resultMap id=\"" + StringUtils.getFirstLower(getReturnType(parentClazz) + clazz.getSimpleName()) + "Res\" type=\"" + clazz.getName() + "\">");
		generatorMapping(clazz, content);
		content.append("</resultMap>");
	}

	/**
	 * 生成结果集映射，添加包裹
	 * @param property
	 * @param clazz
	 * @param content
	 */
	public static void generatorMappingWrap(String property, Class<?> clazz, StringBuilder content) {
		content.append("<association property=\"" + property + "\" javaType=\"" + clazz.getName() + "\">");
		generatorMapping(clazz, content);
		content.append("</association>");
	}

	/**
	 * 生成单个实体结果集映射
	 * @param clazz
	 * @param content
	 * @return
	 */
	public static void generatorMapping(Class<?> clazz, StringBuilder content) {
		Field[] fields = clazz.getDeclaredFields();
		List<Field> list = new ArrayList<>();
		for (int i = 0; i < fields.length; i ++) {
			Field field = fields[i];
			if (field.getType() == String.class) {
				content.append(resultField(field));
			} else if (field.getType().getSuperclass() == BaseXmlModel.class) {
				list.add(field);
			}
		}
		for (Field field : list) {
			generatorMappingWrap(field.getName(), field.getType(), content);
		}
	}

	/**
	 * 获取实体字段对应的结果
	 * @param field
	 * @return
	 */
	public static String resultField(Field field) {
		String columnName = field.getName();
		ColumnAlias columnAlias = field.getAnnotation(ColumnAlias.class);
		if (columnAlias != null) {
			if (StringUtils.isNotEmpty(columnAlias.value())) {
				columnName = columnAlias.value();
			}
			if (StringUtils.isNotEmpty(columnAlias.id())) {
				return "<id property=\"" + columnAlias.id() + "\" column=\"" + columnName + "\" />";
			}
		}
		return "<result property=\"" + field.getName() + "\" column=\"" + StringUtils.getFieldToColumn(columnName).toLowerCase() + "\"/>";
	}

	/**
	 * 生成查询语句标签
	 * @param clazz
	 * @param content
	 */
	public static void generatorMappingSelect(Class<?> clazz, StringBuilder content) {
		executer(clazz, (name, sps, builder) -> {
			for (int i = 0; i < sps.length; i ++) {
				GeneratorSp sp = sps[i];
				generatorSp(clazz, sp, builder);
				// TODO	打印所有存储过程查询字符串
				//System.out.println(builder.toString());
				content.append(builder.toString());
				builder = new StringBuilder();
			}
		});
	}

	/**
	 * 通过sp注解生成存储过程
	 * @param clazz
	 * @param sp
	 * @param builder
	 */
	public static void generatorSp(Class<?> clazz, GeneratorSp sp, StringBuilder builder) {
		if (sp != null) {
			List<String> list = new ArrayList<>();
			initTestVar(sp.param(), list);
			for (String param : list) {
				builder.append(spInParam(param));
			}
			builder.append(spReturnType(sp.returnType()));
			initSp(sp.value(), builder);
			initSpWrap(clazz, sp.name(), builder, sp.clazzType());
		}
	}

	/**
	 * 初始化存储过程
	 * @param sp
	 * @param content
	 */
	public static void initSp(String sp, StringBuilder content) {
		content.insert(0, sp + "(");
		content.append(")");
	}

	/**
	 * 存储过程包裹select标签
	 * @param id
	 * @param content
	 */
	public static void initSpWrap(Class<?> parentClazz, String id, StringBuilder content, Class<?> clazz) {
		initSpWrap(content);
		initSpSelectWrap(parentClazz, id, content, clazz);
	}

	/**
	 * 查询包裹selecct标签
	 * @param id
	 * @param content
	 */
	public static void initSpSelectWrap(Class<?> parentClazz, String id, StringBuilder content, Class<?> clazz) {
		content.insert(0, "<select id=\"" + getMethodName(id) + "\" statementType=\"CALLABLE\" parameterType=\"Map\">");
		content.append("</select>");
		int start = content.indexOf(REPLACE_RESULT_MAP);
		content.replace(start, start + REPLACE_RESULT_MAP.length(), StringUtils.getFirstLower(getReturnType(parentClazz) + getReturnType(clazz)) + "Res");
	}

	/**
	 * 获取返回类型
	 * @param sp
	 * @return
	 */
	public static String getReturnType(GeneratorSp sp) {
		return getReturnType(sp.clazzType());
	}

	/**
	 * 获取返回类型
	 * @param clazz
	 * @return
	 */
	public static String getReturnType(Class<?> clazz) {
		return clazz.getSimpleName();
	}

	/**
	 * 存储过程包裹
	 * @param content
	 */
	public static void initSpWrap(StringBuilder content) {
		content.insert(0, "<![CDATA[ {call ");
		content.append("} ]]>");
	}

	/**
	 * 获取输入参数字符串
	 * @param param
	 * @return
	 */
	public static String spInParam(String param) {
		return "#{" + SP_IN_PARAM_PREFIX + param + ", mode=IN, jdbcType=VARCHAR},";
	}

	/**
	 * 获取存储过程返回类型
	 * @return
	 */
	public static String spReturnType(String param) {
		return "#{" + SP_OUT_PARAM_PREFIX + param + ", mode=OUT, jdbcType=CURSOR, javaType=ResultSet, resultMap=" + REPLACE_RESULT_MAP + "}";
	}

	/**
	 * 生成java相关文件
	 * @param clazz
	 */
	public static void generatorJavaFile(Class<?> clazz) {
		// TODO 生成java文件
		generatorMapper(clazz);
		generatorService(clazz);
		generatorServiceImpl(clazz);
		generatorServiceTest(clazz);
		//generatorController(clazz);
		//generatorControllerTest(clazz);
	}

	/**
	 * 生成mapper文件
	 * @param clazz
	 */
	public static void generatorMapper(Class<?> clazz) {
		executer(clazz, (name, sps, builder) -> {
			for (int i = 0; i < sps.length; i ++) {
				GeneratorSp sp = sps[i];
				builder.append("\n");
				initMethedDesc("    ", sp.desc(), builder);// 方法描述
				builder.append("    void " + getMethodName(sp.name()) + "(Map<String, Object> paramMap);");
				builder.append("\n");
			}
			generatorMapperWrap(name, clazz, builder);

			FileIOUtils.write("mapper/" + name + MAPPER_SUFFIX + JAVA_SUFFIX, builder.toString());
		});
	}

	/**
	 * 生成mapper包裹
	 * @param name
	 * @param builder
	 */
	public static void generatorMapperWrap(String name, Class<?> clazz, StringBuilder builder) {
		builder.insert(0, "package " + BASE_PKG + ".mapper;\n\n"
				+ "import java.util.Map;\n\n"
				+ getClassImport(clazz)
				//+ "import " + BASE_PKG + ".domain.*;\n"
				+ "import com.coscon.dts.common.service.mybatis.mapper.BaseMapper;\n\n"
				+ "public interface " + name + MAPPER_SUFFIX + " extends BaseMapper<" + clazz.getSimpleName() + "> {\n");
		builder.append("\n}");
	}

	/**
	 * 获取当前类的import声明
	 * @param clazz
	 * @return
	 */
	public static String getClassImport(Class<?> clazz) {
		return "import " + clazz.getName() + ";\n";
	}

	/**
	 * 生成service文件
	 * @param clazz
	 */
	public static void generatorService(Class<?> clazz) {
		executer(clazz, (name, sps, builder) -> {
			for (int i = 0; i < sps.length; i ++) {
				GeneratorSp sp = sps[i];
				String methodName = getMethodName(sp.name());
				String type = getReturnType(sp);
				builder.append("\n");
				initMethedDesc("    ", sp.desc(), builder);// 方法描述
				builder.append("    List<" + type + "> " + methodName + "(" + initMethodParam(sp) + ");");
				builder.append("\n");
			}
			generatorServiceWrap(name, clazz, builder);

			FileIOUtils.write("service/" + name + SERVICE_SUFFIX + JAVA_SUFFIX, builder.toString());
		});
	}

	/**
	 * 生成service包裹
	 * @param name
	 * @param builder
	 */
	public static void generatorServiceWrap(String name, Class<?> clazz, StringBuilder builder) {
		builder.insert(0, "package " + BASE_PKG + ".service;\n\n"
				+ "import java.util.List;\n\n"
				+ getClassImport(clazz)
				+ "import com.coscon.dts.common.service.mybatis.BaseService;\n"
				+ IMPORT_BASE_MODEL_PKG + "\n\n"
				+ "public interface " + name + SERVICE_SUFFIX + " extends BaseService<" + clazz.getSimpleName() + "> {\n");
		builder.append("\n}");
	}

	/**
	 * 生成serviceImpl文件
	 * @param clazz
	 */
	public static void generatorServiceImpl(Class<?> clazz) {
		executer(clazz, (name, sps, builder) -> {
			for (int i = 0; i < sps.length; i ++) {
				GeneratorSp sp = sps[i];
				String methodName = getMethodName(sp.name());
				String type = getReturnType(sp);
				builder.append("\n");
				initMethedDesc("    ", sp.desc(), builder);// 方法描述
				builder.append("	@Override\n");
				builder.append("	@SuppressWarnings(\"unchecked\")\n");
				builder.append("	public List<" + type + "> " + methodName + "(" + initMethodParam(sp) + ") {\n");
				builder.append("		Map<String, Object> paramMap = new HashMap<String, Object>();\n");
				buildMapParam(sp.param(), builder);
				builder.append("		try{\n");
				builder.append("			" + StringUtils.getFirstLower(name) + "Mapper." + methodName + "(paramMap);\n");
				builder.append("			List<" + type + "> " + StringUtils.getFirstLower(type) + " = (List<" + type + ">) paramMap.get(\"" + SP_OUT_PARAM_PREFIX + sp.returnType() + "\");\n");

				// TODO 合并对象及子对象
				generatorServiceMerge("			", type, sps, sp.mergeType(), builder);

				builder.append("			return " + StringUtils.getFirstLower(type) + ";\n");
				builder.append("		} catch (Exception e) {\n");
				builder.append("			e.printStackTrace();\n");
				builder.append("		}\n");
				builder.append("		return null;\n");
				builder.append("	}\n");
			}
			generatorServiceImplWrap(name, clazz, builder);

			FileIOUtils.write("service/" + name + SERVICE_IMPL_SUFFIX + JAVA_SUFFIX, builder.toString());
		});
	}

	/**
	 * 合并对象及子对象
	 * @param prefix
	 * @param parentType
	 * @param sps
	 * @param mergeSps
	 * @param builder
	 */
	public static void generatorServiceMerge(String prefix, String parentType, GeneratorSp[] sps, GeneratorMergeSp[] mergeSps, StringBuilder builder) {
		if (mergeSps != null && mergeSps.length > 0) {
			String itemName = StringUtils.getFirstLower(parentType) + DEFAULT_GRP_FOR_ITEM_SUFFIX;
			builder.append(prefix + "if (" + StringUtils.getFirstLower(parentType) + " != null && " + StringUtils.getFirstLower(parentType) + ".size() > 0) {\n");
			builder.append(prefix + "    for (" + parentType + " " + itemName + " : " + StringUtils.getFirstLower(parentType) + ") {\n\n");
			for (GeneratorMergeSp mergeSp : mergeSps) {
				for (String name : mergeSp.ids()) {
					GeneratorSp sp = getSpByName(sps, name);
					String type = getReturnType(sp.clazzType());
					// 是否是list字段类型
					if (mergeSp.isList()) {
						String mergeParamStr = mergeReplaceField(itemName , mergeSp.replaceParam(), sp.param());
						builder.append(prefix + "        List<" + type + "> " + StringUtils.getFirstLower(type) + " = " + StringUtils.getColumnToField(sp.name()) + "(" + mergeParamStr + ");\n");
						builder.append(prefix + "        if (" + StringUtils.getFirstLower(type) + " != null && " + StringUtils.getFirstLower(type) + ".size() > 0) {\n");
						builder.append(prefix + "            " + itemName + "." + StringUtils.getSetMethodByField(type + DEFAULT_GRP_FIELD_SUFFIX) + "(" + StringUtils.getFirstLower(type) + ");\n");
						builder.append(prefix + "        }\n\n");
					} else {
						String mergeName = StringUtils.getFirstLower(type) + StringUtils.getFirstUpper(StringUtils.getColumnToField(sp.name()));
						builder.append(prefix + "        List<" + type + "> " + mergeName + " = " + StringUtils.getColumnToField(sp.name()) + "(" + initMethodParam(sp, false) + ");\n");
						builder.append(prefix + "        if (" + mergeName + " != null && " + mergeName + ".size() > 0) {\n");
						for (String paramField : mergeSp.paramField()) {
							builder.append(prefix + "            " + itemName + "." + StringUtils.getSetMethodByField(paramField) + "(" + mergeName + ".get(0)." + StringUtils.getGetMethodByField(paramField) + "());\n");
						}
						builder.append(prefix + "        }\n\n");
					}
				}
			}
			builder.append(prefix + "    }\n");
			builder.append(prefix + "}\n");
		}
	}

	/**
	 * 替换参数
	 * @param invokePrefix
	 * @param mergeParams
	 * @param params
	 * @return
	 */
	public static String mergeReplaceField(String invokePrefix, ReplaceParam[] mergeParams, String[] params) {
		if (mergeParams.length == 0) {
			return initMethodParam(params, false);
		}
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < params.length; i ++) {
			for (ReplaceParam mParam : mergeParams) {
				if (params[i].equals(mParam.param())) {
					builder.append(invokePrefix + "." + StringUtils.getGetMethodByField(StringUtils.getColumnToField(mParam.parentField())) + "()");
				} else {
					builder.append(StringUtils.getColumnToField(params[i].toUpperCase()));
				}
				if (i < params.length - 1) {
					builder.append(", ");
				}
			}
		}
		return builder.toString();
	}

	/**
	 * 通过sp
	 * @param sps
	 * @param name
	 * @return
	 */
	public static GeneratorSp getSpByName(GeneratorSp[] sps, String name) {
		if (StringUtils.isEmpty(name)) {
			return null;
		}
		GeneratorSp resSp = null;
		for (GeneratorSp sp : sps) {
			if (name.toLowerCase().equals(sp.name().toLowerCase())) {
				resSp = sp;
				break;
			}
		}
		return resSp;
	}

	/**
	 * 构建map传参
	 * @param params
	 * @param builder
	 */
	public static void buildMapParam(String[] params, StringBuilder builder) {
		if (params != null && params.length > 0) {
			for (String param : params) {
				if (StringUtils.isNotEmpty(param)) {
					if (param.split(",").length > 1) {
						buildMapParam(param.split(","), builder);
					} else {
						builder.append("		paramMap.put(\"" + SP_IN_PARAM_PREFIX + param + "\", " + StringUtils.getColumnToField(param.toUpperCase()) + ");\n");
					}
				}
			}
		}
	}

	/**
	 * 生成serviceImpl包裹
	 * @param name
	 * @param builder
	 */
	public static void generatorServiceImplWrap(String name, Class<?> clazz, StringBuilder builder) {
		builder.insert(0, "package " + BASE_PKG + ".service;\n\n"
				+ "import java.util.HashMap;"
				+ "import java.util.List;"
				+ "import java.util.Map;\n\n"
				+ "import org.springframework.beans.factory.annotation.Autowired;\n"
				+ "import org.springframework.stereotype.Service;\n"
				+ "import org.springframework.transaction.annotation.Transactional;\n\n"
				+ "import com.coscon.dts.common.service.mybatis.BaseServiceImpl;\n"
				+ "import " + BASE_PKG + ".mapper." + name + MAPPER_SUFFIX + ";\n"
				+ getClassImport(clazz)
				+ IMPORT_BASE_MODEL_PKG + "\n\n"
				+ "@Service(\"" + StringUtils.getFirstLower(name) + SERVICE_SUFFIX + "\")\n"
				+ "@Transactional(rollbackFor = Throwable.class)\n"
				+ "public class " + name + SERVICE_IMPL_SUFFIX + " extends BaseServiceImpl<" + clazz.getSimpleName() + "> implements " + name + "Service {\n\n"
				+ "    @Autowired\n"
				+ "    private " + name + "Mapper " + StringUtils.getFirstLower(name) + "Mapper;\n");
		builder.append("\n}");
	}

	/**
	 * 生成controller文件
	 * @param clazz
	 */
	public static void generatorController(Class<?> clazz) {
		executer(clazz, (name, sps, builder) -> {
			for (int i = 0; i < sps.length; i ++) {
				GeneratorSp sp = sps[i];
				String methodName = getMethodName(sp.name());
				String type = getReturnType(sp);
				builder.append("\n");
				initMethedDesc("    ", sp.desc(), builder);// 方法描述
				builder.append("    @PostMapping(\"/" + methodName + "\")\n");
				builder.append("    public List<" + type + "> " + methodName + "(" + initMethodParam(sp) + ") {\n");
				builder.append("        List<" + type + "> " + StringUtils.getFirstLower(type) + " = "
						+ StringUtils.getFirstLower(name) + SERVICE_SUFFIX + "." + methodName + "(" + initMethodParam(sp, false) + ");\n");
				builder.append("        return " + StringUtils.getFirstLower(type) + ";\n");
				builder.append("    }\n");
			}
			generatorControllerWrap(name, clazz, builder);

			FileIOUtils.write("controller/" + name + CONTROLLER_SUFFIX + JAVA_SUFFIX, builder.toString());
		});
	}

	/**
	 * 生成controller包裹
	 * @param name
	 * @param builder
	 */
	public static void generatorControllerWrap(String name, Class<?> clazz, StringBuilder builder) {
		builder.insert(0, "package " + BASE_PKG + ".controller;\n\n"
				+ "import java.util.List;\n\n"
				+ "import org.springframework.beans.factory.annotation.Autowired;\n"
				+ "import org.springframework.web.bind.annotation.PostMapping;\n"
				+ "import org.springframework.web.bind.annotation.RequestMapping;\n"
				+ "import org.springframework.web.bind.annotation.RestController;\n\n"
				+ "import " + BASE_PKG + ".service." + name + SERVICE_SUFFIX + ";\n"
				+ getClassImport(clazz)
				+ IMPORT_BASE_MODEL_PKG + "\n\n"
				+ "@RestController\n"
				+ "@RequestMapping(\"/" + StringUtils.getFirstLower(name) + "\")\n"
				+ "public class " + name + CONTROLLER_SUFFIX + " {\n\n"
				+ "    @Autowired\n"
				+ "    private " + name + "Service " + StringUtils.getFirstLower(name) + "Service;\n");
		builder.append("\n}");
	}

	/**
	 * 生成controllerTest文件
	 * @param clazz
	 */
	public static void generatorControllerTest(Class<?> clazz) {
		executer(clazz, (name, sps, builder) -> {
			for (int i = 0; i < sps.length; i ++) {
				GeneratorSp sp = sps[i];
				String methodName = getMethodName(sp.name());
				String type = getReturnType(sp);
				builder.append("\n");
				initMethedDesc("    ", sp.desc(), builder);// 方法描述
				builder.append("    @Test\n");
				builder.append("    @SuppressWarnings(\"unchecked\")\n");
				builder.append("    public void " + methodName + "() {\n");
				builder.append("        List<" + type + "> " + StringUtils.getFirstLower(type)
						+ " = this.restTemplate.postForObject(\"/" + StringUtils.getFirstLower(name) + "/" + methodName
						+ "?" + appendParam(sp.param()) + "\", null, List.class);\n");
				builder.append("        assertNotNull(" + StringUtils.getFirstLower(type) + ");\n");
				builder.append("    }\n");
			}
			generatorTestVar(sps, builder);
			generatorControllerTestWrap(name, clazz, builder);

			FileIOUtils.write("test/" + name + CONTROLLER_TEST_SUFFIX + JAVA_SUFFIX, builder.toString());
		});
	}

	/**
	 * 生成测试变量
	 * @param sps
	 * @param builder
	 */
	public static void generatorTestVar(GeneratorSp[] sps, StringBuilder builder) {
		List<String> list = new ArrayList<>();
		for (GeneratorSp sp : sps) {
			initTestVar(sp.param(), list);
		}
		for (String param : list) {
			builder.insert(0, "    private static String " + StringUtils.getColumnToField(param.toUpperCase()) + " = \"\";\n");
		}
	}

	/**
	 * 初始化参数变量
	 * @param params
	 * @param list
	 */
	public static void initTestVar(String[] params, List<String> list) {
		for (String param : params) {
			if (StringUtils.isNotEmpty(param)) {
				if (param.split(",").length > 1) {
					initTestVar(param.split(","), list);
				} else {
					if (!list.contains(param)) {
						list.add(param);
					}
				}
			}
		}
	}

	/**
	 * 生成controllerTest包裹
	 * @param name
	 * @param builder
	 */
	public static void generatorControllerTestWrap(String name, Class<?> clazz, StringBuilder builder) {
		builder.insert(0, "package " + BASE_PKG + ".controller;\n\n"
				+ "import static org.junit.Assert.assertNotNull;\n\n"
				+ "import java.util.List;\n\n"
				+ "import org.junit.Test;\n"
				+ "import org.junit.runner.RunWith;\n"
				+ "import org.springframework.beans.factory.annotation.Autowired;\n"
				+ "import org.springframework.boot.test.context.SpringBootTest;\n"
				+ "import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;\n"
				+ "import org.springframework.boot.test.web.client.TestRestTemplate;\n"
				+ "import org.springframework.test.annotation.DirtiesContext;\n"
				+ "import org.springframework.test.context.junit4.SpringRunner;\n\n"
				+ getClassImport(clazz)
				+ IMPORT_BASE_MODEL_PKG + "\n\n"
				+ "@RunWith(SpringRunner.class)\n"
				+ "@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)\n"
				+ "@DirtiesContext\n"
				+ "public class " + name + CONTROLLER_TEST_SUFFIX + " {\n\n"
				+ "    @Autowired\n"
				+ "    private TestRestTemplate restTemplate;\n\n");
		builder.append("\n}");
	}

	/**
	 * 生成serviceTest文件
	 * @param clazz
	 */
	public static void generatorServiceTest(Class<?> clazz) {
		executer(clazz, (name, sps, builder) -> {
			for (int i = 0; i < sps.length; i ++) {
				GeneratorSp sp = sps[i];
				String methodName = getMethodName(sp.name());
				String type = getReturnType(sp);
				builder.append("\n");
				initMethedDesc("    ", sp.desc(), builder);// 方法描述
				builder.append("    @Test\n");
				builder.append("    public void " + methodName + "() {\n");
				builder.append("        List<" + type + "> " + StringUtils.getFirstLower(type) + " = "
						+ StringUtils.getFirstLower(name) + SERVICE_SUFFIX + "." + methodName + "(" + initMethodParam(sp, false) + ");\n");

				// TODO service write xml to file
				//builder.append("\n        FileUtil.write(\"xml/" + StringUtils.getFirstLower(type) + "-" + methodName + ".xml\", Dom4jXmlUtil.getXmlString(" + StringUtils.getFirstLower(type) + "));\n\n");
				builder.append("\n        FileUtil.writeFormat(\"xml/" + StringUtils.getFirstLower(clazz.getSimpleName()) + "-" + methodName + ".xml\", Dom4jXmlUtil.getXmlDocument(" + StringUtils.getFirstLower(type) + "));\n\n");
				if (methodName.equals("head")) {
					builder.append("\n        FileUtil.writeByFtl(\"" + type + ".ftl\", " + StringUtils.getFirstLower(type) + ".get(0), \"xml/" + StringUtils.getFirstLower(clazz.getSimpleName()) + "-" + methodName + "-\" + System.currentTimeMillis() + \".xml\");");
				}

				builder.append("        assertNotNull(" + StringUtils.getFirstLower(type) + ");\n");
				builder.append("    }\n");
			}
			generatorTestVar(sps, builder);
			generatorServiceTestWrap(name, clazz, builder);

			FileIOUtils.write("test/" + name + SERVICE_TEST_SUFFIX + JAVA_SUFFIX, builder.toString());
		});
	}

	/**
	 * 生成serviceTest包裹
	 * @param name
	 * @param builder
	 */
	public static void generatorServiceTestWrap(String name, Class<?> clazz, StringBuilder builder) {
		builder.insert(0, "package " + BASE_PKG + ".service;\n\n"
				+ "import static org.junit.Assert.assertNotNull;\n\n"
				+ "import java.util.List;\n\n"
				+ "import org.junit.Test;\n"
				+ "import org.junit.runner.RunWith;\n"
				+ "import org.springframework.beans.factory.annotation.Autowired;\n"
				+ "import org.springframework.boot.test.context.SpringBootTest;\n"
				+ "import org.springframework.test.context.junit4.SpringRunner;\n\n"
				+ getClassImport(clazz)
				+ IMPORT_BASE_MODEL_PKG + "\n"
				+ "import " + BASE_PKG + ".util.Dom4jXmlUtil;\n"
				+ "import " + BASE_PKG + ".util.FileUtil;\n\n"
				+ "@RunWith(SpringRunner.class)\n"
				+ "@SpringBootTest\n"
				+ "public class " + name + SERVICE_TEST_SUFFIX + " {\n\n"
				+ "    @Autowired\n"
				+ "    private " + name + SERVICE_SUFFIX + " " + StringUtils.getFirstLower(name) + SERVICE_SUFFIX + ";\n\n");
		builder.append("\n}");
	}

	/**
	 * 通过sp获取方法参数和其他参数
	 * @param sp
	 * @return
	 */
	public static String initMethodParam(GeneratorSp sp) {
		return initMethodParam(sp, true);
	}

	/**
	 * 通过sp获取方法参数和其他参数
	 * @param sp
	 * @return
	 */
	public static String initMethodParam(GeneratorSp sp, boolean isMethod) {
		List<String> list = new ArrayList<>();
		for (String param : sp.param()) {
			list.add(param);
		}
		for (String param : sp.otherParam()) {
			list.add(param);
		}
		return initMethodParam(list.toArray(new String[list.size()]), isMethod);
	}

	/**
	 * 获取参数字符串
	 * @param params
	 * @return
	 */
	public static String initMethodParam(String[] params) {
		return initMethodParam(params, true);
	}

	/**
	 * 追加测试方法调用参数
	 * @param params
	 * @return
	 */
	public static String appendParam(String[] params) {
		if (params != null && params.length > 0) {
			StringBuilder builder = new StringBuilder();
			for (String param : params) {
				if (StringUtils.isNotEmpty(param)) {
					if (param.split(",").length > 1) {
						builder.append(appendParam(param.split(",")));
					} else {
						String str = StringUtils.getColumnToField(param.toUpperCase());
						builder.append(str + "=\" + " + str + " + \"&");
					}
				}
			}
			String str = builder.toString();
			if (str.lastIndexOf("&") == str.length() - 1) {
				return str.substring(0, str.length() - 1);
			}
			return str;
		}
		return "";
	}

	/**
	 * 获取参数字符串
	 * @param params
	 * @param isMethod
	 * @return
	 */
	public static String initMethodParam(String[] params, boolean isMethod) {
		if (params != null && params.length > 0) {
			StringBuilder builder = new StringBuilder();
			for (String param : params) {
				if (StringUtils.isNotEmpty(param)) {
					if (param.split(",").length > 1) {
						builder.append(initMethodParam(param.split(","), isMethod));
					} else {
						if (isMethod) {
							builder.append("String " + StringUtils.getColumnToField(param.toUpperCase()) + ", ");
						} else {
							builder.append(StringUtils.getColumnToField(param.toUpperCase()) + ", ");
						}
					}
				}
			}
			String str = builder.toString();
			if (str.lastIndexOf(", ") == str.length() - 2) {
				return str.substring(0, str.length() - 2);
			}
			return str;
		}
		return "";
	}

	/**
	 * 返回方法对应名称
	 * @param name
	 * @return
	 */
	public static String getMethodName(String name) {
		return StringUtils.getColumnToField(name);
	}

	/**
	 * 添加描述
	 * @param prefix
	 * @param desc
	 * @param builder
	 */
	public static void initMethedDesc(String prefix, String desc, StringBuilder builder) {
		if (StringUtils.isNotEmpty(desc)) {
			builder.append(prefix + "/**\n");
			builder.append(prefix + " * " + desc + "\n");
			builder.append(prefix + " */\n");
		}
	}

}
