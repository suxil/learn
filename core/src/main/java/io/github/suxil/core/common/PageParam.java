package io.github.suxil.core.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * post请求分页参数
 */
@Data
public class PageParam {

    @ApiParam("页号")
    @JsonIgnore
    private Long page = 1L;

    @ApiParam("每页大小")
    @JsonIgnore
    private Long size = 10L;

}
