package com.aop.featureflag;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class FeatureEnabledAspect {

    private final FeatureToggleService featureToggleService;

    public FeatureEnabledAspect(FeatureToggleService featureToggleService) {
        this.featureToggleService = featureToggleService;
    }

    @Pointcut("@annotation(featureEnabled)")
    public void featureEnabledMethod(FeatureEnabled featureEnabled) {}


    @Around(value = "featureEnabledMethod(featureEnabled)", argNames = "jp,featureEnabled")
    public Object logBeforeExecutingFeature(ProceedingJoinPoint jp, FeatureEnabled featureEnabled) throws Throwable {
        String methodName = jp.getSignature().getName();
        System.out.println("Executing method : " + methodName);

        if(featureToggleService.isFeatureEnabled(featureEnabled.value())) {
            return jp.proceed();
        } 

        throw new UnsupportedOperationException("Feature disabled or doesn't exist");
    }
}
