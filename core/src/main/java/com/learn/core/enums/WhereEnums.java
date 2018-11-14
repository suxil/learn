package com.learn.core.enums;

/**
 * Created by Administrator on 2017/5/18 0018.
 */
public enum WhereEnums implements IEnum<String> {
    EQ("");

    private String description;

    WhereEnums(String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }

}
