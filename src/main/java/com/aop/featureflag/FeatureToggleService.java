package com.aop.featureflag;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class FeatureToggleService {

    private final Map<String, Boolean> featureFlags = Map.of(
            "feature1", true,
            "feature2", true
    );

    public boolean isFeatureEnabled(String featureName) {
        return featureFlags.getOrDefault(featureName, false);
    }
}
