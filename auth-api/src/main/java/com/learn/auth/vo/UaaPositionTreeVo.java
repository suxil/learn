package com.learn.auth.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * Title:
 * Description:
 * date: 2020/1/1 19:37
 *
 * @author suxi
 * @version V1.0
 */
@Data
@Accessors(chain = true)
@ApiModel(value="岗位树对象")
public class UaaPositionTreeVo implements Serializable {

    private String id;

    @ApiModelProperty(name = "parent_id", value = "父岗位id")
    private String parentId;

    @ApiModelProperty(name = "seq", value = "序号")
    private Integer seq;

    @ApiModelProperty(name = "level", value = "岗位层级")
    private Integer level;

    @ApiModelProperty(name = "position_code", value = "岗位代码")
    private String positionCode;

    @ApiModelProperty(name = "position_name", value = "岗位名称")
    private String positionName;

    @ApiModelProperty(name = "children", value = "子节点")
    private List<UaaPositionTreeVo> children;

}
