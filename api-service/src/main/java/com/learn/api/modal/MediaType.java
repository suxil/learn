package com.learn.api.modal;

import lombok.Data;

import java.util.Map;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/5/27 0027 21:59
 */
@Data
public class MediaType {

    private String schema; //  	Schema Object | Reference Object 	The schema defining the type used for the request body.
    private String example; //  	Any 	Example of the media type. The example object SHOULD be in the correct format as specified by the media type. The example field is mutually exclusive of the examples field. Furthermore, if referencing a schema which contains an example, the example value SHALL override the example provided by the schema.
    private Map<String, Example> examples; //  	Map[ string, Example Object | Reference Object] 	Examples of the media type. Each example object SHOULD match the media type and specified schema if present. The examples field is mutually exclusive of the example field. Furthermore, if referencing a schema which contains an example, the examples value SHALL override the example provided by the schema.
    private Map<String, Encoding> encoding; //  	Map[string, Encoding Object] 	A map between a property name and its encoding information. The key, being the property name, MUST exist in the schema as a property. The encoding object SHALL only apply to requestBody objects when the media type is multipart or application/x-www-form-urlencoded.

}
