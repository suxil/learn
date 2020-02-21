package com.learn.auth.repository;

import com.learn.auth.domain.UaaPermission;
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
 * 用户-权限信息 服务类 测试用例
 * </p>
 *
 * @author generate
 * @since 2020-01-01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ActiveProfiles({"dev"})
public class UaaUserPermissionRepositoryTest {

    @Autowired
    private UaaUserPermissionRepository uaaUserPermissionRepository;

    @Test
    @Rollback
    public void selectUserByPermissionIdTest() {
        String permissionId = "";
        List<UaaUser> uaaUserList = uaaUserPermissionRepository.selectUserByPermissionId(permissionId);

        Assert.assertNotNull(uaaUserList);
    }

    @Test
    @Rollback
    public void Test() {
        String userId = "";
        List<UaaPermission> uaaPermissionList = uaaUserPermissionRepository.selectPermissionByUserId(userId);

        Assert.assertNotNull(uaaPermissionList);
    }

}
