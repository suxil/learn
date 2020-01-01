package com.learn.auth.web.api;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaUserPermission;
import com.learn.auth.service.UaaUserPermissionService;
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
 * 用户-权限信息 前端控制器 测试用例
 * </p>
 *
 * @author generate
 * @since 2020-01-01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ActiveProfiles({"dev"})
public class UaaUserPermissionControllerTest {

    @Autowired
    private UaaUserPermissionService uaaUserPermissionService;

    @Test
    @Rollback
    public void listTest() {
        Page<UaaUserPermission> page = new Page<>();
        page.setPages(0);
        page.setSize(10);

        QueryWrapper<UaaUserPermission> queryWrapper = new QueryWrapper<>();

        IPage<UaaUserPermission> pageResult = uaaUserPermissionService.page(page, queryWrapper);

        Assert.assertNotNull(pageResult);
    }

    @Test
    @Rollback
    public void loadTest() {
        String id = "";
        UaaUserPermission uaaUserPermission = uaaUserPermissionService.getById(id);

        Assert.assertNotNull(uaaUserPermission);
    }

    @Test
    @Rollback
    public void createTest() {
        UaaUserPermission uaaUserPermission = new UaaUserPermission();
        uaaUserPermissionService.saveOrUpdate(uaaUserPermission);

    }

    @Test
    @Rollback
    public void updateTest() {
        UaaUserPermission uaaUserPermission = new UaaUserPermission();
        uaaUserPermissionService.saveOrUpdate(uaaUserPermission);

    }

    @Test
    @Rollback
    public void deleteTest() {
        String id = "";
        uaaUserPermissionService.removeById(id);

    }

}
