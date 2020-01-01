package com.learn.auth.service;

import com.learn.auth.domain.UaaMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.auth.dto.UaaMenuTreeDto;

import java.util.List;

/**
 * <p>
 * 菜单信息 服务类
 * </p>
 *
 * @author generate
 * @since 2019-12-22
 */
public interface UaaMenuService extends IService<UaaMenu> {

    /**
     * Description: 通过组织代码查询菜单树
     * date: 2020/1/1 19:58
     *
     * @author suxi
     * @version V1.0
     * @param officeCode
     * @return java.util.List<com.learn.auth.dto.UaaMenuTreeDto>
     */
    List<UaaMenuTreeDto> selectMenuTree(String officeCode);

}
