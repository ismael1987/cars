package com.cars.demo.view;

import com.cars.demo.model.Fuel;
import com.cars.demo.repository.FuelRepository;
import com.cars.demo.service.RepositoryServices;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mortbay.jetty.webapp.WebAppContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.context.WebApplicationContext;


import java.lang.reflect.Array;
import java.util.Arrays;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(controllers = FuelView.class)
@WebAppConfiguration
public class FuelViewTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private FuelView fuelViewMock;


    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private FuelView getFuelViewMock;

    @Mock
    private RepositoryServices repositoryServices;

    @Mock
    private Model model;


    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getfuel() throws Exception{



        Fuel fuel1 = new Fuel();
        fuel1.setId(1L);
        fuel1.setFueltype("Benzin");


        Fuel fuel2 = new Fuel();
        fuel2.setId(2L);
        fuel2.setFueltype("Gaz");

        when(fuelViewMock.getFuels()).thenReturn(Arrays.asList(fuel1,fuel2));


        mockMvc.perform(MockMvcRequestBuilders.get("/fuel"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(view().name("fuel"))
                .andExpect(model().attribute("fuels", hasSize(2)))
                .andExpect(MockMvcResultMatchers.model().attributeExists("fuels"))
                .andExpect(model().attribute("fuels",hasItem(
                        allOf(
                        hasProperty("id",is(1L)),
                        hasProperty("fueltype" ,  is("Benzin"))
                        )
                )))
                .andExpect(model().attribute("fuels",hasItem(
                        allOf(
                                hasProperty("id",is(2L)),
                                hasProperty("fueltype" ,  is("Gaz"))
                        )
                )))
                .andDo(print());

    }





}