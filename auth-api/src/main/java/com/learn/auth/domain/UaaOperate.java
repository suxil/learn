package com.learn.auth.domain;

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
 * 操作信息
 * </p>
 *
 * @author generate
 * @since 2019-12-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="UaaOperate对象", description="操作信息")
@Entity
@Table(name = "uaa_operate", catalog = "操作信息")
public class UaaOperate extends BaseDomain {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "seq", value = "序号")
    @Column(name = "seq")
    private Integer seq;

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
