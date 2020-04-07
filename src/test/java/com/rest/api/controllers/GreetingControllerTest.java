package com.rest.api.controllers;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GreetingControllerTest {


    @Bean
    public TestRestTemplate testRestTemplate() {
        return new TestRestTemplate();
    }

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void greeting_test(){
        ResponseEntity<String> result = testRestTemplate.getForEntity("/greeting",String.class);
        Assert.assertNotNull(result);
        Assert.assertEquals(HttpStatus.OK,result.getStatusCode());

        Assert.assertEquals("Hello World",result.getBody().toString());
    }


}
