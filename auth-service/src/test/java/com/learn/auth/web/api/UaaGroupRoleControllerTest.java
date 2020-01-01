package com.learn.auth.web.api;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaGroupRole;
import com.learn.auth.service.UaaGroupRoleService;
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
 * 组-角色信息 前端控制器 测试用例
 * </p>
 *
 * @author generate
 * @since 2020-01-01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ActiveProfiles({"dev"})
public class UaaGroupRoleControllerTest {

    @Autowired
    private UaaGroupRoleService uaaGroupRoleService;

    @Test
    @Rollback
    public void listTest() {
        Page<UaaGroupRole> page = new Page<>();
        page.setPages(0);
        page.setSize(10);

        QueryWrapper<UaaGroupRole> queryWrapper = new QueryWrapper<>();

        IPage<UaaGroupRole> pageResult = uaaGroupRoleService.page(page, queryWrapper);

        Assert.assertNotNull(pageResult);
    }

    @Test
    @Rollback
    public void loadTest() {
        String id = "";
        UaaGroupRole uaaGroupRole = uaaGroupRoleService.getById(id);

        Assert.assertNotNull(uaaGroupRole);
    }

    @Test
    @Rollback
    public void createTest() {
        UaaGroupRole uaaGroupRole = new UaaGroupRole();
        uaaGroupRoleService.saveOrUpdate(uaaGroupRole);

    }

    @Test
    @Rollback
    public void updateTest() {
        UaaGroupRole uaaGroupRole = new UaaGroupRole();
        uaaGroupRoleService.saveOrUpdate(uaaGroupRole);

    }

    @Test
    @Rollback
    public void deleteTest() {
        String id = "";
        uaaGroupRoleService.removeById(id);

    }

}
