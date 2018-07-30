package com.cars.demo.view;

import com.cars.demo.model.Country;
import com.cars.demo.model.State;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(controllers = StateView.class)
@WebAppConfiguration
public class StateViewTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StateView stateView;

    @Mock
    private RepositoryServices repositoryServices;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Mock
    private Model model;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    @Test
    public void getState() {
        Country country = new Country();
        country.setId(1L);
        country.setCountryName("Austria");


        State state1 = new State();
        state1.setId(1L);
        state1.setStateName("Vienna");
        state1.setCountry(country);

        State state2 = new State();
        state2.setId(2L);
        state2.setStateName("Nieder Österreich");
        state2.setCountry(country);

/*

        when(stateView.getState()).thenReturn(Arrays.asList(gear1,gear2));

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
                .andExpect(model().attribute("gears",hasItem(
                        allOf(
                                hasProperty("id",is(2L)),
                                hasProperty("geartype" ,  is("manual"))
                        )
                )))




*/


    }
}