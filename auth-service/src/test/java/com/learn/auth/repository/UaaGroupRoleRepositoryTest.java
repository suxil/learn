package com.learn.auth.repository;

import com.learn.auth.domain.UaaGroup;
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
 * 组-角色信息 服务类 测试用例
 * </p>
 *
 * @author generate
 * @since 2020-01-01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ActiveProfiles({"dev"})
public class UaaGroupRoleRepositoryTest {

    @Autowired
    private UaaGroupRoleRepository uaaGroupRoleRepository;

    @Test
    @Rollback
    public void selectGroupByRoleIdTest() {
        String roleId = "";
        List<UaaGroup> uaaGroupList = uaaGroupRoleRepository.selectGroupByRoleId(roleId);

        Assert.assertNotNull(uaaGroupList);
    }

    @Test
    @Rollback
    public void selectRoleByGroupIdTest() {
        String groupId = "";
        List<UaaRole> uaaRoleList = uaaGroupRoleRepository.selectRoleByGroupId(groupId);

        Assert.assertNotNull(uaaRoleList);
    }

}
