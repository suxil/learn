package com.learn.auth.web.api;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaDepartmentPosition;
import com.learn.auth.service.UaaDepartmentPositionService;
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
 * 部门-岗位信息 前端控制器 测试用例
 * </p>
 *
 * @author generate
 * @since 2020-01-01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ActiveProfiles({"dev"})
public class UaaDepartmentPositionControllerTest {

    @Autowired
    private UaaDepartmentPositionService uaaDepartmentPositionService;

    @Test
    @Rollback
    public void listTest() {
        Page<UaaDepartmentPosition> page = new Page<>();
        page.setPages(0);
        page.setSize(10);

        QueryWrapper<UaaDepartmentPosition> queryWrapper = new QueryWrapper<>();

        IPage<UaaDepartmentPosition> pageResult = uaaDepartmentPositionService.page(page, queryWrapper);

        Assert.assertNotNull(pageResult);
    }

    @Test
    @Rollback
    public void loadTest() {
        String id = "";
        UaaDepartmentPosition uaaDepartmentPosition = uaaDepartmentPositionService.getById(id);

        Assert.assertNotNull(uaaDepartmentPosition);
    }

    @Test
    @Rollback
    public void createTest() {
        UaaDepartmentPosition uaaDepartmentPosition = new UaaDepartmentPosition();
        uaaDepartmentPositionService.saveOrUpdate(uaaDepartmentPosition);

    }

    @Test
    @Rollback
    public void updateTest() {
        UaaDepartmentPosition uaaDepartmentPosition = new UaaDepartmentPosition();
        uaaDepartmentPositionService.saveOrUpdate(uaaDepartmentPosition);

    }

    @Test
    @Rollback
    public void deleteTest() {
        String id = "";
        uaaDepartmentPositionService.removeById(id);

    }

}
