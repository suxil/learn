package com.learn.auth.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaOperatePermission;
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
 * 操作-权限息 服务类 测试用例
 * </p>
 *
 * @author generate
 * @since 2020-01-01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ActiveProfiles({"dev"})
public class UaaOperatePermissionServiceTest {

    @Autowired
    private UaaOperatePermissionService uaaOperatePermissionService;

    @Test
    @Rollback
    public void listTest() {
        Page<UaaOperatePermission> page = new Page<>();
        page.setPages(0);
        page.setSize(10);

        QueryWrapper<UaaOperatePermission> queryWrapper = new QueryWrapper<>();

        IPage<UaaOperatePermission> pageResult = uaaOperatePermissionService.page(page, queryWrapper);

        Assert.assertNotNull(pageResult);
    }

    @Test
    @Rollback
    public void loadTest() {
        String id = "";
        UaaOperatePermission uaaOperatePermission = uaaOperatePermissionService.getById(id);

        Assert.assertNotNull(uaaOperatePermission);
    }

    @Test
    @Rollback
    public void createTest() {
        UaaOperatePermission uaaOperatePermission = new UaaOperatePermission();
        uaaOperatePermissionService.saveOrUpdate(uaaOperatePermission);

    }

    @Test
    @Rollback
    public void updateTest() {
        UaaOperatePermission uaaOperatePermission = new UaaOperatePermission();
        uaaOperatePermissionService.saveOrUpdate(uaaOperatePermission);

    }

    @Test
    @Rollback
    public void deleteTest() {
        String id = "";
        uaaOperatePermissionService.removeById(id);

    }

}
