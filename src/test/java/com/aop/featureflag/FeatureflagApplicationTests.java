package com.aop.featureflag;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FeatureflagApplicationTests {

	@Autowired
	private FeaturesService featuresService;

	@Test
	void contextLoads() {
		featuresService.featureOne();
		featuresService.featureTwo();
	}

}
