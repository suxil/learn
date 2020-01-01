package com.learn.auth.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaMenuElement;
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
 * 页面元素信息 服务类 测试用例
 * </p>
 *
 * @author generate
 * @since 2020-01-01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ActiveProfiles({"dev"})
public class UaaMenuElementServiceTest {

    @Autowired
    private UaaMenuElementService uaaMenuElementService;

    @Test
    @Rollback
    public void listTest() {
        Page<UaaMenuElement> page = new Page<>();
        page.setPages(0);
        page.setSize(10);

        QueryWrapper<UaaMenuElement> queryWrapper = new QueryWrapper<>();

        IPage<UaaMenuElement> pageResult = uaaMenuElementService.page(page, queryWrapper);

        Assert.assertNotNull(pageResult);
    }

    @Test
    @Rollback
    public void loadTest() {
        String id = "";
        UaaMenuElement uaaMenuElement = uaaMenuElementService.getById(id);

        Assert.assertNotNull(uaaMenuElement);
    }

    @Test
    @Rollback
    public void createTest() {
        UaaMenuElement uaaMenuElement = new UaaMenuElement();
        uaaMenuElementService.saveOrUpdate(uaaMenuElement);

    }

    @Test
    @Rollback
    public void updateTest() {
        UaaMenuElement uaaMenuElement = new UaaMenuElement();
        uaaMenuElementService.saveOrUpdate(uaaMenuElement);

    }

    @Test
    @Rollback
    public void deleteTest() {
        String id = "";
        uaaMenuElementService.removeById(id);

    }

}
