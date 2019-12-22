package com.learn.auth.web.api;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaOfficeDepartment;
import com.learn.auth.service.UaaOfficeDepartmentService;
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
 * 组织-部门信息 前端控制器 测试用例
 * </p>
 *
 * @author generate
 * @since 2019-12-22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ActiveProfiles({"dev"})
public class UaaOfficeDepartmentControllerTest {

    @Autowired
    private UaaOfficeDepartmentService uaaOfficeDepartmentService;

    @Test
    public void list() {
        Page<UaaOfficeDepartment> page = new Page<>();
        page.setPages(0);
        page.setSize(10);

        QueryWrapper<UaaOfficeDepartment> queryWrapper = new QueryWrapper<>();

        IPage<UaaOfficeDepartment> pageResult = uaaOfficeDepartmentService.page(page, queryWrapper);

        Assert.assertNotNull(pageResult);
    }

    @Test
    @Rollback
    public void load() {
        String id = "";
        UaaOfficeDepartment uaaOfficeDepartment = uaaOfficeDepartmentService.getById(id);

        Assert.assertNotNull(uaaOfficeDepartment);
    }

    @Test
    @Rollback
    public void create() {
        UaaOfficeDepartment uaaOfficeDepartment = new UaaOfficeDepartment();
        uaaOfficeDepartmentService.saveOrUpdate(uaaOfficeDepartment);

    }

    @Test
    @Rollback
    public void update() {
        UaaOfficeDepartment uaaOfficeDepartment = new UaaOfficeDepartment();
        uaaOfficeDepartmentService.saveOrUpdate(uaaOfficeDepartment);

    }

    @Test
    @Rollback
    public void delete() {
        String id = "";
        uaaOfficeDepartmentService.removeById(id);

    }

}
