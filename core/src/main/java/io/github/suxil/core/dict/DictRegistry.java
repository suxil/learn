package io.github.suxil.core.dict;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;

public interface DictRegistry {

    default void save(@NotNull Dict dict) {
        save(Collections.singletonList(dict));
    }

    void save(@NotNull List<Dict> dictList);

    Dict get(@NotNull String key);

    List<Dict> getByCategory(@NotNull String category);

    default boolean delete(@NotNull Dict dict) {
        return delete(dict.getKey());
    }

    boolean delete(@NotNull String key);

    boolean isExist(@NotNull String key);

}
