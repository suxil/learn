package com.learn.auth.domain;

import com.learn.core.common.BaseDomain;
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
 * 组-用户信息
 * </p>
 *
 * @author generate
 * @since 2019-11-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="UaaGroupUser对象", description="组-用户信息")
@Entity
@Table(name = "uaa_group_user", catalog = "组-用户信息")
public class UaaGroupUser extends BaseDomain {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "group_id", value = "")
    @Column(name = "group_id")
    private String groupId;

    @ApiModelProperty(name = "user_id", value = "")
    @Column(name = "user_id")
    private String userId;


}
