package io.github.suxil.auth.service;

import io.github.suxil.auth.domain.UaaMenu;
import io.github.suxil.auth.dto.UaaMenuDto;
import io.github.suxil.auth.vo.UaaMenuTreeVo;
import io.github.suxil.mybatis.service.BaseService;

import java.util.List;

/**
 * <p>
 * 菜单信息 服务类
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
public interface UaaMenuService extends BaseService<UaaMenu> {

    /**
     * 保存 菜单信息
     */
    UaaMenuDto save(UaaMenuDto uaaMenuDto);

    /**
     * 更新 菜单信息
     */
    UaaMenuDto update(UaaMenuDto uaaMenuDto);

    /**
     * Description: 通过组织代码查询菜单树
     * date: 2020/1/1 19:58
     *
     * @author suxi
     * @version V1.0
     * @param officeCode
     * @return java.util.List<io.github.suxil.auth.vo.UaaMenuTreeDto>
     */
    List<UaaMenuTreeVo> selectMenuTree(String officeCode);

}
