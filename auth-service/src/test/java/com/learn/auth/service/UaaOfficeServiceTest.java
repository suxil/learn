package com.learn.auth.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaOffice;
import com.learn.auth.dto.UaaOfficeTreeDto;
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
 * 组织信息 服务类 测试用例
 * </p>
 *
 * @author generate
 * @since 2020-01-01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ActiveProfiles({"dev"})
public class UaaOfficeServiceTest {

    @Autowired
    private UaaOfficeService uaaOfficeService;

    @Test
    @Rollback
    public void selectOfficeTreeTest() {
        List<UaaOfficeTreeDto> officeTreeDtoList = uaaOfficeService.selectOfficeTree();

        Assert.assertNotNull(officeTreeDtoList);
        Assert.assertFalse(officeTreeDtoList.isEmpty());
    }

    @Test
    @Rollback
    public void listTest() {
        Page<UaaOffice> page = new Page<>();
        page.setPages(0);
        page.setSize(10);

        QueryWrapper<UaaOffice> queryWrapper = new QueryWrapper<>();

        IPage<UaaOffice> pageResult = uaaOfficeService.page(page, queryWrapper);

        Assert.assertNotNull(pageResult);
    }

    @Test
    @Rollback
    public void loadTest() {
        String id = "";
        UaaOffice uaaOffice = uaaOfficeService.getById(id);

        Assert.assertNotNull(uaaOffice);
    }

    @Test
    @Rollback
    public void createTest() {
        UaaOffice uaaOffice = new UaaOffice();
        uaaOfficeService.saveOrUpdate(uaaOffice);

    }

    @Test
    @Rollback
    public void updateTest() {
        UaaOffice uaaOffice = new UaaOffice();
        uaaOfficeService.saveOrUpdate(uaaOffice);

    }

    @Test
    @Rollback
    public void deleteTest() {
        String id = "";
        uaaOfficeService.removeById(id);

    }

}
