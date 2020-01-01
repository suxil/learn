package com.learn.auth.repository;

import com.learn.auth.domain.UaaGroup;
import com.learn.auth.domain.UaaGroupUser;
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
public class UaaGroupUserRepositoryTest {

    @Autowired
    private UaaGroupUserRepository uaaGroupUserRepository;

    @Test
    @Rollback
    public void selectGroupByUserIdTest() {
        String userId = "";
        List<UaaGroup> uaaGroupList = uaaGroupUserRepository.selectGroupByUserId(userId);

        Assert.assertNotNull(uaaGroupList);
    }

    @Test
    @Rollback
    public void selectUserByGroupIdTest() {
        String groupId = "";
        List<UaaUser> uaaUserList = uaaGroupUserRepository.selectUserByGroupId(groupId);

        Assert.assertNotNull(uaaUserList);
    }

}
