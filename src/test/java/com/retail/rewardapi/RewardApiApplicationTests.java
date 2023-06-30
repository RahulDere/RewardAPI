package com.retail.rewardapi;

import com.retail.rewardapi.service.RewardApiService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(locations = "/test-context.xml")
public class RewardApiApplicationTests {

	@Autowired
	@Qualifier("rewardApiTestService")
	private RewardApiService rewardApiService;

	@Test
	void contextLoads() {
	}

}
