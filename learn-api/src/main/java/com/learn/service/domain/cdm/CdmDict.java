package com.learn.service.domain.cdm;

import java.math.BigDecimal;
import com.learn.mybatis.domain.BaseDomain;
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
 * @since 2019-11-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="CdmDict对象", description="数据字典")
@Entity
@Table(name = "cdm_dict", catalog = "数据字典")
public class CdmDict extends BaseDomain {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "seq", value = "序号")
    @Column(name = "seq")
    private BigDecimal seq;

    @ApiModelProperty(name = "category", value = "类别")
    @Column(name = "category")
    private String category;

    @ApiModelProperty(name = "dict_code", value = "代码")
    @Column(name = "dict_code")
    private String dictCode;

    @ApiModelProperty(name = "dict_name", value = "名称")
    @Column(name = "dict_name")
    private String dictName;

    @ApiModelProperty(name = "remark", value = "备注")
    @Column(name = "remark")
    private String remark;


}
