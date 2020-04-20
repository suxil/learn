package com.learn.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.auth.domain.UaaUserPosition;
import com.learn.auth.repository.UaaUserPositionRepository;
import com.learn.auth.service.UaaUserPositionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户-岗位信息 服务实现类
 * </p>
 *
 * @author generate
 * @since 2019-12-22
 */
@Service
@Slf4j
public class UaaUserPositionServiceImpl extends ServiceImpl<UaaUserPositionRepository, UaaUserPosition> implements UaaUserPositionService {

}
