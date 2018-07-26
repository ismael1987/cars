package com.cars.demo.view;

import com.cars.demo.model.Color;
import com.cars.demo.service.RepositoryServices;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(controllers = ColorView.class)
@WebAppConfiguration
class ColorViewTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ColorView colorView;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private ColorView getColorView;

    @Mock
    private RepositoryServices repositoryServices;

    @Mock
    private Model model;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getcolor() throws Exception{

        Color color1 = new Color();
        color1.setId(1L);
        color1.setDescription("red");

        Color color2 = new Color();
        color2.setId(2L);
        color2.setDescription("blue");

        when(colorView.getcolors()).thenReturn(Arrays.asList(color1,color2));

        mockMvc.perform(MockMvcRequestBuilders.get("/colors"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(view().name("color"))
                .andExpect(model().attribute("colors", hasSize(2)))
                .andExpect(MockMvcResultMatchers.model().attributeExists("colors"))
                .andExpect(model().attribute("colors",hasItem(
                        allOf(
                                hasProperty("id",is(1L)),
                                hasProperty("description" ,  is("red"))
                        )
                )))
                .andExpect(model().attribute("colors",hasItem(
                        allOf(
                                hasProperty("id",is(2L)),
                                hasProperty("description" ,  is("blue"))
                        )
                )))
                .andDo(print());

    }



}