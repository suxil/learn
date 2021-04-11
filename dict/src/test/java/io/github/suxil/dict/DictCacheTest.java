package io.github.suxil.dict;

import io.github.suxil.dict.common.DictDataGenerate;
import io.github.suxil.dict.support.DefaultDictCache;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class DictCacheTest {

    /**
     * 缓存数据字典
     */
    @Test
    public void cacheTest() {
        DictCache dictCache = new DefaultDictCache();

        List<Dict> dictList = DictDataGenerate.initListDictData();

        String key = "DICT";

        dictCache.update(key, dictList);

        String category = "TEST";
        List<Dict> cache = dictCache.get(key, category);

        Assert.assertEquals(cache.size(), 2);

        category = "TEST2";
        cache = dictCache.get(key, category);

        Assert.assertEquals(cache.size(), 1);

        category = "TEST3";
        cache = dictCache.get(key, category);

        Assert.assertNull(cache);
    }

}
