package io.github.suxil.auth.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 操作-权限息
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UaaOperatePermissionDto对象", description="操作-权限息")
public class UaaOperatePermissionDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "operate_id", value = "")
    private String operateId;

    @ApiModelProperty(name = "permission_id", value = "")
    private String permissionId;

    private Integer deleted;
    private Long version;


}
