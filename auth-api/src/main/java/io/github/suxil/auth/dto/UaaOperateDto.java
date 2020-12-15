package io.github.suxil.auth.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 操作信息
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UaaOperateDto对象", description="操作信息")
public class UaaOperateDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "seq", value = "序号")
    private Integer seq;

    @ApiModelProperty(name = "service_name", value = "服务名称")
    private String serviceName;

    @ApiModelProperty(name = "operate_type", value = "操作类型")
    private String operateType;

    @ApiModelProperty(name = "operate_url", value = "操作url")
    private String operateUrl;

    @ApiModelProperty(name = "operate_code", value = "操作代码")
    private String operateCode;

    @ApiModelProperty(name = "operate_name", value = "操作名称")
    private String operateName;

    @ApiModelProperty(name = "operate_param", value = "参数")
    private String operateParam;

    @ApiModelProperty(name = "description", value = "描述")
    private String description;

    private Integer deleted;
    private Long version;


}
