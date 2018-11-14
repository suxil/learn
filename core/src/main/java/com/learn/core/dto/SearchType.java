package com.learn.core.dto;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/4/13 0013 17:22
 */
public class SearchType {

    public SearchType() {
        search = false;
        left = "";
        right = "";
    }

    private Boolean search; // 是否匹配到查询后缀
    private String field; // 字段名称
    private String type; // 查询类型
    private String left; // 左模糊查询
    private String right; // 右模糊查询

    public Boolean getSearch() {
        return search;
    }

    public void setSearch(Boolean search) {
        this.search = search;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }
}
