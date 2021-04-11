package io.github.suxil.dict.util;

import io.github.suxil.dict.annotation.DictFieldData;
import io.github.suxil.dict.dto.CdmDictDto;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class DictFieldCacheUtilTest {

    @Test
    public void getDictFieldDataListTest() {
        CdmDictDto cdmDictDto = new CdmDictDto();

        List<DictFieldData> dictFieldDataList = DictFieldCacheUtil.getDictFieldDataList(cdmDictDto.getClass());

        Assert.assertNotNull(dictFieldDataList);
    }

}
