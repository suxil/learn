package io.github.suxil.dict.support;

import io.github.suxil.dict.Dict;
import io.github.suxil.dict.DictCache;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class DefaultDictCache implements DictCache {

    private final ConcurrentMap<String, List<Dict>> CACHE = new ConcurrentHashMap<>();

    @Override
    public void update(@NotNull String key, @NotNull List<Dict> dictList) {
        Map<String, List<Dict>> dictMap = new HashMap<>();

        for (Dict dict : dictList) {
            String category = dict.getCategory();
            if (dictMap.containsKey(category)) {
                dictMap.get(category).add(dict);
            } else {
                List<Dict> list = new ArrayList<>();
                list.add(dict);
                dictMap.put(category, list);
            }
        }

        CACHE.putAll(dictMap);
    }

    @Override
    public List<Dict> get(@NotNull String key, @NotNull String category) {
        return CACHE.get(category);
    }

    @Override
    public boolean delete(@NotNull String key, @NotNull String category) {
        CACHE.remove(category);
        return true;
    }

}
