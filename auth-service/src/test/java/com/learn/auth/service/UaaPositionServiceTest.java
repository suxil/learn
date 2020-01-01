package com.learn.auth.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaPosition;
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
 * 部门信息 服务类 测试用例
 * </p>
 *
 * @author generate
 * @since 2020-01-01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ActiveProfiles({"dev"})
public class UaaPositionServiceTest {

    @Autowired
    private UaaPositionService uaaPositionService;

    @Test
    @Rollback
    public void listTest() {
        Page<UaaPosition> page = new Page<>();
        page.setPages(0);
        page.setSize(10);

        QueryWrapper<UaaPosition> queryWrapper = new QueryWrapper<>();

        IPage<UaaPosition> pageResult = uaaPositionService.page(page, queryWrapper);

        Assert.assertNotNull(pageResult);
    }

    @Test
    @Rollback
    public void loadTest() {
        String id = "";
        UaaPosition uaaPosition = uaaPositionService.getById(id);

        Assert.assertNotNull(uaaPosition);
    }

    @Test
    @Rollback
    public void createTest() {
        UaaPosition uaaPosition = new UaaPosition();
        uaaPositionService.saveOrUpdate(uaaPosition);

    }

    @Test
    @Rollback
    public void updateTest() {
        UaaPosition uaaPosition = new UaaPosition();
        uaaPositionService.saveOrUpdate(uaaPosition);

    }

    @Test
    @Rollback
    public void deleteTest() {
        String id = "";
        uaaPositionService.removeById(id);

    }

}