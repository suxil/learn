package io.github.suxil.service.service.cdm;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.suxil.core.common.PageResult;
import io.github.suxil.mybatis.service.BaseService;
import io.github.suxil.service.domain.cdm.CdmDict;
import io.github.suxil.service.dto.cdm.CdmDictDto;

/**
 * <p>
 * 数据字典 服务类
 * </p>
 *
 * @author generate
 * @since 2021-04-10
 */
public interface CdmDictService extends BaseService<CdmDict> {

    /**
     * 分页查询 数据字典
     */
    PageResult<CdmDictDto> page(CdmDictDto cdmDictDto);

    /**
     * 加载 数据字典
     */
    CdmDictDto getCdmDictById(String id);

    /**
     * 保存 数据字典
     */
    CdmDictDto save(CdmDictDto cdmDictDto);

    /**
     * 更新 数据字典
     */
    CdmDictDto update(CdmDictDto cdmDictDto);

}
