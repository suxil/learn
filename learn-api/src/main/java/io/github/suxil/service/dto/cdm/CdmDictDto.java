package io.github.suxil.service.dto.cdm;

import io.github.suxil.core.common.PageParam;
import io.github.suxil.dict.api.annotation.DictField;
import io.github.suxil.dict.api.constant.DictConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 数据字典
 * </p>
 *
 * @author generate
 * @since 2021-04-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="CdmDictDto对象", description="数据字典")
public class CdmDictDto extends PageParam implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    @ApiModelProperty(name = "seq", value = "序号")
    private Integer seq;

    @DictField(key = DictConstant.DICT_OTHER_KEY, category = DictConstant.DICT_OTHER_KEY, targetFieldName = "categoryName")
    @ApiModelProperty(name = "categoryId", value = "类型id")
    private String categoryId;

    @ApiModelProperty(name = "categoryName", value = "类型名称")
    private String categoryName;

    @ApiModelProperty(name = "dictCode", value = "代码")
    private String dictCode;

    @ApiModelProperty(name = "dictName", value = "名称")
    private String dictName;

    @ApiModelProperty(name = "remark", value = "备注")
    private String remark;

    private Integer deleted;
    private Long version;


}
