package com.learn.auth.web.api;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaUserPosition;
import com.learn.auth.service.UaaUserPositionService;
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
 * 用户-岗位信息 前端控制器 测试用例
 * </p>
 *
 * @author generate
 * @since 2019-12-22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ActiveProfiles({"dev"})
public class UaaUserPositionControllerTest {

    @Autowired
    private UaaUserPositionService uaaUserPositionService;

    @Test
    public void list() {
        Page<UaaUserPosition> page = new Page<>();
        page.setPages(0);
        page.setSize(10);

        QueryWrapper<UaaUserPosition> queryWrapper = new QueryWrapper<>();

        IPage<UaaUserPosition> pageResult = uaaUserPositionService.page(page, queryWrapper);

        Assert.assertNotNull(pageResult);
    }

    @Test
    @Rollback
    public void load() {
        String id = "";
        UaaUserPosition uaaUserPosition = uaaUserPositionService.getById(id);

        Assert.assertNotNull(uaaUserPosition);
    }

    @Test
    @Rollback
    public void create() {
        UaaUserPosition uaaUserPosition = new UaaUserPosition();
        uaaUserPositionService.saveOrUpdate(uaaUserPosition);

    }

    @Test
    @Rollback
    public void update() {
        UaaUserPosition uaaUserPosition = new UaaUserPosition();
        uaaUserPositionService.saveOrUpdate(uaaUserPosition);

    }

    @Test
    @Rollback
    public void delete() {
        String id = "";
        uaaUserPositionService.removeById(id);

    }

}
