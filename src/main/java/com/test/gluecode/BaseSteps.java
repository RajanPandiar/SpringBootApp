package com.test.gluecode;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.BeforeScenario;
import org.springframework.stereotype.Component;

import com.test.context.TestContext;

@Component
public class BaseSteps {

    @BeforeScenario
    public void beforeScenario(){
       TestContext.init();
    }

    @AfterScenario
    public void afterScenario(){
        TestContext.clear();
    }
}
