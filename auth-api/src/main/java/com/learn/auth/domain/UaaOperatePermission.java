package com.learn.auth.domain;

import com.learn.mybatis.domain.BaseDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * <p>
 * 操作-权限息
 * </p>
 *
 * @author generate
 * @since 2019-11-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="UaaOperatePermission对象", description="操作-权限息")
@Entity
@Table(name = "uaa_operate_permission", catalog = "操作-权限息")
public class UaaOperatePermission extends BaseDomain {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "operate_id", value = "")
    @Column(name = "operate_id")
    private String operateId;

    @ApiModelProperty(name = "permission_id", value = "")
    @Column(name = "permission_id")
    private String permissionId;


}
