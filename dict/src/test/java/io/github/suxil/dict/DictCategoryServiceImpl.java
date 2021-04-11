package io.github.suxil.dict;

import io.github.suxil.dict.common.DictDataGenerate;
import io.github.suxil.dict.dto.CdmDictCategoryDto;
import io.github.suxil.dict.dto.CdmDictDto;
import io.github.suxil.dict.support.DictImpl;

import java.util.List;
import java.util.stream.Collectors;

public class DictCategoryServiceImpl implements DictService<CdmDictCategoryDto> {

    @Override
    public List<Dict> searchList(String category, List<String> codeList) {
        List<CdmDictCategoryDto> dictDtoList = DictDataGenerate.initListDictCategoryDtoData();

        List<CdmDictCategoryDto> list = dictDtoList.stream()
                .filter(item -> codeList.contains(item.getCategoryCode()))
                .collect(Collectors.toList());

        return convert(list);
    }

    @Override
    public Dict convert(CdmDictCategoryDto cdmDictDto) {
        DictImpl dict = new DictImpl();

        dict.setKey("DICT");
        dict.setSeq(cdmDictDto.getSeq());
        dict.setCategory("DICT_CATEGORY_ID");
        dict.setCode(cdmDictDto.getCategoryCode());
        dict.setName(cdmDictDto.getCategoryName());
        dict.setRemark(cdmDictDto.getRemark());

        return dict;
    }

}
