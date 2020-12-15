package io.github.suxil.core.util;

import com.thoughtworks.xstream.XStream;

public final class XmlUtils {

    private static final XStream xStream = new XStream();

    private XmlUtils() {
    }

    /**
     * 回调接口
     * @param <T>
     */
    public interface XmlCallback<T> {
        T doInXml(XStream xStream);
    }

    /**
     * 模板方法
     * @param action
     * @param <T>
     * @return
     */
    public static <T> T execute(XmlCallback action) {
        return (T) action.doInXml(xStream);
    }

    public static <T> T getObject(XmlCallback action) {

        return null;
    }

    public static <T> T getObject(String fileName) {
        return execute((xStream) -> {

            return xStream.fromXML("");
        });
    }

}
