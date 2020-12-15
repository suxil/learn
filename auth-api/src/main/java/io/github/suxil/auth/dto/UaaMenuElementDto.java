package io.github.suxil.auth.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 菜单页面元素信息
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UaaMenuElementDto对象", description="菜单页面元素信息")
public class UaaMenuElementDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "menu_id", value = "菜单id")
    private String menuId;

    @ApiModelProperty(name = "seq", value = "序号")
    private Integer seq;

    @ApiModelProperty(name = "menu_element_code", value = "菜单元素代码")
    private String menuElementCode;

    @ApiModelProperty(name = "menu_element_name", value = "菜单元素名称")
    private String menuElementName;

    @ApiModelProperty(name = "description", value = "描述")
    private String description;

    private Integer deleted;
    private Long version;


}
