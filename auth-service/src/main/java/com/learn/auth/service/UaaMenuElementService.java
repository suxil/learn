package com.learn.auth.service;

import com.learn.auth.domain.UaaMenuElement;
import com.learn.auth.dto.UaaMenuElementDto;
import com.learn.mybatis.service.BaseService;

/**
 * <p>
 * 菜单页面元素信息 服务类
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
public interface UaaMenuElementService extends BaseService<UaaMenuElement> {

    /**
     * 保存 菜单页面元素信息
     */
    UaaMenuElementDto save(UaaMenuElementDto uaaMenuElementDto);

    /**
     * 更新 菜单页面元素信息
     */
    UaaMenuElementDto update(UaaMenuElementDto uaaMenuElementDto);

}
