package com.cars.demo.view;

import com.cars.demo.model.Gear;
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
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(controllers = GearView.class)
@WebAppConfiguration
public class GearViewTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private GearView gearView;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private GearView getGearView;

    @Mock
    private RepositoryServices repositoryServices;

    @Mock
    private Model model;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }



    @Test
    public void getgear() throws Exception{
        Gear gear1 = new Gear();
        gear1.setId(1L);
        gear1.setGeartype("auto");

        Gear gear2= new Gear();
        gear2.setId(2L);
        gear2.setGeartype("manual");

        when(gearView.getGears()).thenReturn(Arrays.asList(gear1,gear2));

        mockMvc.perform(MockMvcRequestBuilders.get("/gear"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(view().name("gear"))
                .andExpect(model().attribute("gears", hasSize(2)))
                .andExpect(MockMvcResultMatchers.model().attributeExists("gears"))
                .andExpect(model().attribute("gears",hasItem(
                        allOf(
                                hasProperty("id",is(1L)),
                                hasProperty("geartype" ,  is("auto"))
                        )
                )))
                .andExpect(model().attribute("gearsgit",hasItem(
                        allOf(
                                hasProperty("id",is(2L)),
                                hasProperty("geartype" ,  is("manual"))
                        )
                )))
                .andDo(print());
    }
}