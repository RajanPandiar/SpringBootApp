package com.test.gluecode;


import org.springframework.stereotype.Component;

import com.test.context.TestContext;

@Component
public class ValidationSteps {

    public void validateBank(String bank) {

        String response = TestContext.getContext().getResponse();
        assert response.contains(bank):"bank details not found";

    }

}
