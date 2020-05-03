package com.learn.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.auth.domain.UaaOffice;
import com.learn.auth.vo.UaaOfficeTreeVo;

import java.util.List;

/**
 * <p>
 * 组织信息 服务类
 * </p>
 *
 * @author generate
 * @since 2019-12-22
 */
public interface UaaOfficeService extends IService<UaaOffice> {

    /***
     * Description: 通过组织代码查询组织树
     * date: 2020/1/1 11:33
     *
     * @author suxi
     * @version V1.0
     * @return java.util.List<com.learn.auth.vo.UaaOfficeTreeDto>
     */
    List<UaaOfficeTreeVo> selectOfficeTree();

}
