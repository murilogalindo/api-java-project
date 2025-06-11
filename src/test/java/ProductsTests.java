import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class ProductsTests extends src.test.java.BaseTest {

    private String token;


    @BeforeEach
    public void authenticate() {
        token =
                given()
                        .contentType(ContentType.JSON)
                        .body("{ \"username\": \"emilys\", \"password\": \"emilyspass\" }")
                        .when()
                        .post("/auth/login")
                        .then()
                        .statusCode(200)
                        .extract()
                        .path("accessToken");
    }

    @Test
    public void shouldGetProductsList() {
        given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/auth/products")
                .then()
                .statusCode(200)
                .body("$", not(empty()));
    }

    @Test
    public void shouldAddProductAndRetrieveById() {
        int id = 2;
                given()
                        .when()
                        .get("/products/"+id)
                        .then()
                        .log().status() // log da resposta
                        .log().body()
                        .statusCode(200)
                        .body("id", equalTo(id));

    }
}
