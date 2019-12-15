package com.learn.auth.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaGroup;
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
 * 组信息 服务类 测试用例
 * </p>
 *
 * @author generate
 * @since 2019-12-15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ActiveProfiles({"dev"})
public class UaaGroupServiceTest {

    @Autowired
    private UaaGroupService uaaGroupService;

    @Test
    public void list() {
        Page<UaaGroup> page = new Page<>();
        page.setPages(0);
        page.setSize(1);

        QueryWrapper<UaaGroup> queryWrapper = new QueryWrapper<>();

        IPage<UaaGroup> pageResult = uaaGroupService.page(page, queryWrapper);

        Assert.assertNotNull(pageResult);
    }

    @Test
    @Rollback
    public void load() {
        String id = "";
        UaaGroup uaaGroup = uaaGroupService.getById(id);

        Assert.assertNotNull(uaaGroup);
    }

    @Test
    @Rollback
    public void create() {
        UaaGroup uaaGroup = new UaaGroup();
        uaaGroupService.saveOrUpdate(uaaGroup);

    }

    @Test
    @Rollback
    public void update() {
        UaaGroup uaaGroup = new UaaGroup();
        uaaGroupService.saveOrUpdate(uaaGroup);

    }

    @Test
    @Rollback
    public void delete() {
        String id = "";
        uaaGroupService.removeById(id);

    }

}
