package com.retail.rewardapi.service;

import com.retail.rewardapi.model.RewardTransaction;
import com.retail.rewardapi.repository.RewardTransactionRepository;
import com.retail.rewardapi.util.RewardUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class RewardApiService {

   private final List<RewardTransaction> rewardTransactionList;

   @Autowired
   private final RewardTransactionRepository rewardTransactionRepository;

   public RewardApiService(RewardTransactionRepository rewardTransactionRepository) {
       this.rewardTransactionRepository = rewardTransactionRepository;

       rewardTransactionList = new ArrayList<>();

       RewardTransaction rt1 = new RewardTransaction(1L,
               1000L, "Rahul Dere", 100L, LocalDate.of(2023, 6, 28));

       RewardTransaction rt2 = new RewardTransaction(2L,
               1001L, "Rahul Kadu", 100L, LocalDate.of(2023, 6, 27));

       RewardTransaction rt3 = new RewardTransaction(3L,
               1002L, "Ravi Kumar", 60L, LocalDate.of(2023, 6, 27));

       RewardTransaction rt4 = new RewardTransaction(4L,
               1003L, "Mattew Mike", 400L, LocalDate.of(2023, 6, 26));

       RewardTransaction rt5 = new RewardTransaction(5L,
               1004L, "Shruti Kopad", 155L, LocalDate.of(2023, 6, 28));

       RewardTransaction rt6 = new RewardTransaction(6L,
               1005L, "Simran Singh", 225L, LocalDate.of(2023, 6, 29));

       rewardTransactionList.addAll(Arrays.asList(rt1, rt2, rt3, rt4, rt5, rt6));

   }
    
    public Long getRewardPointsByCustomerId(Long customerId) {

       Long totalTransactionAmount = rewardTransactionList.stream().filter(x -> x.getCustomerId().equals(customerId))
                .map(x -> x.getTransactionAmount())
                .reduce(0L, Long::sum);

       return RewardUtil.getTotalRewardPointsbyCustomer(totalTransactionAmount);
    }

    public List<String> getRewards() {

       List<String> rewardList = new ArrayList<>();
       rewardList.add(" CustomerID " + " CustomerName " + " RewardPoints ");
       for (RewardTransaction rt : rewardTransactionList) {
            String reward = rt.getCustomerId() + "    " + rt.getCustomerName() + "     " +
                               RewardUtil.getTotalRewardPointsbyCustomer(rt.getTransactionAmount());
            rewardList.add(reward);
        }
        return rewardList;
    }

    public List<RewardTransaction> getTransactions() {
        List<RewardTransaction> rewardTransactionList = new ArrayList<>();
        rewardTransactionRepository.findAll()
                .forEach(rewardTransaction -> rewardTransactionList.add(rewardTransaction));
        return rewardTransactionList;
    }

}
