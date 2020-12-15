package io.github.suxil.auth.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.suxil.auth.domain.UaaGroupUser;
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
 * @since 2020-01-01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ActiveProfiles({"dev"})
public class UaaGroupUserServiceTest {

    @Autowired
    private UaaGroupUserService uaaGroupUserService;

    @Test
    @Rollback
    public void listTest() {
        Page<UaaGroupUser> page = new Page<>();
        page.setPages(0);
        page.setSize(10);

        QueryWrapper<UaaGroupUser> queryWrapper = new QueryWrapper<>();

        IPage<UaaGroupUser> pageResult = uaaGroupUserService.page(page, queryWrapper);

        Assert.assertNotNull(pageResult);
    }

    @Test
    @Rollback
    public void loadTest() {
        String id = "";
        UaaGroupUser uaaGroupUser = uaaGroupUserService.getById(id);

        Assert.assertNotNull(uaaGroupUser);
    }

    @Test
    @Rollback
    public void createTest() {
        UaaGroupUser uaaGroupUser = new UaaGroupUser();
        uaaGroupUserService.saveOrUpdate(uaaGroupUser);

    }

    @Test
    @Rollback
    public void updateTest() {
        UaaGroupUser uaaGroupUser = new UaaGroupUser();
        uaaGroupUserService.saveOrUpdate(uaaGroupUser);

    }

    @Test
    @Rollback
    public void deleteTest() {
        String id = "";
        uaaGroupUserService.removeById(id);

    }

}
