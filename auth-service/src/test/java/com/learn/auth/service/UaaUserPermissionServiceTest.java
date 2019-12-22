package com.learn.auth.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaUserPermission;
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
 * 用户-权限信息 服务类 测试用例
 * </p>
 *
 * @author generate
 * @since 2019-12-15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ActiveProfiles({"dev"})
public class UaaUserPermissionServiceTest {

    @Autowired
    private UaaUserPermissionService uaaUserPermissionService;

    @Test
    public void list() {
        Page<UaaUserPermission> page = new Page<>();
        page.setPages(0);
        page.setSize(1);

        QueryWrapper<UaaUserPermission> queryWrapper = new QueryWrapper<>();

        IPage<UaaUserPermission> pageResult = uaaUserPermissionService.page(page, queryWrapper);

        Assert.assertNotNull(pageResult);
    }

    @Test
    @Rollback
    public void load() {
        String id = "";
        UaaUserPermission uaaUserPermission = uaaUserPermissionService.getById(id);

        Assert.assertNotNull(uaaUserPermission);
    }

    @Test
    @Rollback
    public void create() {
        UaaUserPermission uaaUserPermission = new UaaUserPermission();
        uaaUserPermissionService.saveOrUpdate(uaaUserPermission);

    }

    @Test
    @Rollback
    public void update() {
        UaaUserPermission uaaUserPermission = new UaaUserPermission();
        uaaUserPermissionService.saveOrUpdate(uaaUserPermission);

    }

    @Test
    @Rollback
    public void delete() {
        String id = "";
        uaaUserPermissionService.removeById(id);

    }

}
