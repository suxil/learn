package io.github.suxil.service.domain.cdm;

import java.math.BigDecimal;
import io.github.suxil.mybatis.domain.BaseDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * <p>
 * 数据字典
 * </p>
 *
 * @author generate
 * @since 2021-04-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="CdmDict", description="数据字典")
@Entity
@Table(name = "cdm_dict", catalog = "数据字典")
public class CdmDict extends BaseDomain {

    private static final long serialVersionUID = 1L;

    public static final String SEQ = "seq";
    public static final String CATEGORY_ID = "category_id";
    public static final String DICT_CODE = "dict_code";
    public static final String DICT_NAME = "dict_name";
    public static final String REMARK = "remark";

    @ApiModelProperty(name = "seq", value = "序号")
    @Column(name = "seq")
    private Integer seq;

    @ApiModelProperty(name = "categoryId", value = "类型id")
    @Column(name = "category_id")
    private String categoryId;

    @ApiModelProperty(name = "dictCode", value = "代码")
    @Column(name = "dict_code")
    private String dictCode;

    @ApiModelProperty(name = "dictName", value = "名称")
    @Column(name = "dict_name")
    private String dictName;

    @ApiModelProperty(name = "remark", value = "备注")
    @Column(name = "remark")
    private String remark;


}
