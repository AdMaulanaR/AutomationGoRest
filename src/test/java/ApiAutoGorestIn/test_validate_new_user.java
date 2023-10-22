package ApiAutoGorestIn;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class test_validate_new_user {

    @Test
    public void TP05ValidateNewUser() {

        String token = "1dfdb361992d13c0b09a2f558f49de5b0cbe97f08827d4d2867322afdd83e82d";
        String authToken = "Bearer "+ token;

        RestAssured
                .given().header("Authorization",authToken).when()
                .get("https://gorest.co.in/public/v2/users/5436177")
                .then().log().all()
                .assertThat().statusCode(200);

    }
}
