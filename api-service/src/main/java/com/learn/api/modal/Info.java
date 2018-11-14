package com.learn.api.modal;

import lombok.Data;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/5/27 0027 21:31
 */
@Data
public class Info {

    private String title; // 	string 	REQUIRED. The title of the application.
    private String description; // 	string 	A short description of the application. CommonMark syntax MAY be used for rich text representation.
    private String termsOfService; // 	string 	A URL to the Terms of Service for the API. MUST be in the format of a URL.
    private Contact contact; // 	Contact Object 	The contact information for the exposed API.
    private License license; // 	License Object 	The license information for the exposed API.
    private String version; // 	string 	REQUIRED. The version of the OpenAPI document (which is distinct from the OpenAPI Specification version or the API implementation version).

}
