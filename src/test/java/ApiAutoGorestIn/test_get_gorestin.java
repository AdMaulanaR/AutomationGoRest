package ApiAutoGorestIn;

import io.restassured.RestAssured;
import org.testng.annotations.Test;


public class test_get_gorestin {

    @Test
    public void TP01testGetListUser() {
        RestAssured
                .given().when()
                .get("https://gorest.co.in/public/v2/users")
                .then().log().all()
                .assertThat().statusCode(200);
    }

    @Test
    public void TP02testGetListSpecificUser() {
        RestAssured
                .given().when()
                .get("https://gorest.co.in/public/v2/users/5421533")
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
}
