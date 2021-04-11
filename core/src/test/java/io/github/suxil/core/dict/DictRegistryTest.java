//package io.github.suxil.core.dict;
//
//import cn.hutool.core.lang.Dict;
//import io.github.suxil.dict.support.DictImpl;
//import io.github.suxil.dict.support.SimpleDictRegistry;
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//public class DictRegistryTest {
//
//    private final DictRegistry dictRegistry = new SimpleDictRegistry();
//
//    @Test
//    public void saveTest() {
//        DictImpl dict = new DictImpl();
//        dict.setKey("dict_:0");
//        dict.setCategory("");
//        dict.setCode("0");
//        dict.setName("Name0");
//        dict.setSeq(1);
//
//        dictRegistry.save(dict);
//
//        System.out.println();
//    }
//
//    @Test
//    public void saveListTest() {
//        List<Dict> dictList = new ArrayList<>();
//
//        Random random = new Random(3);
//        for (int i = 0; i < 10; i++) {
//            DictImpl dict = new DictImpl();
//
//            dict.setKey("");
//            dict.setSeq(i);
//            dict.setCategory("" + (random.nextInt() + 1));
//            dict.setCode("" + i);
//            dict.setName("Name" + i);
//
//            dictList.add(dict);
//        }
//
//        dictRegistry.save(dictList);
//
//        System.out.println();
//    }
//
//    @Test
//    public void getTest() {
//        String key = "";
//
//    }
//
//    @Test
//    public void getByCategoryTest() {
//        String category = "";
//
//    }
//
//    @Test
//    public void deleteTest() {
//        Dict dict = new DictImpl();
//
//    }
//
//    @Test
//    public void deleteKeyTest() {
//        String key = "";
//
//    }
//
//    @Test
//    public void isExistTest() {
//        String key = "";
//
//    }
//
//}
