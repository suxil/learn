package com.learn.service.domain.zyj;

import java.math.BigDecimal;
import com.learn.core.common.BaseDomain;
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
 * 六十四卦爻信息
 * </p>
 *
 * @author generate
 * @since 2019-11-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="ZyjSixtyFourGuaItem对象", description="六十四卦爻信息")
@Entity
@Table(name = "zyj_sixty_four_gua_item", catalog = "六十四卦爻信息")
public class ZyjSixtyFourGuaItem extends BaseDomain {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "sixty_four_gua_id", value = "")
    @Column(name = "sixty_four_gua_id")
    private String sixtyFourGuaId;

    @ApiModelProperty(name = "seq", value = "爻序")
    @Column(name = "seq")
    private BigDecimal seq;

    @ApiModelProperty(name = "yao_name", value = "爻名")
    @Column(name = "yao_name")
    private String yaoName;

    @ApiModelProperty(name = "yao_chi", value = "爻辞")
    @Column(name = "yao_chi")
    private String yaoChi;

    @ApiModelProperty(name = "yao_chi_note", value = "爻辞解释")
    @Column(name = "yao_chi_note")
    private String yaoChiNote;

    @ApiModelProperty(name = "xiang_yue", value = "象辞")
    @Column(name = "xiang_yue")
    private String xiangYue;

    @ApiModelProperty(name = "xiang_yue_note", value = "象辞解释")
    @Column(name = "xiang_yue_note")
    private String xiangYueNote;


}
