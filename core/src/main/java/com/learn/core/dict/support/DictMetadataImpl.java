package com.learn.core.dict.support;

import com.learn.core.dict.Dict;
import com.learn.core.dict.DictMetadata;
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
