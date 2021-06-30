package io.github.suxil.service.service.dict;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.github.suxil.dict.api.DictService;
import io.github.suxil.dict.api.constant.DictConstant;
import io.github.suxil.dict.api.data.DictData;
import io.github.suxil.dict.core.data.DictDataImpl;
import io.github.suxil.service.domain.cdm.CdmDictCategory;
import io.github.suxil.service.service.cdm.CdmDictCategoryService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictCategoryService implements DictService<CdmDictCategory> {

    @Autowired
    private CdmDictCategoryService cdmDictCategoryService;

    @Override
    public List<DictData> searchList(String category, List<String> codeList) {
        QueryWrapper<CdmDictCategory> queryWrapper = new QueryWrapper<>();

        queryWrapper.in(CollectionUtils.isNotEmpty(codeList), "id", codeList);

        List<CdmDictCategory> bdsDictList = cdmDictCategoryService.list(queryWrapper);

        return convert(bdsDictList);
    }

    @Override
    public DictData convert(CdmDictCategory cdmDictCategory) {
        DictDataImpl dictData = new DictDataImpl();
        dictData.setKey(DictConstant.DICT_OTHER_KEY);
        dictData.setCategory(DictConstant.DICT_OTHER_KEY);
        dictData.setSeq(cdmDictCategory.getSeq());
        dictData.setCode(cdmDictCategory.getCategoryCode());
        dictData.setName(cdmDictCategory.getCategoryName());
        dictData.setRemark(cdmDictCategory.getRemark());
        return dictData;
    }

}
