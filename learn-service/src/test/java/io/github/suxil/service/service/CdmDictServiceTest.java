package io.github.suxil.service.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.suxil.core.common.PageResult;
import io.github.suxil.dict.core.util.DictServerUtil;
import io.github.suxil.service.domain.cdm.CdmDict;
import io.github.suxil.service.dto.cdm.CdmDictDto;
import io.github.suxil.service.service.cdm.CdmDictService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 数据字典 服务类 测试用例
 * </p>
 *
 * @author generate
 * @since 2021-04-11
 */
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
@ActiveProfiles({"dev"})
public class CdmDictServiceTest {

    @Autowired
    private CdmDictService cdmDictService;

    @Test
    @Rollback
    public void listTest() {
        CdmDictDto cdmDictDto = new CdmDictDto();
        cdmDictDto.setPage(0L);
        cdmDictDto.setSize(10L);

        PageResult<CdmDictDto> pageResult = cdmDictService.page(cdmDictDto);

        DictServerUtil.convert(pageResult.getList());

        Assertions.assertNotNull(pageResult);
    }

    @Test
    @Rollback
    public void loadTest() {
        String id = "";
        CdmDict cdmDict = cdmDictService.getById(id);

        Assertions.assertNotNull(cdmDict);
    }

    @Test
    @Rollback
    public void createTest() {
        CdmDict cdmDict = new CdmDict();
        cdmDictService.saveOrUpdate(cdmDict);

    }

    @Test
    @Rollback
    public void updateTest() {
        CdmDict cdmDict = new CdmDict();
        cdmDictService.saveOrUpdate(cdmDict);

    }

    @Test
    @Rollback
    public void deleteTest() {
        String id = "";
        cdmDictService.removeById(id);

    }

}
