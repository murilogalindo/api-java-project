import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UsersTests extends BaseTest {

    @Test
    public void shouldReturnListOfUsers() {
        given()
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .log().all()
                .body("size()", greaterThan(0));
    }
    @Test
    public void shouldReturn404ForInvalidEndpoint() {
        given()
                .when()
                .get("/userz")  // endpoint errado
                .then()
                .statusCode(404);
    }
    /*
    @Test
    public void shouldHandleInternalServerError() {
        given()
                .when()
                .get("/users?causeError=true") // se conseguir mokar
                .then()
                .statusCode(500);
    }
    */

}
