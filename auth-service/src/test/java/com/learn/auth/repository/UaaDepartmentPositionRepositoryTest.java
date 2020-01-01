package com.learn.auth.repository;

import com.learn.auth.domain.UaaDepartment;
import com.learn.auth.domain.UaaDepartmentPosition;
import com.learn.auth.domain.UaaPosition;
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
 * 部门-岗位信息 服务类 测试用例
 * </p>
 *
 * @author generate
 * @since 2020-01-01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ActiveProfiles({"dev"})
public class UaaDepartmentPositionRepositoryTest {

    @Autowired
    private UaaDepartmentPositionRepository uaaDepartmentPositionRepository;

    @Test
    @Rollback
    public void selectDepartmentByPositionIdTest() {
        String positionId = "";
        List<UaaDepartment> uaaDepartmentList = uaaDepartmentPositionRepository.selectDepartmentByPositionId(positionId);

        Assert.assertNotNull(uaaDepartmentList);
    }

    @Test
    @Rollback
    public void selectPositionByDepartmentIdTest() {
        String departmentId = "";
        List<UaaPosition> uaaPositionList = uaaDepartmentPositionRepository.selectPositionByDepartmentId(departmentId);

        Assert.assertNotNull(uaaPositionList);
    }

}
