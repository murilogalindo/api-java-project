import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class GetTests extends BaseTest {

    @Test
    public void resultSholdBe200 (){
        given()
                .when()
                .get("/test")
                .then()
                .log().status() // log da resposta
                .statusCode(200)
                .body("status", equalTo("ok"));

    }
    @Test
    public void resultSholdBe404 (){
        Response response = given()
                .when()
                .get("/tes");

        assertEquals(404, response.getStatusCode());
        String contentType = response.getHeader("Content-Type");
        System.out.println("Content-Type: " + contentType);

        if (contentType != null && contentType.contains("application/json")) {
            response.then().body("status", equalTo("Not Found"));
        }
    }
}