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
 * date: 2020/1/1 19:15
 *
 * @author suxi
 * @version V1.0
 */
@Data
@Accessors(chain = true)
@ApiModel(value="角色树对象")
public class UaaRoleTreeVo implements Serializable {

    private String id;

    @ApiModelProperty(name = "parent_id", value = "父角色id")
    private String parentId;

    @ApiModelProperty(name = "seq", value = "序号")
    private Integer seq;

    @ApiModelProperty(name = "level", value = "角色层级")
    private Integer level;

    @ApiModelProperty(name = "role_code", value = "角色代码")
    private String roleCode;

    @ApiModelProperty(name = "role_name", value = "角色名称")
    private String roleName;

    @ApiModelProperty(name = "children", value = "子节点")
    private List<UaaRoleTreeVo> children;

}
