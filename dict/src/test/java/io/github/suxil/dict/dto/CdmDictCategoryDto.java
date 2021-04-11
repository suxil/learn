package io.github.suxil.dict.dto;

import io.github.suxil.core.common.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 数据字典类型
 * </p>
 *
 * @author generate
 * @since 2021-04-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="CdmDictCategoryDto对象", description="数据字典类型")
public class CdmDictCategoryDto extends PageParam implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    @ApiModelProperty(name = "parentId", value = "父节点id")
    private String parentId;

    @ApiModelProperty(name = "seq", value = "序号")
    private Integer seq;

    @ApiModelProperty(name = "categoryCode", value = "类型代码")
    private String categoryCode;

    @ApiModelProperty(name = "categoryName", value = "类型名称")
    private String categoryName;

    @ApiModelProperty(name = "remark", value = "备注")
    private String remark;

    private Integer deleted;
    private Long version;

    private List<CdmDictCategoryDto> children;


}
