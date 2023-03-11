package starter.JojonomicAPI;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.security.Key;

public class JojonomicAPI {
    public static final String URL = "http://api.weatherbit.io/v2.0";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_REQ_BODY = DIR + "/src/test/resources/JSON/BodyJson";
    public static final String JSON_SCHEMA = DIR+"/src/test/resources/JSON/JsonSchema";
    public static final String Weatherbit_Key = "b45ca70eb57746b1be8dcb853cd8a20e";
    public static String GET_Current = URL + "/current?lat={lat}&lon={lon}&key={key}";
    public static String GET_forecast = URL + "/forecast/hourly?postal_code={postal_code}&key={key}";

    @Step("Set Get Current Data API")
    public void setGetCurrentDataAPI(String lat, String lon, String key){
        SerenityRest.given()
                .pathParams("lat", lat)
                .pathParams("lon", lon)
                .pathParams("key", key);
    }

    @Step("Set Get Forecast API Data")
    public static void setGetForecastAPIData (String postal_code, String key){
        SerenityRest.given().pathParams("postal_code", postal_code)
                .pathParams("key", key);
    }


}
