package io.github.suxil.service.domain.cdm;

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
 * 时间片段
 * </p>
 *
 * @author generate
 * @since 2021-04-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="CdmTimeSegment", description="时间片段")
@Entity
@Table(name = "cdm_time_segment", catalog = "时间片段")
public class CdmTimeSegment extends BaseDomain {

    private static final long serialVersionUID = 1L;

    public static final String HOUR = "hour";
    public static final String ZODIAC = "zodiac";
    public static final String SEGMENT = "segment";
    public static final String DESCRIPTION = "description";

    @ApiModelProperty(name = "hour", value = "时辰")
    @Column(name = "hour")
    private String hour;

    @ApiModelProperty(name = "zodiac", value = "生肖")
    @Column(name = "zodiac")
    private String zodiac;

    @ApiModelProperty(name = "segment", value = "小时片段")
    @Column(name = "segment")
    private String segment;

    @ApiModelProperty(name = "description", value = "描述")
    @Column(name = "description")
    private String description;


}
