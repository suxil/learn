package com.learn.auth.web.api;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaMenuRole;
import com.learn.auth.service.UaaMenuRoleService;
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
 * 菜单-角色信息 前端控制器 测试用例
 * </p>
 *
 * @author generate
 * @since 2019-11-24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ActiveProfiles({"dev"})
public class UaaMenuRoleControllerTest {

    @Autowired
    private UaaMenuRoleService uaaMenuRoleService;

    @Test
    public void list() {
        Page<UaaMenuRole> page = new Page<>();
        page.setPages(0);
        page.setSize(1);

        QueryWrapper<UaaMenuRole> queryWrapper = new QueryWrapper<>();

        IPage<UaaMenuRole> pageResult = uaaMenuRoleService.page(page, queryWrapper);

        Assert.assertNotNull(pageResult);
    }

    @Test
    @Rollback
    public void load() {
        String id = "";
        UaaMenuRole uaaMenuRole = uaaMenuRoleService.getById(id);

        Assert.assertNotNull(uaaMenuRole);
    }

    @Test
    @Rollback
    public void create() {
        UaaMenuRole uaaMenuRole = new UaaMenuRole();
        uaaMenuRoleService.saveOrUpdate(uaaMenuRole);

    }

    @Test
    @Rollback
    public void update() {
        UaaMenuRole uaaMenuRole = new UaaMenuRole();
        uaaMenuRoleService.saveOrUpdate(uaaMenuRole);

    }

    @Test
    @Rollback
    public void delete() {
        String id = "";
        uaaMenuRoleService.removeById(id);

    }

}