package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.Collections;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by chaturanu on 2/22/17.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(AlbumController.class)
public class AlbumControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AlbumRepository repository;

    @Test
    public void testCreate() throws Exception {
        MockHttpServletRequestBuilder request = post("/album")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"XYZ\"}");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", equalTo("XYZ") ));

        verify(this.repository).save(any(AlbumEntity.class));
    }


    @Test
    public void testFindAll() throws Exception {
        AlbumEntity album = new AlbumEntity();
        album.setName("FOO");
        album.setBandName("BAR");

        when(this.repository.findAll()).thenReturn(Collections.singletonList(album));

        MockHttpServletRequestBuilder request = get("/album")
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", equalTo("FOO") ))
                .andExpect(jsonPath("$[0].bandName", equalTo("BAR") ));
    }
}
