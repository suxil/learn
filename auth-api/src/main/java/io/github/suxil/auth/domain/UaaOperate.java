package io.github.suxil.auth.domain;

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
 * 操作表(系统启动自动记录所有后台接口，不需要手工操作)
 * </p>
 *
 * @author generate
 * @since 2020-04-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="UaaOperate对象", description="操作表(系统启动自动记录所有后台接口，不需要手工操作)")
@Entity
@Table(name = "uaa_operate", catalog = "操作表(系统启动自动记录所有后台接口，不需要手工操作)")
public class UaaOperate extends BaseDomain {

    private static final long serialVersionUID = 1L;

    public static final String SEQ = "seq";
    public static final String SERVICE_NAME = "service_name";
    public static final String OPERATE_TYPE = "operate_type";
    public static final String OPERATE_URL = "operate_url";
    public static final String OPERATE_CODE = "operate_code";
    public static final String OPERATE_NAME = "operate_name";
    public static final String OPERATE_PARAM = "operate_param";
    public static final String DESCRIPTION = "description";

    @ApiModelProperty(name = "seq", value = "序号")
    @Column(name = "seq")
    private Integer seq;

    @ApiModelProperty(name = "service_name", value = "服务名称")
    @Column(name = "service_name")
    private String serviceName;

    @ApiModelProperty(name = "operate_type", value = "操作类型")
    @Column(name = "operate_type")
    private String operateType;

    @ApiModelProperty(name = "operate_url", value = "操作url")
    @Column(name = "operate_url")
    private String operateUrl;

    @ApiModelProperty(name = "operate_code", value = "操作代码")
    @Column(name = "operate_code")
    private String operateCode;

    @ApiModelProperty(name = "operate_name", value = "操作名称")
    @Column(name = "operate_name")
    private String operateName;

    @ApiModelProperty(name = "operate_param", value = "参数")
    @Column(name = "operate_param")
    private String operateParam;

    @ApiModelProperty(name = "description", value = "描述")
    @Column(name = "description")
    private String description;


}
