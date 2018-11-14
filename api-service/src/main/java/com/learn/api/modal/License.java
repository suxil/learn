package com.learn.api.modal;

import lombok.Data;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/5/27 0027 21:33
 */
@Data
public class License {

    private String name; // 	string 	REQUIRED. The license name used for the API.
    private String url; // 	string 	A URL to the license used for the API. MUST be in the format of a URL.

}
