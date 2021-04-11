package io.github.suxil.dict.support;

import io.github.suxil.dict.Dict;
import lombok.Data;

@Data
public class DictImpl implements Dict {

    private String key;
    private Integer seq;
    private String category;
    private String code;
    private String name;
    private String remark;

}
