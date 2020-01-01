package com.learn.auth.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaUserPosition;
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
 * 用户-岗位信息 服务类 测试用例
 * </p>
 *
 * @author generate
 * @since 2020-01-01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ActiveProfiles({"dev"})
public class UaaUserPositionServiceTest {

    @Autowired
    private UaaUserPositionService uaaUserPositionService;

    @Test
    @Rollback
    public void listTest() {
        Page<UaaUserPosition> page = new Page<>();
        page.setPages(0);
        page.setSize(10);

        QueryWrapper<UaaUserPosition> queryWrapper = new QueryWrapper<>();

        IPage<UaaUserPosition> pageResult = uaaUserPositionService.page(page, queryWrapper);

        Assert.assertNotNull(pageResult);
    }

    @Test
    @Rollback
    public void loadTest() {
        String id = "";
        UaaUserPosition uaaUserPosition = uaaUserPositionService.getById(id);

        Assert.assertNotNull(uaaUserPosition);
    }

    @Test
    @Rollback
    public void createTest() {
        UaaUserPosition uaaUserPosition = new UaaUserPosition();
        uaaUserPositionService.saveOrUpdate(uaaUserPosition);

    }

    @Test
    @Rollback
    public void updateTest() {
        UaaUserPosition uaaUserPosition = new UaaUserPosition();
        uaaUserPositionService.saveOrUpdate(uaaUserPosition);

    }

    @Test
    @Rollback
    public void deleteTest() {
        String id = "";
        uaaUserPositionService.removeById(id);

    }

}
