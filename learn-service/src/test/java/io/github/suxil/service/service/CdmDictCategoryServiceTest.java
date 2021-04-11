package io.github.suxil.service.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.suxil.core.common.PageResult;
import io.github.suxil.service.domain.cdm.CdmDictCategory;
import io.github.suxil.service.dto.cdm.CdmDictCategoryDto;
import io.github.suxil.service.service.cdm.CdmDictCategoryService;
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
 * 数据字典类型 服务类 测试用例
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
public class CdmDictCategoryServiceTest {

    @Autowired
    private CdmDictCategoryService cdmDictCategoryService;

    @Test
    @Rollback
    public void listTest() {
        CdmDictCategoryDto cdmDictCategoryDto = new CdmDictCategoryDto();
        cdmDictCategoryDto.setPage(0L);
        cdmDictCategoryDto.setSize(10L);

        PageResult<CdmDictCategoryDto> pageResult = cdmDictCategoryService.page(cdmDictCategoryDto);

        Assertions.assertNotNull(pageResult);
    }

    @Test
    @Rollback
    public void loadTest() {
        String id = "";
        CdmDictCategory cdmDictCategory = cdmDictCategoryService.getById(id);

        Assertions.assertNotNull(cdmDictCategory);
    }

    @Test
    @Rollback
    public void createTest() {
        CdmDictCategoryDto cdmDictCategoryDto = new CdmDictCategoryDto();
        cdmDictCategoryDto.setCategoryCode("POSITION");
        cdmDictCategoryService.save(cdmDictCategoryDto);

    }

    @Test
    @Rollback
    public void updateTest() {
        CdmDictCategoryDto cdmDictCategoryDto = new CdmDictCategoryDto();
        cdmDictCategoryService.update(cdmDictCategoryDto);

    }

    @Test
    @Rollback
    public void deleteTest() {
        String id = "";
        cdmDictCategoryService.removeById(id);

    }

}
