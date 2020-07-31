package com.minibank.controller;

import com.minibank.dao.TempRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MiniBankControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
    }

//    @AfterEach
//    void tearDown() {
//    }

    @Test
    void transferMoney() throws Exception {
        mockMvc.perform(post("/minibank/transferMoney")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(getBody()))
                .andDo(print())
                .andExpect(status().isOk());

        Assertions.assertEquals(new BigDecimal("10100"), TempRepo.account1.getAmount());
        Assertions.assertEquals(new BigDecimal("9900"), TempRepo.account2.getAmount());
    }

    private String getBody() {
        return "{\n" +
                "  \"accountFrom\": \"1\",\n" +
                "  \"accountTo\": \"2\",\n" +
                "  \"amount\": \"100\"\n" +
                "}";
    }
}