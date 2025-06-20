import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UsersTest extends BaseTest {

    @Test
    public void deveRetornarAListaDeUsuarios() {
        test = extent.createTest("GET /test - Deve listar todos os usuários status 200");
        given()
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .log().all()
                .body("size()", greaterThan(0));
    }
    @Test
    public void deveRetornarStatus404ParaEndpointInvalido() {
        test = extent.createTest("GET /test - Deve mostrar erro 404 de url inválida");
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
