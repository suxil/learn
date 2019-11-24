package com.learn.auth.web.api;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaOperatePermission;
import com.learn.auth.service.UaaOperatePermissionService;
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
 * 操作-权限息 前端控制器 测试用例
 * </p>
 *
 * @author generate
 * @since 2019-11-24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ActiveProfiles({"dev"})
public class UaaOperatePermissionControllerTest {

    @Autowired
    private UaaOperatePermissionService uaaOperatePermissionService;

    @Test
    public void list() {
        Page<UaaOperatePermission> page = new Page<>();
        page.setPages(0);
        page.setSize(1);

        QueryWrapper<UaaOperatePermission> queryWrapper = new QueryWrapper<>();

        IPage<UaaOperatePermission> pageResult = uaaOperatePermissionService.page(page, queryWrapper);

        Assert.assertNotNull(pageResult);
    }

    @Test
    @Rollback
    public void load() {
        String id = "";
        UaaOperatePermission uaaOperatePermission = uaaOperatePermissionService.getById(id);

        Assert.assertNotNull(uaaOperatePermission);
    }

    @Test
    @Rollback
    public void create() {
        UaaOperatePermission uaaOperatePermission = new UaaOperatePermission();
        uaaOperatePermissionService.saveOrUpdate(uaaOperatePermission);

    }

    @Test
    @Rollback
    public void update() {
        UaaOperatePermission uaaOperatePermission = new UaaOperatePermission();
        uaaOperatePermissionService.saveOrUpdate(uaaOperatePermission);

    }

    @Test
    @Rollback
    public void delete() {
        String id = "";
        uaaOperatePermissionService.removeById(id);

    }

}
