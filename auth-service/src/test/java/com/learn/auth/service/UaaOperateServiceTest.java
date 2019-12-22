package com.learn.auth.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaOperate;
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
 * 操作信息 服务类 测试用例
 * </p>
 *
 * @author generate
 * @since 2019-12-22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ActiveProfiles({"dev"})
public class UaaOperateServiceTest {

    @Autowired
    private UaaOperateService uaaOperateService;

    @Test
    public void list() {
        Page<UaaOperate> page = new Page<>();
        page.setPages(0);
        page.setSize(10);

        QueryWrapper<UaaOperate> queryWrapper = new QueryWrapper<>();

        IPage<UaaOperate> pageResult = uaaOperateService.page(page, queryWrapper);

        Assert.assertNotNull(pageResult);
    }

    @Test
    @Rollback
    public void load() {
        String id = "";
        UaaOperate uaaOperate = uaaOperateService.getById(id);

        Assert.assertNotNull(uaaOperate);
    }

    @Test
    @Rollback
    public void create() {
        UaaOperate uaaOperate = new UaaOperate();
        uaaOperateService.saveOrUpdate(uaaOperate);

    }

    @Test
    @Rollback
    public void update() {
        UaaOperate uaaOperate = new UaaOperate();
        uaaOperateService.saveOrUpdate(uaaOperate);

    }

    @Test
    @Rollback
    public void delete() {
        String id = "";
        uaaOperateService.removeById(id);

    }

}
