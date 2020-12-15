package io.github.suxil.auth.service;

import io.github.suxil.auth.domain.UaaUserPosition;
import io.github.suxil.auth.dto.UaaUserPositionDto;
import io.github.suxil.mybatis.service.BaseService;

/**
 * <p>
 * 用户-岗位信息 服务类
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
public interface UaaUserPositionService extends BaseService<UaaUserPosition> {

    /**
     * 保存 用户-岗位信息
     */
    UaaUserPositionDto save(UaaUserPositionDto uaaUserPositionDto);

    /**
     * 更新 用户-岗位信息
     */
    UaaUserPositionDto update(UaaUserPositionDto uaaUserPositionDto);

}
