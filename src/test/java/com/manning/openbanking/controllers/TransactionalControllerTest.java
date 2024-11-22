package com.manning.openbanking.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doReturn;

import com.manning.openbanking.OpenbankingApplication;
import com.manning.openbanking.entities.Transaction;
import com.manning.openbanking.services.TransactionService;


@AutoConfigureMockMvc
@SpringBootTest(classes = OpenbankingApplication.class)
public class TransactionalControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TransactionService transactionService;


    // @Test
    // public void testTransactionControllerIntegration() throws Exception {
    //     doReturn(List.of(new Transaction())).when(transactionService).findAllByAccountNumber(anyInt());

    //     mockMvc.perform(get("/api/transactions/123456789").contentType(MediaType.APPLICATION_JSON))

    //     .andExpect(status().isOk())
    //         .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    //         .andExpect(jsonPath("$[*]date", notNullValue())) // todos las tranasaction con valor en date
    //         .andExpect(jsonPath("$[*]id", notNullValue())); // todos las tranasaction con valor en date
            
    // }
}
