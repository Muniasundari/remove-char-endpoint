package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DemoController.class)
public class DemoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testValidStrings() throws Exception {
        mockMvc.perform(get("/remove").param("input", "eloquent"))
                .andExpect(status().isOk())
                .andExpect(content().string("loquen"));

        mockMvc.perform(get("/remove").param("input", "country"))
                .andExpect(status().isOk())
                .andExpect(content().string("ountr"));
    }

    @Test
    void testTwoCharacterString() throws Exception {
        mockMvc.perform(get("/remove").param("input", "ab"))
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    void testLessThanTwoCharacter() throws Exception {
        mockMvc.perform(get("/remove").param("input", "a"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testSpecialChars() throws Exception {
        mockMvc.perform(get("/remove").param("input", "123%qwerty+"))
                .andExpect(status().isOk())
                .andExpect(content().string("123_%qwerty"));
    }
}