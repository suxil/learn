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
 * 六十四卦爻信息
 * </p>
 *
 * @author luxq
 * @since 2019-08-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="ZyjSixtyFourGuaItem对象", description="六十四卦爻信息")
public class ZyjSixtyFourGuaItem extends BaseDomain {

    private static final long serialVersionUID = 1L;

    private String sixtyFourGuaId;

    @ApiModelProperty(value = "爻序")
    private BigDecimal seq;

    @ApiModelProperty(value = "爻名")
    private String yaoName;

    @ApiModelProperty(value = "爻辞")
    private String yaoChi;

    @ApiModelProperty(value = "爻辞解释")
    private String yaoChiNote;

    @ApiModelProperty(value = "象辞")
    private String xiangYue;

    @ApiModelProperty(value = "象辞解释")
    private String xiangYueNote;

    @ApiModelProperty(value = "组织机构")
    private String officeCode;


}
