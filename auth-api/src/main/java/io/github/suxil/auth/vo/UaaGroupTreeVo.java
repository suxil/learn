package io.github.suxil.auth.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * Title:
 * Description:
 * date: 2020/1/1 19:28
 *
 * @author suxi
 * @version V1.0
 */
@Data
@Accessors(chain = true)
@ApiModel(value="组树对象")
public class UaaGroupTreeVo implements Serializable {

    private String id;

    @ApiModelProperty(name = "parent_id", value = "父组id")
    private String parentId;

    @ApiModelProperty(name = "seq", value = "序号")
    private Integer seq;

    @ApiModelProperty(name = "level", value = "组层级")
    private Integer level;

    @ApiModelProperty(name = "group_code", value = "组代码")
    private String groupCode;

    @ApiModelProperty(name = "group_name", value = "组名称")
    private String groupName;

    @ApiModelProperty(name = "children", value = "子节点")
    private List<UaaGroupTreeVo> children;

}
