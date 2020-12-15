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
 * 用户-角色表
 * </p>
 *
 * @author generate
 * @since 2020-04-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="UaaUserRole对象", description="用户-角色表")
@Entity
@Table(name = "uaa_user_role", catalog = "用户-角色表")
public class UaaUserRole extends BaseDomain {

    private static final long serialVersionUID = 1L;

    public static final String USER_ID = "user_id";
    public static final String ROLE_ID = "role_id";

    @ApiModelProperty(name = "user_id", value = "")
    @Column(name = "user_id")
    private String userId;

    @ApiModelProperty(name = "role_id", value = "")
    @Column(name = "role_id")
    private String roleId;


}
