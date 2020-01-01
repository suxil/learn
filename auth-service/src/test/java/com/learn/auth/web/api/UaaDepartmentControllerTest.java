package com.learn.auth.web.api;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaDepartment;
import com.learn.auth.service.UaaDepartmentService;
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
 * @since 2020-01-01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ActiveProfiles({"dev"})
public class UaaDepartmentControllerTest {

    @Autowired
    private UaaDepartmentService uaaDepartmentService;

    @Test
    @Rollback
    public void listTest() {
        Page<UaaDepartment> page = new Page<>();
        page.setPages(0);
        page.setSize(10);

        QueryWrapper<UaaDepartment> queryWrapper = new QueryWrapper<>();

        IPage<UaaDepartment> pageResult = uaaDepartmentService.page(page, queryWrapper);

        Assert.assertNotNull(pageResult);
    }

    @Test
    @Rollback
    public void loadTest() {
        String id = "";
        UaaDepartment uaaDepartment = uaaDepartmentService.getById(id);

        Assert.assertNotNull(uaaDepartment);
    }

    @Test
    @Rollback
    public void createTest() {
        UaaDepartment uaaDepartment = new UaaDepartment();
        uaaDepartmentService.saveOrUpdate(uaaDepartment);

    }

    @Test
    @Rollback
    public void updateTest() {
        UaaDepartment uaaDepartment = new UaaDepartment();
        uaaDepartmentService.saveOrUpdate(uaaDepartment);

    }

    @Test
    @Rollback
    public void deleteTest() {
        String id = "";
        uaaDepartmentService.removeById(id);

    }

}
