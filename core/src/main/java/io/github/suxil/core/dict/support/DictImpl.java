package io.github.suxil.core.dict.support;

import io.github.suxil.core.dict.Dict;
import lombok.Data;

@Data
public class DictImpl implements Dict {

    private String key;
    private String category;
    private Integer seq;
    private String code;
    private String name;
    private boolean exist;

}
