package starter.JojonomicStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.JojonomicAPI.JojonomicAPI;
import starter.JojonomicAPI.JojonomicResponse;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class JojonomicSetpDef {

    @Steps
    JojonomicAPI jojonomicAPI;

    @Given("Get current API with valid {string} as lat and {string} as lon using Key {string}")
    public void getCurrentAPIWithValidAsLatAndAsLonUsingKey(String lat, String lon, String key) {
        jojonomicAPI.setGetCurrentDataAPI(lat, lon, key);
    }
    @When("Send get current API request")
    public void sendGetCurrentAPIRequest() {
        SerenityRest.when().get(JojonomicAPI.GET_Current);
    }

    @Then("Status code should response {int} OK")
    public void statusCodeShouldResponseOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }



    @Then("Body response should contain state_code {string}")
    public void bodyResponseShouldContainState_code(String state_code) {
    }

    @And("Validate Get current API with valid JSon")
    public void validateGetCurrentAPIWithValidJSon() {
        File json = new File(JojonomicAPI.JSON_SCHEMA + "/getCurrenApiJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }


    @Given("Get forecast API with {string} as postalcode using Key {string}")
    public void getForecastAPIWithAsPostalcodeUsingKey(String postal_code, String key) {
        jojonomicAPI.setGetForecastAPIData(postal_code, key);
    }

    @When("Send get forecast API request")
    public void sendGetForecastAPIRequest() {
        SerenityRest.when().get(JojonomicAPI.GET_forecast);
    }

    @Then("Body response should contain timestamp_utc {string} and weather {string}")
    public void bodyResponseShouldContainTimestamp_utcAndWeather(String arg0, String arg1) {
    }

    @And("validate Get forecast API with valid Json")
    public void validateGetForecastAPIWithValidJson() {
        File json = new File(JojonomicAPI.JSON_SCHEMA + "/getForecastJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
