package com.learn.auth.web.api;

import com.alibaba.druid.pool.WrapperAdapter;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.learn.auth.domain.UaaUser;
import com.learn.auth.mapper.UaaUserMapper;
import com.learn.auth.service.IUaaUserService;
import com.learn.core.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.learn.core.common.BaseController;

import java.util.function.Function;

/**
 * <p>
 * 用户信息 前端控制器
 * </p>
 *
 * @author generate
 * @since 2019-11-17
 */
@Api(value = "用户信息 接口")
@RestController
@RequestMapping("/api/v1/uaa-user")
public class UaaUserController extends BaseController {

    @Autowired
    private UaaUserMapper uaaUserMapper;
    @Autowired
    private IUaaUserService uaaUserService;

    @GetMapping
    @ApiOperation(value = "用户信息 分页查询")
    @Validated
    public ResponseResult list() {
        Page<UaaUser> page = new Page<>();
        page.setPages(0);
        page.setSize(10);

        QueryWrapper<UaaUser> uaaUserWrapper = new QueryWrapper<UaaUser>();

        new LambdaQueryChainWrapper(uaaUserMapper).eq("", "");

        QueryWrapper<UaaUser> queryWrapper = new QueryWrapper<>();

        UpdateWrapper<UaaUser> updateWrapper = new UpdateWrapper<>();

//        uaaUserMapper.selectByMap()

        IPage<UaaUser> pageResult = uaaUserMapper.selectPage(page, uaaUserWrapper);
        return ResponseResult.success(pageResult);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "用户信息 加载")
    public ResponseResult load(@PathVariable String id) {
        return ResponseResult.success(uaaUserService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "用户信息 创建")
    public ResponseResult create(@RequestBody UaaUser uaaUser) {
        uaaUserService.saveOrUpdate(uaaUser);
        return ResponseResult.success(uaaUser);
    }

    @PutMapping
    @ApiOperation(value = "用户信息 更新")
    public ResponseResult update(@RequestBody UaaUser uaaUser) {
        uaaUserService.saveOrUpdate(uaaUser);
        return ResponseResult.success(uaaUser);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "用户信息 删除")
    public ResponseResult delete(@PathVariable String id) {
        return ResponseResult.success(uaaUserService.removeById(id));
    }

}
