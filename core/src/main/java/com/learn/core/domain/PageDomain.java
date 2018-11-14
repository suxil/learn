package com.learn.core.domain;

import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/5/5 0005 21:50
 */
public class PageDomain<T extends BaseDomain> {

    private PageDomain(Page<T> page) {
        this.rows = page.getContent();
        this.total = page.getTotalElements();
    }

    public static <T> PageDomain initPage(Page<T> page) {
        return new PageDomain(page);
    }

    private List<T> rows;
    private long total;

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

}
