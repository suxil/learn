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
 * 六十四卦
 * </p>
 *
 * @author generate
 * @since 2019-11-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="ZyjSixtyFourGua对象", description="六十四卦")
@Entity
@Table(name = "zyj_sixty_four_gua", catalog = "六十四卦")
public class ZyjSixtyFourGua extends BaseDomain {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "seq", value = "卦序")
    @Column(name = "seq")
    private BigDecimal seq;

    @ApiModelProperty(name = "up_seq", value = "上卦卦序")
    @Column(name = "up_seq")
    private BigDecimal upSeq;

    @ApiModelProperty(name = "up_name", value = "上卦卦名")
    @Column(name = "up_name")
    private String upName;

    @ApiModelProperty(name = "down_seq", value = "下卦卦序")
    @Column(name = "down_seq")
    private BigDecimal downSeq;

    @ApiModelProperty(name = "down_name", value = "下卦卦名")
    @Column(name = "down_name")
    private String downName;

    @ApiModelProperty(name = "gua_name", value = "卦名")
    @Column(name = "gua_name")
    private String guaName;

    @ApiModelProperty(name = "gua_yi", value = "卦的含义")
    @Column(name = "gua_yi")
    private String guaYi;

    @ApiModelProperty(name = "gua_note", value = "解释")
    @Column(name = "gua_note")
    private String guaNote;

    @ApiModelProperty(name = "gua_qian", value = "卦签")
    @Column(name = "gua_qian")
    private String guaQian;

    @ApiModelProperty(name = "gua_chi", value = "卦辞")
    @Column(name = "gua_chi")
    private String guaChi;

    @ApiModelProperty(name = "gua_chi_note", value = "卦辞解释")
    @Column(name = "gua_chi_note")
    private String guaChiNote;

    @ApiModelProperty(name = "xiang_yue", value = "象辞")
    @Column(name = "xiang_yue")
    private String xiangYue;

    @ApiModelProperty(name = "xiang_yue_note", value = "象辞解释")
    @Column(name = "xiang_yue_note")
    private String xiangYueNote;

    @ApiModelProperty(name = "tuan_yue", value = "彖传")
    @Column(name = "tuan_yue")
    private String tuanYue;

    @ApiModelProperty(name = "tuan_yue_note", value = "彖传解释")
    @Column(name = "tuan_yue_note")
    private String tuanYueNote;

    @ApiModelProperty(name = "qi_shi", value = "启示")
    @Column(name = "qi_shi")
    private String qiShi;


}
