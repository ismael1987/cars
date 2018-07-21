package com.cars.demo.view;

import com.cars.demo.model.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
class ColorViewTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;


    @SpyBean
    private ColorView colorView;


    private String endpoint = "/color";

    private String url;

    @BeforeEach
    void before() {
        url = "http://localhost:" + port + endpoint;
     }

    @Test
    void getcolor() {
        ResponseEntity<Color[]> response = restTemplate.getForEntity(url, Color[].class);
        //List<Color> psets = Arrays.asList(response.getBody());
        //assertEquals(2,psets.size());
        //verify(colorView).getcolor();
    }

}