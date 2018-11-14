package com.learn.core.enums;

/**
 * <p>@Title: IntelliJ IDEA.</p>
 * Description:
 * Date: 2017/1/7 0007
 * Time: 19:38
 *
 * @author Administrator
 * @version 1.0
 */
public enum NoYesEnum implements IEnum<String> {

    /**
     * 否
     */
    NO("否"),

    /**
     * 是
     */
    YES("是");

    private String description;

    NoYesEnum(String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }

}
