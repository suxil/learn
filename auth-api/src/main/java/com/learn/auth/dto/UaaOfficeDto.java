package com.learn.auth.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 组织信息
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UaaOfficeDto对象", description="组织信息")
public class UaaOfficeDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "parent_id", value = "父组织id")
    private String parentId;

    @ApiModelProperty(name = "seq", value = "序号")
    private Integer seq;

    @ApiModelProperty(name = "level", value = "组织层级")
    private Integer level;

    @ApiModelProperty(name = "full_path", value = "组织全路径")
    private String fullPath;

    @ApiModelProperty(name = "office_name", value = "组织名称")
    private String officeName;

    @ApiModelProperty(name = "description", value = "描述")
    private String description;

    private Integer deleted;
    private Long version;


}
