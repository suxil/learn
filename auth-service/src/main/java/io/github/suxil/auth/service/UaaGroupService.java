package io.github.suxil.auth.service;

import io.github.suxil.auth.domain.UaaGroup;
import io.github.suxil.auth.dto.UaaGroupDto;
import io.github.suxil.auth.vo.UaaGroupTreeVo;
import io.github.suxil.mybatis.service.BaseService;

import java.util.List;

/**
 * <p>
 * 组信息 服务类
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
public interface UaaGroupService extends BaseService<UaaGroup> {

    /**
     * 保存 组信息
     */
    UaaGroupDto save(UaaGroupDto uaaGroupDto);

    /**
     * 更新 组信息
     */
    UaaGroupDto update(UaaGroupDto uaaGroupDto);

    /**
     * Description: 通过组织代码查询组树
     * date: 2020/1/1 19:57
     *
     * @author suxi
     * @version V1.0
     * @param officeCode
     * @return java.util.List<io.github.suxil.auth.vo.UaaGroupTreeDto>
     */
    List<UaaGroupTreeVo> selectGroupTree(String officeCode);

}
