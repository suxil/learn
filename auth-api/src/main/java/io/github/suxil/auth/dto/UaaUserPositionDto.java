package io.github.suxil.auth.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 用户-岗位信息
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UaaUserPositionDto对象", description="用户-岗位信息")
public class UaaUserPositionDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "user_id", value = "")
    private String userId;

    @ApiModelProperty(name = "position_id", value = "")
    private String positionId;

    @ApiModelProperty(name = "main_position", value = "是否主岗 1：是 0：否")
    private Integer mainPosition;

    private Integer deleted;
    private Long version;


}
