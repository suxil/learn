package io.github.suxil.service.service.dict;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.github.suxil.dict.api.DictService;
import io.github.suxil.dict.api.constant.DictConstant;
import io.github.suxil.dict.api.data.DictData;
import io.github.suxil.dict.core.data.DictDataImpl;
import io.github.suxil.service.domain.cdm.CdmDict;
import io.github.suxil.service.service.cdm.CdmDictService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictBaseService implements DictService<CdmDict> {

    @Autowired
    private CdmDictService cdmDictService;

    @Override
    public List<DictData> searchList(String category, List<String> codeList) {
        QueryWrapper<CdmDict> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq(StringUtils.isNotEmpty(category), "category_code", category);
        queryWrapper.orderByAsc("seq");
        List<CdmDict> bdsDictList = cdmDictService.list(queryWrapper);

        return convert(bdsDictList);
    }

    @Override
    public DictData convert(CdmDict cdmDict) {
        DictDataImpl dictData = new DictDataImpl();
        dictData.setKey(DictConstant.DICT_KEY);
        dictData.setCategory(cdmDict.getCategoryId());
        dictData.setSeq(cdmDict.getSeq());
        dictData.setCode(cdmDict.getDictCode());
        dictData.setName(cdmDict.getDictName());
        dictData.setRemark(cdmDict.getRemark());
        return dictData;
    }

}
