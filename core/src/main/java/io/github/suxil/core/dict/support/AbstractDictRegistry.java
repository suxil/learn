package io.github.suxil.core.dict.support;

import io.github.suxil.core.dict.Dict;
import io.github.suxil.core.dict.DictRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public abstract class AbstractDictRegistry implements DictRegistry {

    private final ConcurrentMap<String, Dict> cacheMap = new ConcurrentHashMap<>();

    @Override
    public void save(List<Dict> dictList) {
        synchronized (cacheMap) {
            dictList.forEach(item -> {
                cacheMap.put(item.getKey(), item);
            });
        }
    }

    @Override
    public Dict get(String key) {
        return cacheMap.get(key);
    }

    @Override
    public List<Dict> getByCategory(String category) {
        List<Dict> dictList = new ArrayList<>();
        synchronized (cacheMap) {
            cacheMap.forEach((key, value) -> {
                if (key.startsWith(category)) {
                    dictList.add(value);
                }
            });
        }
        return dictList;
    }

    @Override
    public boolean delete(String key) {
        Dict dict = cacheMap.remove(key);
        return dict != null;
    }

    @Override
    public boolean isExist(String key) {
        return cacheMap.containsKey(key);
    }

}
