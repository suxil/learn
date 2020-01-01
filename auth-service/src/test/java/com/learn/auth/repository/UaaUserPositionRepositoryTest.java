package com.learn.auth.repository;

import com.learn.auth.domain.UaaPosition;
import com.learn.auth.domain.UaaUser;
import com.learn.auth.domain.UaaUserPosition;
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
 * 用户-岗位信息 服务类 测试用例
 * </p>
 *
 * @author generate
 * @since 2020-01-01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ActiveProfiles({"dev"})
public class UaaUserPositionRepositoryTest {

    @Autowired
    private UaaUserPositionRepository uaaUserPositionRepository;

    @Test
    @Rollback
    public void selectUserByPositionIdTest() {
        String positionId = "";
        List<UaaUser> uaaUserList = uaaUserPositionRepository.selectUserByPositionId(positionId);

        Assert.assertNotNull(uaaUserList);
    }

    @Test
    @Rollback
    public void selectPositionByUserIdTest() {
        String userId = "";
        List<UaaPosition> uaaPositionList = uaaUserPositionRepository.selectPositionByUserId(userId);

        Assert.assertNotNull(uaaPositionList);
    }

}
