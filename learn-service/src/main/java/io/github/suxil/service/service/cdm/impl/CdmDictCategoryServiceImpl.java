package io.github.suxil.service.service.cdm.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.github.suxil.core.common.PageResult;
import io.github.suxil.core.constance.BaseDomainConstants;
import io.github.suxil.core.exception.GlobalCommonException;
import io.github.suxil.core.util.PageUtils;
import io.github.suxil.core.util.TreeUtils;
import io.github.suxil.service.converter.cdm.CdmDictCategoryConverter;
import io.github.suxil.service.domain.cdm.CdmDictCategory;
import io.github.suxil.service.dto.cdm.CdmDictCategoryDto;
import io.github.suxil.service.mapper.cdm.CdmDictCategoryMapper;
import io.github.suxil.service.service.cdm.CdmDictCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 数据字典类型 服务实现类
 * </p>
 *
 * @author generate
 * @since 2021-04-10
 */
@Service
@Slf4j
public class CdmDictCategoryServiceImpl extends ServiceImpl<CdmDictCategoryMapper, CdmDictCategory> implements CdmDictCategoryService {

    @Override
    public PageResult<CdmDictCategoryDto> page(CdmDictCategoryDto cdmDictCategoryDto) {
        QueryWrapper<CdmDictCategory> queryWrapper = new QueryWrapper<>();

        PageInfo<CdmDictCategory> pageInfo = PageHelper.startPage(cdmDictCategoryDto.getPage().intValue(), cdmDictCategoryDto.getSize().intValue())
            .doSelectPageInfo(() -> list(queryWrapper));

        PageResult<CdmDictCategoryDto> pageResult = PageUtils.pageInfoToPageResult(pageInfo);
        pageResult.setList(CdmDictCategoryConverter.INSTANCE.convertDto(pageInfo.getList()));

        return pageResult;
    }

    @Override
    public List<CdmDictCategoryDto> getTreeList() {
        QueryWrapper<CdmDictCategory> queryWrapper = new QueryWrapper<>();

        List<CdmDictCategory> cdmDictCategoryList = list(queryWrapper);

        List<CdmDictCategoryDto> cdmDictCategoryDtoList = CdmDictCategoryConverter.INSTANCE.convertDto(cdmDictCategoryList);

        List<CdmDictCategoryDto> treeList = TreeUtils.convertToTree(
                cdmDictCategoryDtoList,
                CdmDictCategoryDto::getId,
                CdmDictCategoryDto::getParentId,
                CdmDictCategoryDto::setChildren
        );

        return treeList;
    }

    @Override
    public CdmDictCategoryDto getCdmDictCategoryById(String id) {
        CdmDictCategory cdmDictCategory = getById(id);

        return CdmDictCategoryConverter.INSTANCE.convertDto(cdmDictCategory);
    }

    private void validate(CdmDictCategory cdmDictCategory) {
        QueryWrapper<CdmDictCategory> queryWrapper = new QueryWrapper<>();

        queryWrapper.ne(BaseDomainConstants.ID, cdmDictCategory.getId());
        queryWrapper.eq(CdmDictCategory.CATEGORY_CODE, cdmDictCategory.getCategoryCode());

        List<CdmDictCategory> cdmDictCategoryList = list(queryWrapper);
        if (CollectionUtil.isNotEmpty(cdmDictCategoryList)) {
            throw new GlobalCommonException("类型代码重复");
        }
    }

    @Override
    public CdmDictCategoryDto save(CdmDictCategoryDto cdmDictCategoryDto) {
        CdmDictCategory cdmDictCategory = CdmDictCategoryConverter.INSTANCE.convert(cdmDictCategoryDto);

        validate(cdmDictCategory);

        save(cdmDictCategory);

        return CdmDictCategoryConverter.INSTANCE.convertDto(cdmDictCategory);
    }

    @Override
    public CdmDictCategoryDto update(CdmDictCategoryDto cdmDictCategoryDto) {
        CdmDictCategory cdmDictCategory = CdmDictCategoryConverter.INSTANCE.convert(cdmDictCategoryDto);

        validate(cdmDictCategory);

        updateById(cdmDictCategory);

        return CdmDictCategoryConverter.INSTANCE.convertDto(cdmDictCategory);
    }

}
