package com.learn.api.modal;

import lombok.Data;

import java.util.Map;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/5/27 0027 22:28
 */
@Data
public class Components {

    private Map<String, String> schemas; //  	Map[string, Schema Object | Reference Object] 	An object to hold reusable Schema Objects.
    private Map<String, Response> responses; //  	Map[string, Response Object | Reference Object] 	An object to hold reusable Response Objects.
    private Map<String, Parameter> parameters; //  	Map[string, Parameter Object | Reference Object] 	An object to hold reusable Parameter Objects.
    private Map<String, Example> examples; //  	Map[string, Example Object | Reference Object] 	An object to hold reusable Example Objects.
    private Map<String, RequestBody> requestBodies; //  	Map[string, Request Body Object | Reference Object] 	An object to hold reusable Request Body Objects.
    private Map<String, Header> headers; //  	Map[string, Header Object | Reference Object] 	An object to hold reusable Header Objects.
    private Map<String, SecurityScheme> securitySchemes; //  	Map[string, Security Scheme Object | Reference Object] 	An object to hold reusable Security Scheme Objects.
    private Map<String, Link> links; //  	Map[string, Link Object | Reference Object] 	An object to hold reusable Link Objects.
    private Map<String, Callback> callbacks; //  	Map[string, Callback Object | Reference Object] 	An object to hold reusable Callback Objects.

}
