package com.learn.api.modal;

import lombok.Data;

import java.util.Map;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/5/27 0027 21:58
 */
@Data
public class RequestBody {

    private String description; //  	string 	A brief description of the request body. This could contain examples of use. CommonMark syntax MAY be used for rich text representation.
    private Map<String, MediaType> content; //  	Map[string, Media Type Object] 	REQUIRED. The content of the request body. The key is a media type or media type range and the value describes it. For requests that match multiple keys, only the most specific key is applicable. e.g. text/plain overrides text/*
    private boolean required; //  	boolean 	Determines if the request body is required in the request. Defaults to false.

}
