package com.learn.auth.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaRolePermission;
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
 * 角色-权限信息 服务类 测试用例
 * </p>
 *
 * @author generate
 * @since 2019-12-22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ActiveProfiles({"dev"})
public class UaaRolePermissionServiceTest {

    @Autowired
    private UaaRolePermissionService uaaRolePermissionService;

    @Test
    public void list() {
        Page<UaaRolePermission> page = new Page<>();
        page.setPages(0);
        page.setSize(10);

        QueryWrapper<UaaRolePermission> queryWrapper = new QueryWrapper<>();

        IPage<UaaRolePermission> pageResult = uaaRolePermissionService.page(page, queryWrapper);

        Assert.assertNotNull(pageResult);
    }

    @Test
    @Rollback
    public void load() {
        String id = "";
        UaaRolePermission uaaRolePermission = uaaRolePermissionService.getById(id);

        Assert.assertNotNull(uaaRolePermission);
    }

    @Test
    @Rollback
    public void create() {
        UaaRolePermission uaaRolePermission = new UaaRolePermission();
        uaaRolePermissionService.saveOrUpdate(uaaRolePermission);

    }

    @Test
    @Rollback
    public void update() {
        UaaRolePermission uaaRolePermission = new UaaRolePermission();
        uaaRolePermissionService.saveOrUpdate(uaaRolePermission);

    }

    @Test
    @Rollback
    public void delete() {
        String id = "";
        uaaRolePermissionService.removeById(id);

    }

}
