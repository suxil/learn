package io.github.suxil.service.service.cdm;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.suxil.core.common.PageResult;
import io.github.suxil.mybatis.service.BaseService;
import io.github.suxil.service.domain.cdm.CdmDictCategory;
import io.github.suxil.service.dto.cdm.CdmDictCategoryDto;

import java.util.List;

/**
 * <p>
 * 数据字典类型 服务类
 * </p>
 *
 * @author generate
 * @since 2021-04-10
 */
public interface CdmDictCategoryService extends BaseService<CdmDictCategory> {

    /**
     * 分页查询 数据字典类型
     */
    PageResult<CdmDictCategoryDto> page(CdmDictCategoryDto cdmDictCategoryDto);

    /**
     * 查询 数据字典类型树
     */
    List<CdmDictCategoryDto> getTreeList();

    /**
     * 加载 数据字典类型
     */
    CdmDictCategoryDto getCdmDictCategoryById(String id);

    /**
     * 保存 数据字典类型
     */
    CdmDictCategoryDto save(CdmDictCategoryDto cdmDictCategoryDto);

    /**
     * 更新 数据字典类型
     */
    CdmDictCategoryDto update(CdmDictCategoryDto cdmDictCategoryDto);

}
