package io.github.suxil.core.constance;

/**
 * Application constants.
 */
public final class Constants {

    // Regex for acceptable logins
    public static final String LOGIN_REGEX = "^[_.@A-Za-z0-9-]*$";

    public static final String SYSTEM_ACCOUNT = "system";
    public static final String DEFAULT_LANGUAGE = "zh_CN";
    public static final String UFT8 = "UTF-8";
    public static final String ACCESS_TOKEN = "X-Access-Token";
    public static final String ACCESS_TOKEN_PREFIX = "Bearer ";

    private Constants() {
    }

}
