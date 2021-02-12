package com.test.stepDefinitions;

import javax.inject.Inject;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.stereotype.Component;

import com.test.gluecode.ApiSteps;
import com.test.gluecode.ValidationSteps;

@Component
public class stepDefinitions {

    @Inject ApiSteps apiSteps;
    @Inject ValidationSteps validationSteps;

    @Given("a user looking for details of bank")
    public void initialize() {
        apiSteps.intialize();
    }

    @When("searching for details of banks")
    public void lookingForBanks(){
        apiSteps.lookForBanks();
    }

    @When("searching for details of $bankName bank")
    public void lookForBankDetails(String bankName) {
        apiSteps.lookForABank(bankName);
    }

    @Then("the bank details of the $bankName bank is displayed")
    public void validateBankDetails(String bankName){
        validationSteps.validateBank(bankName);

    }



}
