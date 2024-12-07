package com.aop.featureflag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
public class FeatureflagApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeatureflagApplication.class, args);
	}
}
