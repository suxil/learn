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
 * 操作-权限表
 * </p>
 *
 * @author generate
 * @since 2020-04-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="UaaOperatePermission对象", description="操作-权限表")
@Entity
@Table(name = "uaa_operate_permission", catalog = "操作-权限表")
public class UaaOperatePermission extends BaseDomain {

    private static final long serialVersionUID = 1L;

    public static final String OPERATE_ID = "operate_id";
    public static final String PERMISSION_ID = "permission_id";

    @ApiModelProperty(name = "operate_id", value = "")
    @Column(name = "operate_id")
    private String operateId;

    @ApiModelProperty(name = "permission_id", value = "")
    @Column(name = "permission_id")
    private String permissionId;


}
