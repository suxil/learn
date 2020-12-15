package io.github.suxil.auth.domain;

import io.github.suxil.mybatis.domain.BaseDomain;
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
 * 用户-权限表
 * </p>
 *
 * @author generate
 * @since 2020-04-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="UaaUserPermission对象", description="用户-权限表")
@Entity
@Table(name = "uaa_user_permission", catalog = "用户-权限表")
public class UaaUserPermission extends BaseDomain {

    private static final long serialVersionUID = 1L;

    public static final String USER_ID = "user_id";
    public static final String PERMISSION_ID = "permission_id";

    @ApiModelProperty(name = "user_id", value = "")
    @Column(name = "user_id")
    private String userId;

    @ApiModelProperty(name = "permission_id", value = "")
    @Column(name = "permission_id")
    private String permissionId;


}
