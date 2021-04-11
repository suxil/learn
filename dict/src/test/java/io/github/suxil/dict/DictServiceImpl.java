package io.github.suxil.dict;

import io.github.suxil.dict.common.DictDataGenerate;
import io.github.suxil.dict.dto.CdmDictDto;
import io.github.suxil.dict.support.DictImpl;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;
import java.util.stream.Collectors;

public class DictServiceImpl implements DictService<CdmDictDto> {

    @Override
    public List<Dict> searchList(String category, List<String> codeList) {
        List<CdmDictDto> dictDtoList = DictDataGenerate.initListDictDtoData();

        List<CdmDictDto> list = dictDtoList.stream()
                .filter(item -> category.equals(item.getCategoryId()))
                .collect(Collectors.toList());

        return convert(list);
    }

    @Override
    public Dict convert(CdmDictDto cdmDictDto) {
        DictImpl dict = new DictImpl();

        dict.setKey("DICT");
        dict.setSeq(cdmDictDto.getSeq());
        dict.setCategory(cdmDictDto.getCategoryId());
        dict.setCode(cdmDictDto.getDictCode());
        dict.setName(cdmDictDto.getDictName());
        dict.setRemark(cdmDictDto.getRemark());

        return dict;
    }

}
