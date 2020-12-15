package io.github.suxil.auth.service;

import io.github.suxil.auth.domain.UaaPosition;
import io.github.suxil.auth.dto.UaaPositionDto;
import io.github.suxil.auth.vo.UaaPositionTreeVo;
import io.github.suxil.mybatis.service.BaseService;

import java.util.List;

/**
 * <p>
 * 岗位信息 服务类
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
public interface UaaPositionService extends BaseService<UaaPosition> {

    /**
     * 保存 岗位信息
     */
    UaaPositionDto save(UaaPositionDto uaaPositionDto);

    /**
     * 更新 岗位信息
     */
    UaaPositionDto update(UaaPositionDto uaaPositionDto);

    /**
     * Description: 通过组织代码查询岗位树
     * date: 2020/1/1 19:59
     *
     * @author suxi
     * @version V1.0
     * @param officeCode
     * @return java.util.List<io.github.suxil.auth.vo.UaaPositionTreeDto>
     */
    List<UaaPositionTreeVo> selectPositionTree(String officeCode);

}
