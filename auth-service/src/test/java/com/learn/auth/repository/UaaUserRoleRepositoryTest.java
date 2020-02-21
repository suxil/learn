package com.learn.auth.repository;

import com.learn.auth.domain.UaaRole;
import com.learn.auth.domain.UaaUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
public class UaaUserRoleRepositoryTest {

    @Autowired
    private UaaUserRoleRepository uaaUserRoleRepository;

    @Test
    @Rollback
    public void selectUserByRoleIdTest() {
        String roleId = "";
        List<UaaUser> uaaUserList = uaaUserRoleRepository.selectUserByRoleId(roleId);

        Assert.assertNotNull(uaaUserList);
    }

    @Test
    @Rollback
    public void selectRoleByUserIdTest() {
        String userId = "";
        List<UaaRole> uaaRoleList = uaaUserRoleRepository.selectRoleByUserId(userId);

        Assert.assertNotNull(uaaRoleList);
    }

}
