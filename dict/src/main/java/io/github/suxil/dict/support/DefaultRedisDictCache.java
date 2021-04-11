package io.github.suxil.dict.support;

import io.github.suxil.dict.Dict;
import io.github.suxil.dict.DictCache;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import javax.validation.constraints.NotNull;
import java.util.List;

public class DefaultRedisDictCache implements DictCache {

    private final String split = ":";
    private final RedisTemplate redisTemplate;
    private final HashOperations<String, String, Dict> hashOperations;

    public DefaultRedisDictCache(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void update(@NotNull String key, @NotNull List<Dict> dictList) {

    }

    @Override
    public List<Dict> get(@NotNull String key, @NotNull String category) {
        return null;
    }

    @Override
    public boolean delete(@NotNull String key, @NotNull String category) {
        return false;
    }
}
