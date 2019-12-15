package com.learn.auth.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaPageElement;
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
 * @since 2019-12-15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ActiveProfiles({"dev"})
public class UaaPageElementServiceTest {

    @Autowired
    private UaaPageElementService uaaPageElementService;

    @Test
    public void list() {
        Page<UaaPageElement> page = new Page<>();
        page.setPages(0);
        page.setSize(1);

        QueryWrapper<UaaPageElement> queryWrapper = new QueryWrapper<>();

        IPage<UaaPageElement> pageResult = uaaPageElementService.page(page, queryWrapper);

        Assert.assertNotNull(pageResult);
    }

    @Test
    @Rollback
    public void load() {
        String id = "";
        UaaPageElement uaaPageElement = uaaPageElementService.getById(id);

        Assert.assertNotNull(uaaPageElement);
    }

    @Test
    @Rollback
    public void create() {
        UaaPageElement uaaPageElement = new UaaPageElement();
        uaaPageElementService.saveOrUpdate(uaaPageElement);

    }

    @Test
    @Rollback
    public void update() {
        UaaPageElement uaaPageElement = new UaaPageElement();
        uaaPageElementService.saveOrUpdate(uaaPageElement);

    }

    @Test
    @Rollback
    public void delete() {
        String id = "";
        uaaPageElementService.removeById(id);

    }

}
