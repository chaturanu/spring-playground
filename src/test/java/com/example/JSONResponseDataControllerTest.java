package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;

/**
 * Created by chaturanu on 2/19/17.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(JSONResponseDataController.class)
public class JSONResponseDataControllerTest {

    @Autowired
    private MockMvc mvc;


    @Test
    public void testJsonResponseWithJsonPath() throws Exception {

        this.mvc.perform(
                get("/simple-object")
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", is("Dwayne")))
                .andExpect(jsonPath("$.lastName", is("Johnson")));
    }

    @Test
    public void testJsonArrayResponseWithJsonPath() throws Exception {

        this.mvc.perform(
                get("/array")
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstName", is("Dwayne")))
                .andExpect(jsonPath("$[0].lastName", is("Johnson")))
                .andExpect(jsonPath("$[1].firstName", is("John")))
                .andExpect(jsonPath("$[1].lastName", is("Cena")));
    }
}
