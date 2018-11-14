package com.learn.api.modal;

import lombok.Data;

import java.util.List;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/5/27 0027 22:23
 */
@Data
public class PathItem {

    private String ref; //  	string 	Allows for an external definition of this path item. The referenced structure MUST be in the format of a Path Item Object. If there are conflicts between the referenced definition and this Path Item's definition, the behavior is undefined.
    private String summary; // 	string 	An optional, string summary, intended to apply to all operations in this path.
    private String description; // 	string 	An optional, string description, intended to apply to all operations in this path. CommonMark syntax MAY be used for rich text representation.
    private Operation get; //  	Operation Object 	A definition of a GET operation on this path.
    private Operation put; //  	Operation Object 	A definition of a PUT operation on this path.
    private Operation post; //  	Operation Object 	A definition of a POST operation on this path.
    private Operation delete; //  	Operation Object 	A definition of a DELETE operation on this path.
    private Operation options; //  	Operation Object 	A definition of a OPTIONS operation on this path.
    private Operation head; //  	Operation Object 	A definition of a HEAD operation on this path.
    private Operation patch; //  	Operation Object 	A definition of a PATCH operation on this path.
    private Operation trace; //  	Operation Object 	A definition of a TRACE operation on this path.
    private List<Server> servers; // 	[Server Object] 	An alternative server array to service all operations in this path.
    private List<Parameter> parameters; // 	[Parameter Object | Reference Object] 	A list of parameters that are applicable for all the operations described under this path. These parameters can be overridden at the operation level, but cannot be removed there. The list MUST NOT include duplicated parameters. A unique parameter is defined by a combination of a name and location. The list can use the Reference Object to link to parameters that are defined at the OpenAPI Object's components/parameters.

}
