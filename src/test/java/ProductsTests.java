import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class ProductsTests extends BaseTest {

    private String token;


    @BeforeEach
    public void autenticacao() {
        test = extent.createTest("GET /test - Deve validar token status 200 - Token válido");
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
    public void deveRetornarTodosOsProdutos() {
        test = extent.createTest("GET /test - Deve listar todos os produtos status 200");
        given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/auth/products")
                .then()
                .statusCode(200)
                .body("$", not(empty()));
    }

    @Test
    public void deveRetornarOProdudoPorID() {
        test = extent.createTest("GET /test - Deve listar produtos por ID status 200");
        int id = 192;
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
