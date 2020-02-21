package com.learn.auth.repository;

import com.learn.auth.domain.UaaPermission;
import com.learn.auth.domain.UaaRole;
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
 * 角色-权限信息 服务类 测试用例
 * </p>
 *
 * @author generate
 * @since 2020-01-01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ActiveProfiles({"dev"})
public class UaaRolePermissionRepositoryTest {

    @Autowired
    private UaaRolePermissionRepository uaaRolePermissionRepository;

    @Test
    @Rollback
    public void selectRoleByPermissionIdTest() {
        String permissionId = "";
        List<UaaRole> uaaRoleList = uaaRolePermissionRepository.selectRoleByPermissionId(permissionId);

        Assert.assertNotNull(uaaRoleList);
    }

    @Test
    @Rollback
    public void selectPermissionByRoleIdTest() {
        String roleId = "";
        List<UaaPermission> uaaPermissionList = uaaRolePermissionRepository.selectPermissionByRoleId(roleId);

        Assert.assertNotNull(uaaPermissionList);
    }

}
