package com.aop.featureflag;

import org.springframework.stereotype.Service;

@Service
public class FeaturesService {
    @FeatureEnabled("feature1")
    public void featureOne() {
        System.out.println("feature 1");
    }

    @FeatureEnabled("feature2")
    public void featureTwo() {
        System.out.println("feature 2");
    }
}
