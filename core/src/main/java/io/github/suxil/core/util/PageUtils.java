package io.github.suxil.core.util;

import com.github.pagehelper.PageInfo;
import io.github.suxil.core.common.PageResult;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class PageUtils {

    private PageUtils() {
    }

    /**
     * 分页信息转换
     * @param pageInfo
     * @return
     */
    public static PageResult pageInfoToPageResult(PageInfo pageInfo) {
        PageResult pageResult = new PageResult<>();
        pageResult.setPage((long) pageInfo.getPageNum());
        pageResult.setSize((long) pageInfo.getPageSize());
        pageResult.setTotalCount(pageInfo.getTotal());
        pageResult.setTotalPages((pageInfo.getTotal() + (long) pageInfo.getPageSize() - 1) / (long) pageInfo.getPageSize());
        return pageResult;
    }

}
