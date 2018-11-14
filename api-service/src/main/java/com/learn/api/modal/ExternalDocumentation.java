package com.learn.api.modal;

import lombok.Data;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/5/27 0027 21:49
 */
@Data
public class ExternalDocumentation {

    private String description; //  	string 	A short description of the target documentation. CommonMark syntax MAY be used for rich text representation.
    private String url; //  	string 	REQUIRED. The URL for the target documentation. Value MUST be in the format of a URL.

}
