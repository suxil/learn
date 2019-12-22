package com.learn.auth.web.api;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaMenuElementRole;
import com.learn.auth.service.UaaMenuElementRoleService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 页面元素-角色息 前端控制器 测试用例
 * </p>
 *
 * @author generate
 * @since 2019-12-22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ActiveProfiles({"dev"})
public class UaaMenuElementRoleControllerTest {

    @Autowired
    private UaaMenuElementRoleService uaaMenuElementRoleService;

    @Test
    public void list() {
        Page<UaaMenuElementRole> page = new Page<>();
        page.setPages(0);
        page.setSize(10);

        QueryWrapper<UaaMenuElementRole> queryWrapper = new QueryWrapper<>();

        IPage<UaaMenuElementRole> pageResult = uaaMenuElementRoleService.page(page, queryWrapper);

        Assert.assertNotNull(pageResult);
    }

    @Test
    @Rollback
    public void load() {
        String id = "";
        UaaMenuElementRole uaaMenuElementRole = uaaMenuElementRoleService.getById(id);

        Assert.assertNotNull(uaaMenuElementRole);
    }

    @Test
    @Rollback
    public void create() {
        UaaMenuElementRole uaaMenuElementRole = new UaaMenuElementRole();
        uaaMenuElementRoleService.saveOrUpdate(uaaMenuElementRole);

    }

    @Test
    @Rollback
    public void update() {
        UaaMenuElementRole uaaMenuElementRole = new UaaMenuElementRole();
        uaaMenuElementRoleService.saveOrUpdate(uaaMenuElementRole);

    }

    @Test
    @Rollback
    public void delete() {
        String id = "";
        uaaMenuElementRoleService.removeById(id);

    }

}
