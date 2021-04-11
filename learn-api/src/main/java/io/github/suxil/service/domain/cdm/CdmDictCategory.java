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
 * 数据字典类型
 * </p>
 *
 * @author generate
 * @since 2021-04-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="CdmDictCategory", description="数据字典类型")
@Entity
@Table(name = "cdm_dict_category", catalog = "数据字典类型")
public class CdmDictCategory extends BaseDomain {

    private static final long serialVersionUID = 1L;

    public static final String PARENT_ID = "parent_id";
    public static final String SEQ = "seq";
    public static final String CATEGORY_CODE = "category_code";
    public static final String CATEGORY_NAME = "category_name";
    public static final String REMARK = "remark";

    @ApiModelProperty(name = "parentId", value = "父节点id")
    @Column(name = "parent_id")
    private String parentId;

    @ApiModelProperty(name = "seq", value = "序号")
    @Column(name = "seq")
    private BigDecimal seq;

    @ApiModelProperty(name = "categoryCode", value = "类型代码")
    @Column(name = "category_code")
    private String categoryCode;

    @ApiModelProperty(name = "categoryName", value = "类型名称")
    @Column(name = "category_name")
    private String categoryName;

    @ApiModelProperty(name = "remark", value = "备注")
    @Column(name = "remark")
    private String remark;


}
