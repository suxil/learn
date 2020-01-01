package com.learn.auth.web.api;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaGroupPermission;
import com.learn.auth.service.UaaGroupPermissionService;
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
 * 组-权限信息 前端控制器 测试用例
 * </p>
 *
 * @author generate
 * @since 2020-01-01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ActiveProfiles({"dev"})
public class UaaGroupPermissionControllerTest {

    @Autowired
    private UaaGroupPermissionService uaaGroupPermissionService;

    @Test
    @Rollback
    public void listTest() {
        Page<UaaGroupPermission> page = new Page<>();
        page.setPages(0);
        page.setSize(10);

        QueryWrapper<UaaGroupPermission> queryWrapper = new QueryWrapper<>();

        IPage<UaaGroupPermission> pageResult = uaaGroupPermissionService.page(page, queryWrapper);

        Assert.assertNotNull(pageResult);
    }

    @Test
    @Rollback
    public void loadTest() {
        String id = "";
        UaaGroupPermission uaaGroupPermission = uaaGroupPermissionService.getById(id);

        Assert.assertNotNull(uaaGroupPermission);
    }

    @Test
    @Rollback
    public void createTest() {
        UaaGroupPermission uaaGroupPermission = new UaaGroupPermission();
        uaaGroupPermissionService.saveOrUpdate(uaaGroupPermission);

    }

    @Test
    @Rollback
    public void updateTest() {
        UaaGroupPermission uaaGroupPermission = new UaaGroupPermission();
        uaaGroupPermissionService.saveOrUpdate(uaaGroupPermission);

    }

    @Test
    @Rollback
    public void deleteTest() {
        String id = "";
        uaaGroupPermissionService.removeById(id);

    }

}
