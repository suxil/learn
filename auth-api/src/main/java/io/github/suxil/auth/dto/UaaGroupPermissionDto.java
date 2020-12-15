package io.github.suxil.auth.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 组-权限信息
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UaaGroupPermissionDto对象", description="组-权限信息")
public class UaaGroupPermissionDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "group_id", value = "")
    private String groupId;

    @ApiModelProperty(name = "permission_id", value = "")
    private String permissionId;

    private Integer deleted;
    private Long version;


}
