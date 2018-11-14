package com.learn.api.modal;

import lombok.Data;

import java.util.Map;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/5/27 0027 22:16
 */
@Data
public class Link {

    private String operationRef; //  	string 	A relative or absolute reference to an OAS operation. This field is mutually exclusive of the operationId field, and MUST point to an Operation Object. Relative operationRef values MAY be used to locate an existing Operation Object in the OpenAPI definition.
    private String operationId; //  	string 	The name of an existing, resolvable OAS operation, as defined with a unique operationId. This field is mutually exclusive of the operationRef field.
    private Map<String, String> parameters; //  	Map[string, Any | ] 	A map representing parameters to pass to an operation as specified with operationId or identified via operationRef. The key is the parameter name to be used, whereas the value can be a constant or an expression to be evaluated and passed to the linked operation. The parameter name can be qualified using the parameter location [{in}.]{name} for operations that use the same parameter name in different locations (e.g. path.id).
    private String requestBody; //  	Any | 	A literal value or to use as a request body when calling the target operation.
    private String description; //  	string 	A description of the link. CommonMark syntax MAY be used for rich text representation.
    private Server server; //  	Server Object 	A server object to be used by the target operation.

}
