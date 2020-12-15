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
 * 用户-岗位表
 * </p>
 *
 * @author generate
 * @since 2020-04-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="UaaUserPosition对象", description="用户-岗位表")
@Entity
@Table(name = "uaa_user_position", catalog = "用户-岗位表")
public class UaaUserPosition extends BaseDomain {

    private static final long serialVersionUID = 1L;

    public static final String USER_ID = "user_id";
    public static final String POSITION_ID = "position_id";
    public static final String MAIN_POSITION = "main_position";

    @ApiModelProperty(name = "user_id", value = "")
    @Column(name = "user_id")
    private String userId;

    @ApiModelProperty(name = "position_id", value = "")
    @Column(name = "position_id")
    private String positionId;

    @ApiModelProperty(name = "main_position", value = "是否主岗 1：是 0：否")
    @Column(name = "main_position")
    private Integer mainPosition;


}
