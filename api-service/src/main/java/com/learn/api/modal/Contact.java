package com.learn.api.modal;

import lombok.Data;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/5/27 0027 21:32
 */
@Data
public class Contact {

   private String name; // 	string 	The identifying name of the contact person/organization.
   private String url; // 	string 	The URL pointing to the contact information. MUST be in the format of a URL.
   private String email; // 	string 	The email address of the contact person/organization. MUST be in the format of an email address.

}
