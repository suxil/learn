package io.github.suxil.service.service.cdm.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.github.suxil.core.common.PageResult;
import io.github.suxil.core.util.PageUtils;
import io.github.suxil.service.converter.cdm.CdmDictConverter;
import io.github.suxil.service.domain.cdm.CdmDict;
import io.github.suxil.service.dto.cdm.CdmDictDto;
import io.github.suxil.service.mapper.cdm.CdmDictMapper;
import io.github.suxil.service.service.cdm.CdmDictService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 数据字典 服务实现类
 * </p>
 *
 * @author generate
 * @since 2021-04-10
 */
@Service
@Slf4j
public class CdmDictServiceImpl extends ServiceImpl<CdmDictMapper, CdmDict> implements CdmDictService {

    @Override
    public PageResult<CdmDictDto> page(CdmDictDto cdmDictDto) {
        QueryWrapper<CdmDict> queryWrapper = new QueryWrapper<>();

        PageInfo<CdmDict> pageInfo = PageHelper.startPage(cdmDictDto.getPage().intValue(), cdmDictDto.getSize().intValue())
            .doSelectPageInfo(() -> list(queryWrapper));

        PageResult<CdmDictDto> pageResult = PageUtils.pageInfoToPageResult(pageInfo);
        pageResult.setList(CdmDictConverter.INSTANCE.convertDto(pageInfo.getList()));

        return pageResult;
    }

    @Override
    public CdmDictDto getCdmDictById(String id) {
        CdmDict cdmDict = getById(id);

        return CdmDictConverter.INSTANCE.convertDto(cdmDict);
    }

    @Override
    public CdmDictDto save(CdmDictDto cdmDictDto) {
        CdmDict cdmDict = CdmDictConverter.INSTANCE.convert(cdmDictDto);

        save(cdmDict);

        return CdmDictConverter.INSTANCE.convertDto(cdmDict);
    }

    @Override
    public CdmDictDto update(CdmDictDto cdmDictDto) {
        CdmDict cdmDict = CdmDictConverter.INSTANCE.convert(cdmDictDto);

        updateById(cdmDict);

        return CdmDictConverter.INSTANCE.convertDto(cdmDict);
    }

}
