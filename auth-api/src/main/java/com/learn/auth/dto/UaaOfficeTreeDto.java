package com.learn.auth.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Title:
 * Description:
 * date: 2020/1/1 11:23
 *
 * @author suxi
 * @version V1.0
 */
@Data
@ApiModel(value="组织机构树对象")
public class UaaOfficeTreeDto implements Serializable {

    private String id;

    @ApiModelProperty(name = "parent_id", value = "父组织id")
    private String parentId;

    @ApiModelProperty(name = "seq", value = "序号")
    private Integer seq;

    @ApiModelProperty(name = "level", value = "组织层级")
    private Integer level;

    @ApiModelProperty(name = "office_code", value = "组织代码")
    private String officeCode;

    @ApiModelProperty(name = "office_name", value = "组织名称")
    private String officeName;

    @ApiModelProperty(name = "children", value = "子节点")
    private List<UaaOfficeTreeDto> children;

}
