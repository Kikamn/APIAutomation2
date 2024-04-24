package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.ApiPages;

public class ApiStep {
    ApiPages apiPages;

    public ApiStep(){
        this.apiPages = new ApiPages();
    }

    //@Given("Prepare URL valid for get list data")
    //public void prepareURLValidForGetListData() {
    //    apiPages.validateURL();
    //}

    @Given("Prepare URL valid for {string}")
    public void prepareURLValidFor(String URL) {
        apiPages.prepareURLValidFor(URL);
    }

    @And("Hit API get list data")
    public void hitAPIGetListData() {
        apiPages.hitAPIGetListData();
    }

    @Then("Validation status code is equals {int}")
    public void validationStatusCodeIsEquals(int status_code) {
        apiPages.validationStatusCodeIsEquals(status_code);
    }

    @Then("Validation response body get list user")
    public void validationResponseBodyGetListUser() {
        apiPages.validationResponseBodyGetListUser();
    }

    @Then("Validation response json whit JSONSchema {string}")
    public void validationResponseJsonWhitJSONSchema(String fileName) {
        apiPages.validationResponseJsonWhitJSONSchema();
    }

}
