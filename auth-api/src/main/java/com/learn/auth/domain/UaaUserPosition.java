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
 * 用户-岗位信息
 * </p>
 *
 * @author generate
 * @since 2019-12-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="UaaUserPosition对象", description="用户-岗位信息")
@Entity
@Table(name = "uaa_user_position", catalog = "用户-岗位信息")
public class UaaUserPosition extends BaseDomain {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "user_id", value = "")
    @Column(name = "user_id")
    private String userId;

    @ApiModelProperty(name = "position_id", value = "")
    @Column(name = "position_id")
    private String positionId;

    @ApiModelProperty(name = "main_position", value = "是否主岗 1：是 0：否")
    @Column(name = "main_position")
    private Boolean mainPosition;


}
