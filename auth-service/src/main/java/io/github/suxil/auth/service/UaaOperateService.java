package io.github.suxil.auth.service;

import io.github.suxil.auth.domain.UaaOperate;
import io.github.suxil.auth.dto.UaaOperateDto;
import io.github.suxil.mybatis.service.BaseService;

/**
 * <p>
 * 操作信息 服务类
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
public interface UaaOperateService extends BaseService<UaaOperate> {

    /**
     * 保存 操作信息
     */
    UaaOperateDto save(UaaOperateDto uaaOperateDto);

    /**
     * 更新 操作信息
     */
    UaaOperateDto update(UaaOperateDto uaaOperateDto);

}
