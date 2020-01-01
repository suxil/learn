package com.learn.auth.web.api;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaRole;
import com.learn.auth.service.UaaRoleService;
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
 * 角色信息 前端控制器 测试用例
 * </p>
 *
 * @author generate
 * @since 2020-01-01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ActiveProfiles({"dev"})
public class UaaRoleControllerTest {

    @Autowired
    private UaaRoleService uaaRoleService;

    @Test
    @Rollback
    public void listTest() {
        Page<UaaRole> page = new Page<>();
        page.setPages(0);
        page.setSize(10);

        QueryWrapper<UaaRole> queryWrapper = new QueryWrapper<>();

        IPage<UaaRole> pageResult = uaaRoleService.page(page, queryWrapper);

        Assert.assertNotNull(pageResult);
    }

    @Test
    @Rollback
    public void loadTest() {
        String id = "";
        UaaRole uaaRole = uaaRoleService.getById(id);

        Assert.assertNotNull(uaaRole);
    }

    @Test
    @Rollback
    public void createTest() {
        UaaRole uaaRole = new UaaRole();
        uaaRoleService.saveOrUpdate(uaaRole);

    }

    @Test
    @Rollback
    public void updateTest() {
        UaaRole uaaRole = new UaaRole();
        uaaRoleService.saveOrUpdate(uaaRole);

    }

    @Test
    @Rollback
    public void deleteTest() {
        String id = "";
        uaaRoleService.removeById(id);

    }

}
