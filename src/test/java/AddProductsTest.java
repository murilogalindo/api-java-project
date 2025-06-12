import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class AddProductsTest extends BaseTest {

    private String token;

    @BeforeEach
    public void autenticacao() {
        token = given()
                .contentType(ContentType.JSON)
                .body("{\"username\": \"emilys\", \"password\": \"emilyspass\"}")
                .when()
                .post("/auth/login")
                .then()
                .statusCode(200)
                .extract()
                .path("accessToken");
    }

    @Test
    public void deveCriarProdutos() {
        test = extent.createTest("GET /test -Deve adicionar um novo produto status 201");
        given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body("{ " +
                        "\"title\": \"Produto Teste6\"," +
                        "\"description\": \"Desconto\"," +
                        "\"price\": 34," +
                        "\"discountPercentage\": 4.5," +
                        "\"rating\": 3.56," +
                        "\"stock\": 52," +
                        "\"brand\": \"Impression of Acqua Di Gios\"," +
                        "\"category\": \"fragrances\"," +
                        "\"thumbnail\": \"https://i.dummyjson.com/data/products/11/thumbnail.jpg\"" +
                        "}")
                .when()
                .post("/products/add")
                .then()
                .statusCode(201)
                .log().all()
                .body("id", notNullValue())
                .body("title", equalTo("Produto Teste6"))
                .body("price", equalTo((34))); // preço enviado = 34
    }

}
