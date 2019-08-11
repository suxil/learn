package com.learn.api.domain.zyj;

import com.learn.core.common.BaseDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * <p>
 * 六十四卦
 * </p>
 *
 * @author luxq
 * @since 2019-08-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="ZyjSixtyFourGua对象", description="六十四卦")
public class ZyjSixtyFourGua extends BaseDomain {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "卦序")
    private BigDecimal seq;

    @ApiModelProperty(value = "上卦卦序")
    private BigDecimal upSeq;

    @ApiModelProperty(value = "上卦卦名")
    private String upName;

    @ApiModelProperty(value = "下卦卦序")
    private BigDecimal downSeq;

    @ApiModelProperty(value = "下卦卦名")
    private String downName;

    @ApiModelProperty(value = "卦名")
    private String guaName;

    @ApiModelProperty(value = "卦的含义")
    private String guaYi;

    @ApiModelProperty(value = "解释")
    private String guaNote;

    @ApiModelProperty(value = "卦签")
    private String guaQian;

    @ApiModelProperty(value = "卦辞")
    private String guaChi;

    @ApiModelProperty(value = "卦辞解释")
    private String guaChiNote;

    @ApiModelProperty(value = "象辞")
    private String xiangYue;

    @ApiModelProperty(value = "象辞解释")
    private String xiangYueNote;

    @ApiModelProperty(value = "彖传")
    private String tuanYue;

    @ApiModelProperty(value = "彖传解释")
    private String tuanYueNote;

    @ApiModelProperty(value = "启示")
    private String qiShi;

    @ApiModelProperty(value = "组织机构")
    private String officeCode;


}
