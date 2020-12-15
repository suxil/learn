package io.github.suxil.core.dict;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

public interface DictFactory {

    List<DictMetadata> convertWaitMetadata(@NotNull List<Object> dataList, @NotNull List<DictMetadata> dictMetadataList);

    List<DictMetadata> convertMapWaitMetadata(@NotNull List<Map> dataList, @NotNull List<DictMetadata> dictMetadataList);

    void loadData(@NotNull List<DictMetadata> dictMetadataList);

    <T> List<T> convert(@NotNull List<Map> dataList, @NotNull List<DictMetadata> dictMetadataList, Class<T> typeClass);

    List<Map> convertMap(@NotNull List<Map> dataList, @NotNull List<DictMetadata> dictMetadataList);

}
