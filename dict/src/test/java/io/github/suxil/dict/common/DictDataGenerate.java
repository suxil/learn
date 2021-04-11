package io.github.suxil.dict.common;

import io.github.suxil.dict.Dict;
import io.github.suxil.dict.dto.CdmDictCategoryDto;
import io.github.suxil.dict.dto.CdmDictDto;
import io.github.suxil.dict.support.DictImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DictDataGenerate {

    /**
     * 初始化list map数据字典数据
     * @return
     */
    public static List<Map<String, String>> initListMapData() {
        List<Map<String, String>> list = new ArrayList<>();

        Map<String, String> dictMap = new HashMap<>();
        dictMap.put("key", "DICT");
        dictMap.put("category", "TEST");
        dictMap.put("seq", "0");
        dictMap.put("code", "0");
        dictMap.put("name", "关闭");
        dictMap.put("remark", "关闭remark");
        list.add(dictMap);

        dictMap = new HashMap<>();
        dictMap.put("key", "DICT");
        dictMap.put("category", "TEST");
        dictMap.put("seq", "1");
        dictMap.put("code", "1");
        dictMap.put("name", "开启");
        dictMap.put("remark", "开启remark");
        list.add(dictMap);

        dictMap = new HashMap<>();
        dictMap.put("key", "DICT2");
        dictMap.put("category", "TEST2");
        dictMap.put("seq", "0");
        dictMap.put("code", "0");
        dictMap.put("name", "其它");
        dictMap.put("remark", "其它remark");
        list.add(dictMap);

        return list;
    }

    /**
     * 初始化list dict数据字典数据
     * @return
     */
    public static List<CdmDictCategoryDto> initListDictCategoryDtoData() {
        List<CdmDictCategoryDto> dictList = new ArrayList<>();

        String key = "DICT_CATEGORY";

        CdmDictCategoryDto dict = new CdmDictCategoryDto();
        dict.setId("SYSTEM");
        dict.setSeq(0);
        dict.setCategoryCode("SYSTEM");
        dict.setCategoryName("系统");
        dict.setRemark("系统remark");

        dictList.add(dict);

        dict = new CdmDictCategoryDto();
        dict.setId("BASE");
        dict.setSeq(1);
        dict.setCategoryCode("BASE");
        dict.setCategoryName("基础");
        dict.setRemark("基础remark");

        dictList.add(dict);

        return dictList;
    }

    /**
     * 初始化list dict数据字典数据
     * @return
     */
    public static List<CdmDictDto> initListDictDtoData() {
        List<CdmDictDto> dictList = new ArrayList<>();

        CdmDictDto dict = new CdmDictDto();
        dict.setId("SYSTEM1");
        dict.setCategoryId("SYSTEM");
        dict.setSeq(0);
        dict.setDictCode("0");
        dict.setDictName("关闭");
        dict.setRemark("关闭remark");

        dictList.add(dict);

        dict = new CdmDictDto();
        dict.setId("SYSTEM2");
        dict.setCategoryId("SYSTEM");
        dict.setSeq(1);
        dict.setDictCode("1");
        dict.setDictName("开启");
        dict.setRemark("开启remark");

        dictList.add(dict);

        dict = new CdmDictDto();
        dict.setId("BASE1");
        dict.setCategoryId("BASE");
        dict.setSeq(0);
        dict.setDictCode("0");
        dict.setDictName("其它");
        dict.setRemark("其它remark");

        dictList.add(dict);

        return dictList;
    }

    /**
     * 初始化list dict数据字典数据
     * @return
     */
    public static List<Dict> initListDictData() {
        List<Dict> dictList = new ArrayList<>();

        DictImpl dict = new DictImpl();
        dict.setKey("DICT");
        dict.setCategory("TEST");
        dict.setSeq(0);
        dict.setCode("0");
        dict.setName("关闭");
        dict.setRemark("关闭remark");

        dictList.add(dict);

        dict = new DictImpl();
        dict.setKey("DICT");
        dict.setCategory("TEST");
        dict.setSeq(1);
        dict.setCode("1");
        dict.setName("开启");
        dict.setRemark("开启remark");

        dictList.add(dict);

        dict = new DictImpl();
        dict.setKey("DICT2");
        dict.setCategory("TEST2");
        dict.setSeq(0);
        dict.setCode("0");
        dict.setName("其它");
        dict.setRemark("其它remark");

        dictList.add(dict);

        return dictList;
    }

}
