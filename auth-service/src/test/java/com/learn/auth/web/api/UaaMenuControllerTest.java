package com.learn.auth.web.api;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaMenu;
import com.learn.auth.service.UaaMenuService;
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
 * 菜单信息 前端控制器 测试用例
 * </p>
 *
 * @author generate
 * @since 2020-01-01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ActiveProfiles({"dev"})
public class UaaMenuControllerTest {

    @Autowired
    private UaaMenuService uaaMenuService;

    @Test
    @Rollback
    public void listTest() {
        Page<UaaMenu> page = new Page<>();
        page.setPages(0);
        page.setSize(10);

        QueryWrapper<UaaMenu> queryWrapper = new QueryWrapper<>();

        IPage<UaaMenu> pageResult = uaaMenuService.page(page, queryWrapper);

        Assert.assertNotNull(pageResult);
    }

    @Test
    @Rollback
    public void loadTest() {
        String id = "";
        UaaMenu uaaMenu = uaaMenuService.getById(id);

        Assert.assertNotNull(uaaMenu);
    }

    @Test
    @Rollback
    public void createTest() {
        UaaMenu uaaMenu = new UaaMenu();
        uaaMenuService.saveOrUpdate(uaaMenu);

    }

    @Test
    @Rollback
    public void updateTest() {
        UaaMenu uaaMenu = new UaaMenu();
        uaaMenuService.saveOrUpdate(uaaMenu);

    }

    @Test
    @Rollback
    public void deleteTest() {
        String id = "";
        uaaMenuService.removeById(id);

    }

}
