package io.github.suxil.auth.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.suxil.auth.domain.UaaUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 用户信息 服务类 测试用例
 * </p>
 *
 * @author generate
 * @since 2020-01-01
 */
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
@ActiveProfiles({"dev"})
public class UaaUserServiceTest {

    @Autowired
    private UaaUserService uaaUserService;

    @Test
    @Rollback
    public void listTest() {
        Page<UaaUser> page = new Page<>();
        page.setPages(0);
        page.setSize(10);

        QueryWrapper<UaaUser> queryWrapper = new QueryWrapper<>();

        IPage<UaaUser> pageResult = uaaUserService.page(page, queryWrapper);

        Assertions.assertNotNull(pageResult);
    }

    @Test
    @Rollback
    public void loadTest() {
        String id = "";
        UaaUser uaaUser = uaaUserService.getById(id);

        Assertions.assertNotNull(uaaUser);
    }

    @Test
    @Rollback
    public void createTest() {
        UaaUser uaaUser = new UaaUser();
        uaaUser.setUserCode("admin");
        uaaUser.setUserName("admin");
        uaaUserService.saveOrUpdate(uaaUser);

        uaaUser.setDescription("test");

        uaaUserService.updateById(uaaUser);

        System.out.println();
    }

    @Test
    @Rollback
    public void updateTest() {
        UaaUser uaaUser = new UaaUser();
        uaaUserService.saveOrUpdate(uaaUser);

    }

    @Test
    @Rollback
    public void deleteTest() {
        String id = "";
        uaaUserService.removeById(id);

    }

}
