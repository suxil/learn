package io.github.suxil.service.domain.tem;

import java.math.BigDecimal;
import io.github.suxil.mybatis.domain.BaseDomain;
import java.time.LocalDateTime;
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
 * 工作日志
 * </p>
 *
 * @author generate
 * @since 2019-11-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="TemWorkLog对象", description="工作日志")
@Entity
@Table(name = "tem_work_log", catalog = "工作日志")
public class TemWorkLog extends BaseDomain {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "category", value = "类别")
    @Column(name = "category")
    private String category;

    @ApiModelProperty(name = "work_date", value = "工作日期")
    @Column(name = "work_date")
    private LocalDateTime workDate;

    @ApiModelProperty(name = "work_hours", value = "工作小时数")
    @Column(name = "work_hours")
    private BigDecimal workHours;

    @ApiModelProperty(name = "start_date", value = "开始日期")
    @Column(name = "start_date")
    private LocalDateTime startDate;

    @ApiModelProperty(name = "end_date", value = "结束日期")
    @Column(name = "end_date")
    private LocalDateTime endDate;

    @ApiModelProperty(name = "note_taker", value = "工作人")
    @Column(name = "note_taker")
    private String noteTaker;

    @ApiModelProperty(name = "content", value = "工作内容")
    @Column(name = "content")
    private String content;


}
