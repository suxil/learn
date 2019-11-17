package com.learn.service.domain.tem;

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
 * 自己的生活记录
 * </p>
 *
 * @author generate
 * @since 2019-11-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="TemSelfRecord对象", description="自己的生活记录")
@Entity
@Table(name = "tem_self_record", catalog = "自己的生活记录")
public class TemSelfRecord extends BaseDomain {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "content", value = "内容")
    @Column(name = "content")
    private String content;


}
