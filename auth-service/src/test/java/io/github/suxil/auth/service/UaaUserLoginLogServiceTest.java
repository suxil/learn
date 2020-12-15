package io.github.suxil.auth.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.suxil.auth.domain.UaaUserLoginLog;
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
 * 用户登录日志 服务类 测试用例
 * </p>
 *
 * @author generate
 * @since 2020-01-01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ActiveProfiles({"dev"})
public class UaaUserLoginLogServiceTest {

    @Autowired
    private UaaUserLoginLogService uaaUserLoginLogService;

    @Test
    @Rollback
    public void listTest() {
        Page<UaaUserLoginLog> page = new Page<>();
        page.setPages(0);
        page.setSize(10);

        QueryWrapper<UaaUserLoginLog> queryWrapper = new QueryWrapper<>();

        IPage<UaaUserLoginLog> pageResult = uaaUserLoginLogService.page(page, queryWrapper);

        Assert.assertNotNull(pageResult);
    }

    @Test
    @Rollback
    public void loadTest() {
        String id = "";
        UaaUserLoginLog uaaUserLoginLog = uaaUserLoginLogService.getById(id);

        Assert.assertNotNull(uaaUserLoginLog);
    }

    @Test
    @Rollback
    public void createTest() {
        UaaUserLoginLog uaaUserLoginLog = new UaaUserLoginLog();
        uaaUserLoginLogService.saveOrUpdate(uaaUserLoginLog);

    }

    @Test
    @Rollback
    public void updateTest() {
        UaaUserLoginLog uaaUserLoginLog = new UaaUserLoginLog();
        uaaUserLoginLogService.saveOrUpdate(uaaUserLoginLog);

    }

    @Test
    @Rollback
    public void deleteTest() {
        String id = "";
        uaaUserLoginLogService.removeById(id);

    }

}
