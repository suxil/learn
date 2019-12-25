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
 * 组-权限信息
 * </p>
 *
 * @author generate
 * @since 2019-12-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="UaaGroupPermission对象", description="组-权限信息")
@Entity
@Table(name = "uaa_group_permission", catalog = "组-权限信息")
public class UaaGroupPermission extends BaseDomain {

    private static final long serialVersionUID = 1L;

    public static final String GROUP_ID = "group_id";
    public static final String PERMISSION_ID = "permission_id";

    @ApiModelProperty(name = "group_id", value = "")
    @Column(name = "group_id")
    private String groupId;

    @ApiModelProperty(name = "permission_id", value = "")
    @Column(name = "permission_id")
    private String permissionId;


}
