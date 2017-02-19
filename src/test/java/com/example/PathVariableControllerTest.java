package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by chaturanu on 2/19/17.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(PathVariableController.class)

public class PathVariableControllerTest {

    @Autowired
    private MockMvc mvc;

    private String book = "Animal Farm";
    private int chapter = 20;

    @Test
    public void testIndividualPathVarEndpoint() throws Exception {

        this.mvc.perform(get(String.format("/book/%s/chapter/%s", book, chapter)))
                .andExpect(status().isOk())
                .andExpect(content().string("book:" + book + " chapter:" + chapter));
    }

    @Test
    public void testMapPathVarEndpoint() throws Exception {
        this.mvc.perform(get(String.format("/book/%s/chapter/map/%s", book, chapter)))
                .andExpect(status().isOk())
                .andExpect(content().string("{book=" + book + ", chapter="+chapter+"}"));
    }

    @Test
    public void testObjectPathVarEndpoint() throws Exception {
        this.mvc.perform(get(String.format("/book/%s/chapter/object/%d", book, chapter)))
                .andExpect(status().isOk())
                .andExpect(content().string("book is " + book + "; chapter is " + chapter));
    }

}
