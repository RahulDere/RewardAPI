package com.retail.rewardapi.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.retail.rewardapi.model.RewardTransaction;
import com.retail.rewardapi.service.RewardApiService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = RewardApi.class)
class RewardApiTest {

    private static final String END_POINT_PATH = "/api/retail/";
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private RewardApiService rewardApiService;

    @Test
    void getRewardsById() throws Exception {
        Long transactionId = 1L;
        String requestURI = END_POINT_PATH + "rewards/";

        RewardTransaction rt1 = new RewardTransaction(1L,
                1000L, "Rahul Dere", 120L, LocalDate.of(2023, 6, 28));

        Mockito.when(rewardApiService.getRewardPointsByCustomerId(transactionId)).thenReturn(90L);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(requestURI + "1")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))

                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals("90", mvcResult.getResponse().getContentAsString());
    }

    @Test
    void getRewards() throws Exception {
        String requestURI = END_POINT_PATH + "rewards";

        String rt1 = " CustomerID " + " CustomerName " + " RewardPoints ";
        String rt2 = " 1001L " + " Rahul Kumar " + " 130L ";

        List<String> rewardsList = List.of(rt1, rt2);

        Mockito.when(rewardApiService.getRewards()).thenReturn(rewardsList);

        mockMvc.perform(MockMvcRequestBuilders.get(requestURI)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andDo(print());
    }

    @Test
    void getTransactions() throws Exception {

        String requestURI = END_POINT_PATH + "/" + "transactions";

        RewardTransaction rt1 = new RewardTransaction(1L,
                1000L, "Rahul Dere", 120L, LocalDate.of(2023, 6, 28));

        RewardTransaction rt2 = new RewardTransaction(1L,
                1001L, "Rahul Kumar", 140L, LocalDate.of(2023, 6, 28));

        List<RewardTransaction> rewardTransactionList = List.of(rt1, rt2);

        Mockito.when(rewardApiService.getTransactions()).thenReturn(rewardTransactionList);

        mockMvc.perform(MockMvcRequestBuilders.get(requestURI)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].customerName",equalTo("Rahul Dere")))
                .andExpect(jsonPath("$[0].transactionAmount",equalTo(120)))
                .andDo(print());
    }
}