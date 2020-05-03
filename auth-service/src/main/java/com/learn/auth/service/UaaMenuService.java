package com.learn.auth.service;

import com.learn.auth.domain.UaaMenu;
import com.learn.auth.dto.UaaMenuDto;
import com.learn.auth.vo.UaaMenuTreeVo;
import com.learn.mybatis.service.BaseService;

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
     * @return java.util.List<com.learn.auth.vo.UaaMenuTreeDto>
     */
    List<UaaMenuTreeVo> selectMenuTree(String officeCode);

}
