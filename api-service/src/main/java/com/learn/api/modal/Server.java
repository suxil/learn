package com.learn.api.modal;

import lombok.Data;

import java.util.Map;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/5/27 0027 21:34
 */
@Data
public class Server {

    private String url; // 	string 	REQUIRED. A URL to the target host. This URL supports Server Variables and MAY be relative, to indicate that the host location is relative to the location where the OpenAPI document is being served. Variable substitutions will be made when a variable is named in {brackets}.
    private String description; // 	string 	An optional string describing the host designated by the URL. CommonMark syntax MAY be used for rich text representation.
    private Map<String, ServerVariable> variables; // 	Map[string, Server Variable Object] 	A map between a variable name and its value. The value is used for substitution in the server's URL template.

}
