package com.learn.auth.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaGroupUser;
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
 * 组-用户信息 服务类 测试用例
 * </p>
 *
 * @author generate
 * @since 2019-12-22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ActiveProfiles({"dev"})
public class UaaGroupUserServiceTest {

    @Autowired
    private UaaGroupUserService uaaGroupUserService;

    @Test
    public void list() {
        Page<UaaGroupUser> page = new Page<>();
        page.setPages(0);
        page.setSize(10);

        QueryWrapper<UaaGroupUser> queryWrapper = new QueryWrapper<>();

        IPage<UaaGroupUser> pageResult = uaaGroupUserService.page(page, queryWrapper);

        Assert.assertNotNull(pageResult);
    }

    @Test
    @Rollback
    public void load() {
        String id = "";
        UaaGroupUser uaaGroupUser = uaaGroupUserService.getById(id);

        Assert.assertNotNull(uaaGroupUser);
    }

    @Test
    @Rollback
    public void create() {
        UaaGroupUser uaaGroupUser = new UaaGroupUser();
        uaaGroupUserService.saveOrUpdate(uaaGroupUser);

    }

    @Test
    @Rollback
    public void update() {
        UaaGroupUser uaaGroupUser = new UaaGroupUser();
        uaaGroupUserService.saveOrUpdate(uaaGroupUser);

    }

    @Test
    @Rollback
    public void delete() {
        String id = "";
        uaaGroupUserService.removeById(id);

    }

}
