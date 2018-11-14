package com.learn.api.modal;

import lombok.Data;

import java.util.Map;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/5/27 0027 21:40
 */
@Data
public class Parameter {

    private String name; // 	string 	REQUIRED. The name of the parameter. Parameter names are case sensitive.
        // If in is "path", the name field MUST correspond to the associated path segment from the path field in the Paths Object. See Path Templating for further information.
        // If in is "header" and the name field is "Accept", "Content-Type" or "Authorization", the parameter definition SHALL be ignored.
        // For all other cases, the name corresponds to the parameter name used by the in property.
    private String in; //  	string 	REQUIRED. The location of the parameter. Possible values are "query", "header", "path" or "cookie".
    private String description; //  	string 	A brief description of the parameter. This could contain examples of use. CommonMark syntax MAY be used for rich text representation.
    private boolean required; //  	boolean 	Determines whether this parameter is mandatory. If the parameter location is "path", this property is REQUIRED and its value MUST be true. Otherwise, the property MAY be included and its default value is false.
    private boolean deprecated; //  	boolean 	Specifies that a parameter is deprecated and SHOULD be transitioned out of usage.
    private boolean allowEmptyValue; //  	boolean 	Sets the ability to pass empty-valued parameters. This is valid only for query parameters and allows sending a parameter with an empty value. Default value is false. If style is used, and if behavior is n/a (cannot be serialized), the value of allowEmptyValue SHALL be ignored.

    private String style; //  	string 	Describes how the parameter value will be serialized depending on the type of the parameter value. Default values (based on value of in): for query - form; for path - simple; for header - simple; for cookie - form.
    private boolean explode; //  	boolean 	When this is true, parameter values of type array or object generate separate parameters for each value of the array or key-value pair of the map. For other types of parameters this property has no effect. When style is form, the default value is true. For all other styles, the default value is false.
    private boolean allowReserved; //  	boolean 	Determines whether the parameter value SHOULD allow reserved characters, as defined by RFC3986 :/?#[]@!$&'()*+,;= to be included without percent-encoding. This property only applies to parameters with an in value of query. The default value is false.
    private String schema; //  	Schema Object | Reference Object 	The schema defining the type used for the parameter.
    private String example; //  	Any 	Example of the media type. The example SHOULD match the specified schema and encoding properties if present. The example field is mutually exclusive of the examples field. Furthermore, if referencing a schema which contains an example, the example value SHALL override the example provided by the schema. To represent examples of media types that cannot naturally be represented in JSON or YAML, a string value can contain the example with escaping where necessary.
    private Map<String, Example> examples; //  	Map[ string, Example Object | Reference Object] 	Examples of the media type. Each example SHOULD contain a value in the correct format as specified in the parameter encoding. The examples field is mutually exclusive of the example field. Furthermore, if referencing a schema which contains an example, the examples value SHALL override the example provided by the schema.

    private Map<String, MediaType> content; //  	Map[string, Media Type Object] 	A map containing the representations for the parameter. The key is the media type and the value describes it. The map MUST only contain one entry.

    //matrix; //  	primitive, array, object 	path 	Path-style parameters defined by RFC6570
    //label; //  	primitive, array, object 	path 	Label style parameters defined by RFC6570
    //form; //  	primitive, array, object 	query, cookie 	Form style parameters defined by RFC6570. This option replaces collectionFormat with a csv (when explode is false) or multi (when explode is true) value from OpenAPI 2.0.
    //simple; //  	array 	path, header 	Simple style parameters defined by RFC6570. This option replaces collectionFormat with a csv value from OpenAPI 2.0.
    //spaceDelimited; //  	array 	query 	Space separated array values. This option replaces collectionFormat equal to ssv from OpenAPI 2.0.
    //pipeDelimited; //  	array 	query 	Pipe separated array values. This option replaces collectionFormat equal to pipes from OpenAPI 2.0.
    //deepObject; //  	object 	query 	Provides a simple way of rendering nested objects using form parameters.

}
