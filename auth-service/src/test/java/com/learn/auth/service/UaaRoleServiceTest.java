package com.learn.auth.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaRole;
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
 * 角色信息 服务类 测试用例
 * </p>
 *
 * @author generate
 * @since 2019-12-22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ActiveProfiles({"dev"})
public class UaaRoleServiceTest {

    @Autowired
    private UaaRoleService uaaRoleService;

    @Test
    public void list() {
        Page<UaaRole> page = new Page<>();
        page.setPages(0);
        page.setSize(10);

        QueryWrapper<UaaRole> queryWrapper = new QueryWrapper<>();

        IPage<UaaRole> pageResult = uaaRoleService.page(page, queryWrapper);

        Assert.assertNotNull(pageResult);
    }

    @Test
    @Rollback
    public void load() {
        String id = "";
        UaaRole uaaRole = uaaRoleService.getById(id);

        Assert.assertNotNull(uaaRole);
    }

    @Test
    @Rollback
    public void create() {
        UaaRole uaaRole = new UaaRole();
        uaaRoleService.saveOrUpdate(uaaRole);

    }

    @Test
    @Rollback
    public void update() {
        UaaRole uaaRole = new UaaRole();
        uaaRoleService.saveOrUpdate(uaaRole);

    }

    @Test
    @Rollback
    public void delete() {
        String id = "";
        uaaRoleService.removeById(id);

    }

}
