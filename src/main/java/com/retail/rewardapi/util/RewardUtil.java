package com.retail.rewardapi.util;

import com.retail.rewardapi.model.RewardTransaction;

import java.util.List;

public class RewardUtil {

    public static Long getTotalRewardPointsbyCustomer(Long transactionAmount) {

        Long rewardPoints = 0L;
        if (transactionAmount > 100)
            rewardPoints = (transactionAmount - 100) * 2;
        else if (transactionAmount > 50)
            rewardPoints = rewardPoints + (transactionAmount - 50) * 1;

        return rewardPoints;

    }
}
