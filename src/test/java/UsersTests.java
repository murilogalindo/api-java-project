import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UsersTests extends src.test.java.BaseTest {

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
}
