package com.learn.api.domain.tem;

import com.learn.core.common.BaseDomain;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
@ApiModel(value="TemSelfRecord对象", description="")
public class TemSelfRecord extends BaseDomain {

    private static final long serialVersionUID = 1L;

    private String content;


}
