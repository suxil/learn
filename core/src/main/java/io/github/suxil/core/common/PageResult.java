package io.github.suxil.core.common;

import lombok.Data;

import java.util.List;

/**
 * 请求分页响应结果
 */
@Data
public class PageResult<T> {

    /**
     * 总页数
     */
    private Long totalPages;
    /**
     * 总数量
     */
    private Long totalCount;
    /**
     * 数据内容,泛型内容
     */
    private List<T> list;
    /**
     * 分页参数-页码
     */
    private Long page = 1L;
    /**
     * 分页参数-每页行数
     */
    private Long size = 10L;

}
