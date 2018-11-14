package com.learn.api.modal;

import lombok.Data;

import java.util.Map;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/5/27 0027 22:15
 */
@Data
public class Response {

    private String description; //  	string 	REQUIRED. A short description of the response. CommonMark syntax MAY be used for rich text representation.
    private Map<String, Header> headers; //  	Map[string, Header Object | Reference Object] 	Maps a header name to its definition. RFC7230 states header names are case insensitive. If a response header is defined with the name "Content-Type", it SHALL be ignored.
    private Map<String, MediaType> content; //  	Map[string, Media Type Object] 	A map containing descriptions of potential response payloads. The key is a media type or media type range and the value describes it. For responses that match multiple keys, only the most specific key is applicable. e.g. text/plain overrides text/*
    private Map<String, Link> links; //  	Map[string, Link Object | Reference Object] 	A map of operations links that can be followed from the response. The key of the map is a short name for the link, following the naming constraints of the names for Component Objects.

}
