package com.learn.auth.web.api;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaUserLoginLog;
import com.learn.auth.service.UaaUserLoginLogService;
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
 * 用户登录日志 前端控制器 测试用例
 * </p>
 *
 * @author generate
 * @since 2019-12-22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ActiveProfiles({"dev"})
public class UaaUserLoginLogControllerTest {

    @Autowired
    private UaaUserLoginLogService uaaUserLoginLogService;

    @Test
    public void list() {
        Page<UaaUserLoginLog> page = new Page<>();
        page.setPages(0);
        page.setSize(10);

        QueryWrapper<UaaUserLoginLog> queryWrapper = new QueryWrapper<>();

        IPage<UaaUserLoginLog> pageResult = uaaUserLoginLogService.page(page, queryWrapper);

        Assert.assertNotNull(pageResult);
    }

    @Test
    @Rollback
    public void load() {
        String id = "";
        UaaUserLoginLog uaaUserLoginLog = uaaUserLoginLogService.getById(id);

        Assert.assertNotNull(uaaUserLoginLog);
    }

    @Test
    @Rollback
    public void create() {
        UaaUserLoginLog uaaUserLoginLog = new UaaUserLoginLog();
        uaaUserLoginLogService.saveOrUpdate(uaaUserLoginLog);

    }

    @Test
    @Rollback
    public void update() {
        UaaUserLoginLog uaaUserLoginLog = new UaaUserLoginLog();
        uaaUserLoginLogService.saveOrUpdate(uaaUserLoginLog);

    }

    @Test
    @Rollback
    public void delete() {
        String id = "";
        uaaUserLoginLogService.removeById(id);

    }

}
