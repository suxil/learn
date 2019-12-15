package com.learn.auth.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaMenu;
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
 * 菜单信息 服务类 测试用例
 * </p>
 *
 * @author generate
 * @since 2019-12-15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ActiveProfiles({"dev"})
public class UaaMenuServiceTest {

    @Autowired
    private UaaMenuService uaaMenuService;

    @Test
    public void list() {
        Page<UaaMenu> page = new Page<>();
        page.setPages(0);
        page.setSize(1);

        QueryWrapper<UaaMenu> queryWrapper = new QueryWrapper<>();

        IPage<UaaMenu> pageResult = uaaMenuService.page(page, queryWrapper);

        Assert.assertNotNull(pageResult);
    }

    @Test
    @Rollback
    public void load() {
        String id = "";
        UaaMenu uaaMenu = uaaMenuService.getById(id);

        Assert.assertNotNull(uaaMenu);
    }

    @Test
    @Rollback
    public void create() {
        UaaMenu uaaMenu = new UaaMenu();
        uaaMenuService.saveOrUpdate(uaaMenu);

    }

    @Test
    @Rollback
    public void update() {
        UaaMenu uaaMenu = new UaaMenu();
        uaaMenuService.saveOrUpdate(uaaMenu);

    }

    @Test
    @Rollback
    public void delete() {
        String id = "";
        uaaMenuService.removeById(id);

    }

}
