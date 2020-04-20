package com.learn.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.auth.converter.UaaOfficeConverter;
import com.learn.auth.domain.UaaOffice;
import com.learn.auth.dto.UaaOfficeTreeDto;
import com.learn.auth.repository.UaaOfficeRepository;
import com.learn.auth.service.UaaOfficeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 组织信息 服务实现类
 * </p>
 *
 * @author generate
 * @since 2019-12-22
 */
@Service
@Slf4j
public class UaaOfficeServiceImpl extends ServiceImpl<UaaOfficeRepository, UaaOffice> implements UaaOfficeService {

    @Override
    public List<UaaOfficeTreeDto> selectOfficeTree() {
        return UaaOfficeConverter.INSTANCE.convertToTree(super.list());
    }

}
