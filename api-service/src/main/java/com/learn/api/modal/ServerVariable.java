package com.learn.api.modal;

import lombok.Data;

import java.util.List;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/5/27 0027 21:34
 */
@Data
public class ServerVariable {

    private List<String> enums; //  	[string] 	An enumeration of string values to be used if the substitution options are from a limited set.
    private String defaults; // 	string 	REQUIRED. The default value to use for substitution, and to send, if an alternate value is not supplied. Unlike the Schema Object's default, this value MUST be provided by the consumer.
    private String description; // 	string 	An optional description for the server variable. CommonMark syntax MAY be used for rich text representation.

}
