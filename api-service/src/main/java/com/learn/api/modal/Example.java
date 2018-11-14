package com.learn.api.modal;

import lombok.Data;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/5/27 0027 21:53
 */
@Data
public class Example {

    private String summary; //  	string 	Short description for the example.
    private String description; //  	string 	Long description for the example. CommonMark syntax MAY be used for rich text representation.
    private String value; //  	Any 	Embedded literal example. The value field and externalValue field are mutually exclusive. To represent examples of media types that cannot naturally represented in JSON or YAML, use a string value to contain the example, escaping where necessary.
    private String externalValue; //  	string 	A URL that points to the literal example. This provides the capability to reference examples that cannot easily be included in JSON or YAML documents. The value field and externalValue field are mutually exclusive.

}
