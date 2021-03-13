package com.udacity.DogDataApi;

import com.udacity.DogDataApi.service.DogService;
import com.udacity.DogDataApi.web.DogController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@RunWith(SpringRunner.class)
@WebMvcTest(DogController.class)
public class DogControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    DogService dogService;

    @Test
    public void getAllDogNames()throws Exception{
        mockMvc.perform(get("/dogs/name/")).
                andExpect(status().isOk()).
                andExpect(content().contentType(MediaType.APPLICATION_JSON)).
                andExpect(content().json("[]"));
        verify(dogService, times(1)).retrieveDogName();
    }
}
