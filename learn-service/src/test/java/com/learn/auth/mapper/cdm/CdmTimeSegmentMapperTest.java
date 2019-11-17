package com.learn.auth.mapper.cdm;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.service.domain.cdm.CdmTimeSegment;
import com.learn.service.LearnServiceApplication;
import com.learn.service.mapper.cdm.CdmTimeSegmentMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LearnServiceApplication.class)
@Transactional
@Rollback
public class CdmTimeSegmentMapperTest {
    
    @Autowired
    private CdmTimeSegmentMapper cdmTimeSegmentMapper;

    @Test
    @Before
    public void selectTest() {
        System.out.println(("----- selectAll method test ------"));
        List<CdmTimeSegment> cdmTimeSegmentList = cdmTimeSegmentMapper.selectList(null);
        Assert.assertEquals(12, cdmTimeSegmentList.size());
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
    public void insertTest() {
        CdmTimeSegment cdmTimeSegment = new CdmTimeSegment();
        cdmTimeSegment.setDescription("test");

        int num = cdmTimeSegmentMapper.insert(cdmTimeSegment);

        String id = cdmTimeSegment.getId();

        CdmTimeSegment nowCdmTimeSegment = cdmTimeSegmentMapper.selectById(id);

        Assert.assertEquals(cdmTimeSegment.getDescription(), nowCdmTimeSegment.getDescription());
    }

    @Test
    public void lockTest() {
        CdmTimeSegment cdmTimeSegment = cdmTimeSegmentMapper.selectById("9eca698d87be4dfe898a8c4887472122");
        cdmTimeSegment.setDescription("test");

        Long version = cdmTimeSegment.getVersion() + 1;

        cdmTimeSegmentMapper.updateById(cdmTimeSegment);

        Assert.assertEquals(version, cdmTimeSegment.getVersion());
    }

    @Test
    public void updateTest() {
        CdmTimeSegment cdmTimeSegment = new CdmTimeSegment();
        cdmTimeSegment.setId("9eca698d87be4dfe898a8c4887472122");
        cdmTimeSegment.setDescription("test1");

        int num = cdmTimeSegmentMapper.updateById(cdmTimeSegment);

        CdmTimeSegment nowCdmTimeSegment = cdmTimeSegmentMapper.selectById("9eca698d87be4dfe898a8c4887472122");

        Assert.assertEquals(nowCdmTimeSegment.getDescription(), cdmTimeSegment.getDescription());
    }

    @Test
    public void deleteTest() {
        int num = cdmTimeSegmentMapper.deleteById("a8a759517d774fe49e8dfdcc5b8aa27a");

        CdmTimeSegment cdmTimeSegment = cdmTimeSegmentMapper.selectById("a8a759517d774fe49e8dfdcc5b8aa27a");

        Assert.assertNull(cdmTimeSegment);
    }

}
