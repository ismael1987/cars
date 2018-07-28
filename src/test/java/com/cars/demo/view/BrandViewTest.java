package com.cars.demo.view;

import com.cars.demo.model.Brand;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(controllers = BrandView.class)
@WebAppConfiguration
public class BrandViewTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BrandView brandViewMoc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private BrandView getBrandView;

    @Mock
    private RepositoryServices repositoryServices;

    @Mock
    private Model model;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getbrand() throws Exception {

        Brand brand1 = new Brand();
        brand1.setId(1L);
        brand1.setBrandName("bmw");

        Brand brand2 = new Brand();
        brand2.setId(2L);
        brand2.setBrandName("mazda");

        when(brandViewMoc.getbrands()).thenReturn(Arrays.asList(brand1,brand2));

        mockMvc.perform(MockMvcRequestBuilders.get("/brand"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(view().name("brand"))
                .andExpect(model().attribute("brands", hasSize(2)))
                .andExpect(MockMvcResultMatchers.model().attributeExists("brands"))
                .andExpect(model().attribute("brands",hasItem(
                        allOf(
                                hasProperty("id",is(1L)),
                                hasProperty("brandName" ,  is("bmw"))
                        )
                )))
                .andExpect(model().attribute("brands",hasItem(
                        allOf(
                                hasProperty("id",is(2L)),
                                hasProperty("brandName" ,  is("mazda"))
                        )
                )))
                .andDo(print());
    }
}