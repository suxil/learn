package io.github.suxil.dict;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 字典缓存
 */
public interface DictCache {

    /**
     * 更新某个类型的字典
     * @param dictList
     */
    void update(@NotNull String key, @NotNull List<Dict> dictList);

    /**
     * 获取某个类型的字典
     * @param category
     * @return
     */
    List<Dict> get(@NotNull String key, @NotNull String category);

    /**
     * 删除某个类型的字典
     * @param category
     * @return
     */
    boolean delete(@NotNull String key, @NotNull String category);

}
