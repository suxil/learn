package io.github.suxil.auth.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 组-用户信息
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UaaGroupUserDto对象", description="组-用户信息")
public class UaaGroupUserDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "group_id", value = "")
    private String groupId;

    @ApiModelProperty(name = "user_id", value = "")
    private String userId;

    private Integer deleted;
    private Long version;


}
