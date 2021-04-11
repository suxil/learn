package io.github.suxil.service.dto.cdm;

import io.github.suxil.core.common.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 时间片段
 * </p>
 *
 * @author generate
 * @since 2021-04-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="CdmTimeSegmentDto对象", description="时间片段")
public class CdmTimeSegmentDto extends PageParam implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    @ApiModelProperty(name = "hour", value = "时辰")
    private String hour;

    @ApiModelProperty(name = "zodiac", value = "生肖")
    private String zodiac;

    @ApiModelProperty(name = "segment", value = "小时片段")
    private String segment;

    @ApiModelProperty(name = "description", value = "描述")
    private String description;

    private Integer deleted;
    private Long version;


}
