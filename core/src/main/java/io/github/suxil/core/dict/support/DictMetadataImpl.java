package io.github.suxil.core.dict.support;

import io.github.suxil.core.dict.Dict;
import io.github.suxil.core.dict.DictMetadata;
import lombok.Data;

import java.util.List;

@Data
public class DictMetadataImpl implements DictMetadata {

    private String category;
    private String fieldName;
    private String targetFieldName;
    private List<String> waitLoadCode;
    private List<Dict> dictList;

}
