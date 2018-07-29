package com.cars.demo.view;

import com.cars.demo.model.Country;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(controllers = CountryView.class)
@WebAppConfiguration
public class CountryViewTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CountryView countryView;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private CountryView getCountryView;

    @Mock
    private RepositoryServices repositoryServices;

    @Mock
    private Model model;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }



    @Test
    public void getcountry() throws Exception {
        Country country1 = new Country();
        country1.setId(1L);
        country1.setCountryName("austria");

        Country country2 = new Country();
        country2.setId(2L);
        country2.setCountryName("germany");

        when(countryView.getCountries()).thenReturn(Arrays.asList(country1,country2));

        mockMvc.perform(MockMvcRequestBuilders.get("/country"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(view().name("country"))
                .andExpect(model().attribute("countries", hasSize(2)))
                .andExpect(MockMvcResultMatchers.model().attributeExists("countries"))
                .andExpect(model().attribute("countries",hasItem(
                        allOf(
                                hasProperty("id",is(1L)),
                                hasProperty("countryName" ,  is("austria"))
                        )
                )))
                .andExpect(model().attribute("countries",hasItem(
                        allOf(
                                hasProperty("id",is(2L)),
                                hasProperty("countryName" ,  is("germany"))
                        )
                )))
                .andDo(print());
    }
}