package com.learn.auth.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaPageElementRole;
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
 * 页面元素-角色息 服务类 测试用例
 * </p>
 *
 * @author generate
 * @since 2019-12-15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ActiveProfiles({"dev"})
public class UaaPageElementRoleServiceTest {

    @Autowired
    private UaaPageElementRoleService uaaPageElementRoleService;

    @Test
    public void list() {
        Page<UaaPageElementRole> page = new Page<>();
        page.setPages(0);
        page.setSize(1);

        QueryWrapper<UaaPageElementRole> queryWrapper = new QueryWrapper<>();

        IPage<UaaPageElementRole> pageResult = uaaPageElementRoleService.page(page, queryWrapper);

        Assert.assertNotNull(pageResult);
    }

    @Test
    @Rollback
    public void load() {
        String id = "";
        UaaPageElementRole uaaPageElementRole = uaaPageElementRoleService.getById(id);

        Assert.assertNotNull(uaaPageElementRole);
    }

    @Test
    @Rollback
    public void create() {
        UaaPageElementRole uaaPageElementRole = new UaaPageElementRole();
        uaaPageElementRoleService.saveOrUpdate(uaaPageElementRole);

    }

    @Test
    @Rollback
    public void update() {
        UaaPageElementRole uaaPageElementRole = new UaaPageElementRole();
        uaaPageElementRoleService.saveOrUpdate(uaaPageElementRole);

    }

    @Test
    @Rollback
    public void delete() {
        String id = "";
        uaaPageElementRoleService.removeById(id);

    }

}
