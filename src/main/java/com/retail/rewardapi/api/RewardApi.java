package com.retail.rewardapi.api;

import com.retail.rewardapi.model.RewardTransaction;
import com.retail.rewardapi.service.RewardApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/retail")
public class RewardApi {

    @Autowired
    private final RewardApiService rewardApiService;

    @Autowired
    public RewardApi(RewardApiService rewardApiService) {
        this.rewardApiService = rewardApiService;
    }

    @GetMapping("/rewards/{customerId}")
    public Long getRewardPointsByCustomerId(@PathVariable("customerId") Long Id) {
        return rewardApiService.getRewardPointsByCustomerId(Id);
    }

    @GetMapping("/rewards")
    public List<String> getRewards() {
        return rewardApiService.getRewards();
    }

    @GetMapping("/transactions")
    public List<RewardTransaction> getTransactions() {
        return rewardApiService.getTransactions();
    }

}
