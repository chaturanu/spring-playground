package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by chaturanu on 2/18/17.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testPatchMessageEndpoint() throws Exception {
        this.mockMvc.perform(patch("/patch"))
                .andExpect(status().isOk())
                .andExpect(content().string("PATCH"));
    }

    @Test
    public void testDeleteMessageEndpoint() throws Exception {
        this.mockMvc.perform(delete("/delete"))
                .andExpect(status().isOk())
                .andExpect(content().string("DELETE"));
    }
}
