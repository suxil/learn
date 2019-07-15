package com.learn.api.domain.tem;

import com.learn.core.common.BaseDomain;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author luxq
 * @since 2019-07-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="TemWorkLog对象", description="")
public class TemWorkLog extends BaseDomain {

    private static final long serialVersionUID = 1L;

    private String category;

    private String content;

    private LocalDateTime endDate;

    private String noteTaker;

    private LocalDateTime startDate;

    private LocalDateTime workDate;

    private Integer workHours;


}
