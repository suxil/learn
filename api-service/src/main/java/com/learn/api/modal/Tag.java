package com.learn.api.modal;

import lombok.Data;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/5/27 0027 22:09
 */
@Data
public class Tag {

    private String name; //  	string 	REQUIRED. The name of the tag.
    private String description; //  	string 	A short description for the tag. CommonMark syntax MAY be used for rich text representation.
    private ExternalDocumentation externalDocs; //  	External Documentation Object 	Additional external documentation for this tag.

}
