package com.learn.auth.web.api;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaPosition;
import com.learn.auth.service.UaaPositionService;
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
 * 部门信息 前端控制器 测试用例
 * </p>
 *
 * @author generate
 * @since 2019-12-22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ActiveProfiles({"dev"})
public class UaaPositionControllerTest {

    @Autowired
    private UaaPositionService uaaPositionService;

    @Test
    public void list() {
        Page<UaaPosition> page = new Page<>();
        page.setPages(0);
        page.setSize(10);

        QueryWrapper<UaaPosition> queryWrapper = new QueryWrapper<>();

        IPage<UaaPosition> pageResult = uaaPositionService.page(page, queryWrapper);

        Assert.assertNotNull(pageResult);
    }

    @Test
    @Rollback
    public void load() {
        String id = "";
        UaaPosition uaaPosition = uaaPositionService.getById(id);

        Assert.assertNotNull(uaaPosition);
    }

    @Test
    @Rollback
    public void create() {
        UaaPosition uaaPosition = new UaaPosition();
        uaaPositionService.saveOrUpdate(uaaPosition);

    }

    @Test
    @Rollback
    public void update() {
        UaaPosition uaaPosition = new UaaPosition();
        uaaPositionService.saveOrUpdate(uaaPosition);

    }

    @Test
    @Rollback
    public void delete() {
        String id = "";
        uaaPositionService.removeById(id);

    }

}
