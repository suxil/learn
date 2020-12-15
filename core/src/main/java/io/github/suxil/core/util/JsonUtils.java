package io.github.suxil.core.util;

import com.google.gson.Gson;

/**
 * Created by Administrator on 2017/9/16 0016.
 */
public final class JsonUtils {

    private static Gson gson = new Gson();

    private JsonUtils() {
    }

    public static String toJson(Object src) {
        return gson.toJson(src);
    }

    public static <T> T fromJson(String json, Class<T> classOfT) {
        return gson.fromJson(json, classOfT);
    }

}
