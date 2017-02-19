package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 * Created by chaturanu on 2/19/17.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(FormDataController.class)
public class FormDataControllerTest {

    @Autowired
    private MockMvc mvc;

    private int productId = 123;
    private double cost = 13.55;
    private String purchasedBy = "Jimmy";

    @Test
    public void testPostingFormData() throws Exception {
        MockHttpServletRequestBuilder postRequest = post("/individual-example")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("productId", Integer.toString(productId))
                .param("cost", Double.toString(cost))
                .param("purchasedBy", purchasedBy);

        this.mvc.perform(postRequest)
                .andExpect(status().isOk())
                .andExpect(content().string(String.format("%s bought:%d for:%f", purchasedBy, productId, cost)));
    }

    @Test
    public void testPostingFormDataMap() throws Exception {

        MockHttpServletRequestBuilder postRequest = post("/map")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("productId", Integer.toString(productId))
                .param("cost", "13.550000")
                .param("purchasedBy", purchasedBy);

        this.mvc.perform(postRequest)
                .andExpect(status().isOk())
                .andExpect(content().string(String.format("{productId=%d, cost=%f, purchasedBy=%s}", productId, 13.550000, purchasedBy)));
    }

    @Test
    public void testPostingFormDataObj() throws Exception {

        MockHttpServletRequestBuilder postRequest = post("/object-example")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("productId", Integer.toString(productId))
                .param("cost", "13.550000")
                .param("purchasedBy", purchasedBy);

        this.mvc.perform(postRequest)
                .andExpect(status().isOk())
                .andExpect(content().string(String.format("%s bought %d for $%f", purchasedBy, productId, cost)));
    }

}
