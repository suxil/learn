package io.github.suxil.auth.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.suxil.auth.domain.UaaUserRole;
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
 * 角色信息 服务类 测试用例
 * </p>
 *
 * @author generate
 * @since 2020-01-01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ActiveProfiles({"dev"})
public class UaaUserRoleServiceTest {

    @Autowired
    private UaaUserRoleService uaaUserRoleService;

    @Test
    @Rollback
    public void listTest() {
        Page<UaaUserRole> page = new Page<>();
        page.setPages(0);
        page.setSize(10);

        QueryWrapper<UaaUserRole> queryWrapper = new QueryWrapper<>();

        IPage<UaaUserRole> pageResult = uaaUserRoleService.page(page, queryWrapper);

        Assert.assertNotNull(pageResult);
    }

    @Test
    @Rollback
    public void loadTest() {
        String id = "";
        UaaUserRole uaaUserRole = uaaUserRoleService.getById(id);

        Assert.assertNotNull(uaaUserRole);
    }

    @Test
    @Rollback
    public void createTest() {
        UaaUserRole uaaUserRole = new UaaUserRole();
        uaaUserRoleService.saveOrUpdate(uaaUserRole);

    }

    @Test
    @Rollback
    public void updateTest() {
        UaaUserRole uaaUserRole = new UaaUserRole();
        uaaUserRoleService.saveOrUpdate(uaaUserRole);

    }

    @Test
    @Rollback
    public void deleteTest() {
        String id = "";
        uaaUserRoleService.removeById(id);

    }

}
