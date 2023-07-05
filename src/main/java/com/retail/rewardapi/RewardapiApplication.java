package com.retail.rewardapi;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.retail.rewardapi"})
@RequiredArgsConstructor
public class RewardapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RewardapiApplication.class, args);
	}

}
