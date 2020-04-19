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
 * 组-用户表
 * </p>
 *
 * @author generate
 * @since 2020-04-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="UaaGroupUser对象", description="组-用户表")
@Entity
@Table(name = "uaa_group_user", catalog = "组-用户表")
public class UaaGroupUser extends BaseDomain {

    private static final long serialVersionUID = 1L;

    public static final String GROUP_ID = "group_id";
    public static final String USER_ID = "user_id";

    @ApiModelProperty(name = "group_id", value = "")
    @Column(name = "group_id")
    private String groupId;

    @ApiModelProperty(name = "user_id", value = "")
    @Column(name = "user_id")
    private String userId;


}
