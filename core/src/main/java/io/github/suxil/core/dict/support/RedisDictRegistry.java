package io.github.suxil.core.dict.support;

import io.github.suxil.core.dict.Dict;
import io.github.suxil.core.dict.DictRegistry;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import javax.validation.constraints.NotNull;
import java.util.List;

public class RedisDictRegistry implements DictRegistry {

    private final String split = ":";
    private final RedisTemplate redisTemplate;
    private final HashOperations<String, String, Dict> hashOperations;

    public RedisDictRegistry(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(@NotNull List<Dict> dictList) {

    }

    @Override
    public Dict get(@NotNull String key) {
        if (key.contains(split)) {
            String[] keyInfo = key.split(split);
            if (keyInfo.length == 2) {
                return hashOperations.get(keyInfo[0], keyInfo[1]);
            }
        }
        return null;
    }

    @Override
    public List<Dict> getByCategory(@NotNull String category) {

        return null;
    }

    @Override
    public boolean delete(@NotNull String key) {
        if (key.contains(split)) {
            String[] keyInfo = key.split(split);
            if (keyInfo.length == 2) {
                long size = hashOperations.delete(keyInfo[0], keyInfo[1]);
                return size > 0;
            }
        }
        return false;
    }

    @Override
    public boolean isExist(@NotNull String key) {
        Dict dict = get(key);
        return dict != null;
    }

}
