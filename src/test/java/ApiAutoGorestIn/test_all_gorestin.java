package ApiAutoGorestIn;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;


public class test_all_gorestin {

    String url = "https://gorest.co.in/public/v2/users/";
    String newid = "5707241";

    @Test
    public void TP01testGetListUser() {
        RestAssured
                .given().when()
                .get(url)
                .then().log().all()
                .assertThat().statusCode(200);
    }

    @Test
    public void TP02testGetListSpecificUser() {

        String token = "1dfdb361992d13c0b09a2f558f49de5b0cbe97f08827d4d2867322afdd83e82d";
        String authToken = "Bearer "+ token;

        RestAssured
                .given().header("Authorization",authToken).when()
                .get(url+ newid)
                .then().log().all()
                .assertThat().statusCode(200);
    }

    @Test
    public void TP03testGetListSpecificWrongUser() {
        RestAssured
                .given().when()
                .get("https://gorest.co.in/public/v2/users/420757")
                .then().log().all()
                .assertThat().statusCode(404)
                .assertThat().onFailMessage("Resource not found");
    }
    @Test
    public void TP04PostCreateUser() {

        String uri = "https://gorest.co.in/public/v2/users";

        String apiCall = uri;

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("name","Ade Maulana");
        jsonObject.put("gender","male");
        jsonObject.put("email","admaulanates1@gmail.com");
        jsonObject.put("status","active");

        String payload = jsonObject.toString();

        String token = "1dfdb361992d13c0b09a2f558f49de5b0cbe97f08827d4d2867322afdd83e82d";
        String authToken = "Bearer "+ token;


        RequestSpecification requestSpecification = RestAssured.given()
                .header("Authorization",authToken)
                .contentType("application/json").body(payload);

        Response response = requestSpecification.post(apiCall);
        int statusCode = response.getStatusCode();
        System.out.println(statusCode);

        String payLoadData = response.body().prettyPrint();
        System.out.println(payLoadData);

        Assert.assertEquals(statusCode, 201);
    }
    @Test
    public void TP05ValidateNewUser() {

        String token = "1dfdb361992d13c0b09a2f558f49de5b0cbe97f08827d4d2867322afdd83e82d";
        String authToken = "Bearer "+ token;


        RestAssured
                .given().header("Authorization",authToken).when()
                .get(url+ newid)
                .then().log().all()
                .assertThat().statusCode(200);

    }
    @Test
    public void TP06ChangeDataName() {

        String uri = "https://gorest.co.in";
        String request = "/public/v2/users/"+ newid;
        String apiCall = uri + request;

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("name","Ade Maulana12345");

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

    @Test
    public void TP07ChangeDataEmail() {

        String uri = "https://gorest.co.in";
        String request = "/public/v2/users/"+ newid;
        String apiCall = uri + request;

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("email","admaulana12345@gmail.com");

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
    @Test
    public void TP08ChangeDataStatus() {

        String uri = "https://gorest.co.in";
        String request = "/public/v2/users/"+ newid;
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
    @Test
    public void TP09DeleteUser() {

        String token = "1dfdb361992d13c0b09a2f558f49de5b0cbe97f08827d4d2867322afdd83e82d";
        String authToken = "Bearer "+ token;

        RestAssured
                .given().header("Authorization",authToken).when()
                .delete(url+ 5707738)
                .then().log().all()
                .assertThat().statusCode(204);

    }

    @Test
    public void TP10ValidateDataDelete() {

        String token = "1dfdb361992d13c0b09a2f558f49de5b0cbe97f08827d4d2867322afdd83e82d";
        String authToken = "Bearer "+ token;

        RestAssured
                .given().header("Authorization",authToken).when()
                .get(url+ 5707738)
                .then().log().all()
                .assertThat().statusCode(404);

    }
}
