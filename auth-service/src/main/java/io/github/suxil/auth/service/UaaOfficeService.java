package io.github.suxil.auth.service;

import io.github.suxil.auth.domain.UaaOffice;
import io.github.suxil.auth.dto.UaaOfficeDto;
import io.github.suxil.auth.vo.UaaOfficeTreeVo;
import io.github.suxil.mybatis.service.BaseService;

import java.util.List;

/**
 * <p>
 * 组织信息 服务类
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
public interface UaaOfficeService extends BaseService<UaaOffice> {

    /**
     * 保存 组织信息
     */
    UaaOfficeDto save(UaaOfficeDto uaaOfficeDto);

    /**
     * 更新 组织信息
     */
    UaaOfficeDto update(UaaOfficeDto uaaOfficeDto);

    /***
     * Description: 通过组织代码查询组织树
     * date: 2020/1/1 11:33
     *
     * @author suxi
     * @version V1.0
     * @return java.util.List<io.github.suxil.auth.vo.UaaOfficeTreeDto>
     */
    List<UaaOfficeTreeVo> selectOfficeTree();

}
