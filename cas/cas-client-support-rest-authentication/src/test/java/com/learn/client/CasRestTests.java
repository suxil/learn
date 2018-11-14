package com.learn.client;

import com.learn.client.utils.RestAuthUtils;
import org.jasig.cas.client.util.URIBuilder;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertNotNull;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/9/18 0018 13:36
 */
public class CasRestTests {

    String username = "linxi";
    String password = "123456";
    String service = "http://cas.client.org:8990";

    @Test
    public void createUser() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> tgtResult = RestAuthUtils.createTgt(restTemplate, username, password, service);

        if (tgtResult.getStatusCode() == HttpStatus.CREATED) {
            String tgt = tgtResult.getBody();

            ResponseEntity<String> stResult = RestAuthUtils.createSt(restTemplate, tgt, service);

            System.out.println(tgtResult.getBody());
            System.out.println(stResult.getBody());

            assertNotNull(tgtResult.getBody());
            assertNotNull(stResult.getBody());
        }
    }

    @Test
    public void createSt() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> stResult = RestAuthUtils.createSt(restTemplate, username, password, service);

        System.out.println(stResult.getBody());

        ResponseEntity<String> responseEntity = RestAuthUtils.validate(restTemplate, service, stResult.getBody());

        System.out.println(responseEntity.getBody());

        assertNotNull(stResult.getBody());
    }

    @Test
    public void testUrl() {
        URIBuilder builder = new URIBuilder("http://localhost:8080/cas")
                .addParameter("ticket", "ticket")
                .addParameter("service", service);

        System.out.println(builder.toString());

        assertNotNull(builder.toString());
    }

    @Test
    public void testServiceUrl() {
        String str = "";
        int i = service.indexOf("?");

        int j = service.lastIndexOf("/");
        int a = service.lastIndexOf("0");
        int l = service.length();
        if (service.indexOf("?") < 0 && service.lastIndexOf("/") != service.length() - 1) {
            str = service + "/";
        }

        System.out.println(str);

        assertNotNull(str);
    }

}
