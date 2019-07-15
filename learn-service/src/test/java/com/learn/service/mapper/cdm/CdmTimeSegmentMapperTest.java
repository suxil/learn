package com.learn.service.mapper.cdm;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.api.domain.cdm.CdmTimeSegment;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CdmTimeSegmentMapperTest {
    
    @Autowired
    private CdmTimeSegmentMapper cdmTimeSegmentMapper;

    @Test
    @After
    public void selectTest() {
        System.out.println(("----- selectAll method test ------"));
        List<CdmTimeSegment> cdmTimeSegmentList = cdmTimeSegmentMapper.selectList(null);
        Assert.assertEquals(14, cdmTimeSegmentList.size());
        cdmTimeSegmentList.forEach(System.out::println);
    }

    @Test
    public void selectPageTest() {
        IPage<CdmTimeSegment> page = new Page<>(1, 5);
        IPage<CdmTimeSegment> pageData = cdmTimeSegmentMapper.selectPage(page, null);

        Assert.assertNotNull(pageData.getRecords());
        Assert.assertEquals(String.valueOf(5), String.valueOf(pageData.getSize()));
    }

    @Test
    @Transactional
    @Rollback
    public void insertTest() {
        CdmTimeSegment cdmTimeSegment = new CdmTimeSegment();
        cdmTimeSegment.setDescription("test");

        int num = cdmTimeSegmentMapper.insert(cdmTimeSegment);

        String id = cdmTimeSegment.getId();

        CdmTimeSegment nowCdmTimeSegment = cdmTimeSegmentMapper.selectById(id);

        Assert.assertEquals(nowCdmTimeSegment.getDescription(), cdmTimeSegment.getDescription());
    }

    @Test
    @Transactional
    @Rollback
    public void lockTest() {
        CdmTimeSegment cdmTimeSegment = cdmTimeSegmentMapper.selectById("123c1b28583f463cb6421ed4487717fb");
        cdmTimeSegment.setDescription("test");

        Long version = cdmTimeSegment.getVersion() + 1;

        cdmTimeSegmentMapper.updateById(cdmTimeSegment);

        Assert.assertEquals(version, cdmTimeSegment.getVersion());
    }

    @Test
    @Transactional
    @Rollback
    public void updateTest() {
        CdmTimeSegment cdmTimeSegment = new CdmTimeSegment();
        cdmTimeSegment.setId("8d57a8f7efd942739dc44a01c7c0ba3b");
        cdmTimeSegment.setDescription("test");

        int num = cdmTimeSegmentMapper.updateById(cdmTimeSegment);

        CdmTimeSegment nowCdmTimeSegment = cdmTimeSegmentMapper.selectById("8d57a8f7efd942739dc44a01c7c0ba3b");

        Assert.assertEquals(nowCdmTimeSegment.getDescription(), cdmTimeSegment.getDescription());
    }

    @Test
    @Transactional
    @Rollback
    public void deleteTest() {
        int num = cdmTimeSegmentMapper.deleteById("1aac2c8e6a1345f6a206beac8819b53f");

        CdmTimeSegment cdmTimeSegment = cdmTimeSegmentMapper.selectById("1aac2c8e6a1345f6a206beac8819b53f");

        Assert.assertNull(cdmTimeSegment);
    }

}
