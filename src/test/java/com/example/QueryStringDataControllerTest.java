package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import static org.hamcrest.Matchers.is;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.Charset;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by chaturanu on 2/18/17.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(QueryStringDataController.class)
public class QueryStringDataControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testIndividualParamEndpoint() throws Exception {
        this.mockMvc.perform(get("/individual-example?filter=FOO"))
                .andExpect(status().isOk())
                .andExpect(content().string("Filter is: FOO"));
    }

    @Test
    public void testMapParamEndpoint() throws Exception {
        this.mockMvc.perform(get("/map-example?filter=BAR&owner=pinkerton"))
                .andExpect(status().isOk())
                .andExpect(content().string("{filter=BAR, owner=pinkerton}"));
    }

    @Test
    public void testObjectParamEndpoint() throws Exception {

        mockMvc.perform(get("/map-example?name=FOOBAR&age=21"))
                .andExpect(status().isOk())
                .andExpect(content().string("{name=FOOBAR, age=21}"));
    }
}
