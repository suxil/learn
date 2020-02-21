package com.learn.auth.repository;

import com.learn.auth.domain.UaaGroup;
import com.learn.auth.domain.UaaPermission;
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
 * 组-权限信息 服务类 测试用例
 * </p>
 *
 * @author generate
 * @since 2020-01-01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ActiveProfiles({"dev"})
public class UaaGroupPermissionRepositoryTest {

    @Autowired
    private UaaGroupPermissionRepository uaaGroupPermissionRepository;

    @Test
    @Rollback
    public void selectGroupByPermissionIdTest() {
        String permissionId = "";
        List<UaaGroup> uaaGroupList = uaaGroupPermissionRepository.selectGroupByPermissionId(permissionId);

        Assert.assertNotNull(uaaGroupList);
    }

    @Test
    @Rollback
    public void selectPermissionByGroupIdTest() {
        String groupId = "";
        List<UaaPermission> uaaPermissionList = uaaGroupPermissionRepository.selectPermissionByGroupId(groupId);

        Assert.assertNotNull(uaaPermissionList);
    }

}
