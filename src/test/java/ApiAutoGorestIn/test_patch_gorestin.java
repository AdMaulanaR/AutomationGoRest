package ApiAutoGorestIn;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class test_patch_gorestin {

    @Test
    public void TP08ChangeDataStatus() {

        String uri = "https://gorest.co.in";
        String request = "/public/v2/users/5436177";
        String apiCall = uri + request;

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("status","inactive");

        String payload = jsonObject.toString();

        String token = "1dfdb361992d13c0b09a2f558f49de5b0cbe97f08827d4d2867322afdd83e82d";
        String authToken = "Bearer "+ token;

        RequestSpecification requestSpecification = RestAssured.given()
                .header("Authorization",authToken)
                .contentType("application/json").body(payload);

        Response response = requestSpecification.put(apiCall);
        int statusCode = response.getStatusCode();
        System.out.println(statusCode);

        String payLoadData = response.body().prettyPrint();
        System.out.println(payLoadData);

        Assert.assertEquals(statusCode, 200);
    }

}
