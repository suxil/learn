package io.github.suxil.dict;

import io.github.suxil.dict.dto.CdmDictDto;
import io.github.suxil.dict.support.DefaultDictFactory;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DictFactoryTest {

    @Test
    public void convertTest() {
        DictFactory dictFactory = new DefaultDictFactory();

        DictService dictService = new DictServiceImpl();
        DictService dictCategoryService = new DictCategoryServiceImpl();
        dictFactory.addDictService("DICT", dictService);
        dictFactory.addDictService("DICT_CATEGORY_ID", dictCategoryService);

        List<CdmDictDto> list = new ArrayList<>();

        CdmDictDto cdmDictDto = new CdmDictDto();
        cdmDictDto.setCategoryId("SYSTEM");
        cdmDictDto.setDictCode("0");
        list.add(cdmDictDto);

        dictFactory.convert(cdmDictDto);

        CdmDictDto cdmDictDto1 = new CdmDictDto();
        cdmDictDto1.setCategoryId("BASE");
        cdmDictDto1.setDictCode("1");
        list.add(cdmDictDto1);

        dictFactory.convert(cdmDictDto1);

        CdmDictDto cdmDictDto2 = new CdmDictDto();
        cdmDictDto2.setCategoryId("SYSTEM");
        cdmDictDto2.setDictCode("1");
        list.add(cdmDictDto2);

        dictFactory.convert(cdmDictDto2);

//        dictFactory.convert(list);

        System.out.println();
    }

}
