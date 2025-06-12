import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class GetTest extends BaseTest {

    @Test
    public void deveMostrarQueAplicacoEstaFuncionando (){
        test = extent.createTest("GET /test - Deve retornar status 200 com corpo válido");
        given()
                .when()
                .get("/test")
                .then()
                .log().status() // log da resposta
                .statusCode(200)
                .body("status", equalTo("ok"));
        test.pass("Status 200 retornado com sucesso e response com status = 'ok'");

    }
    @Test
    public void deveRetornarErroAplicacaoNaoEstaFuncionandoCorretamente (){
        test = extent.createTest("GET /test - Deve retornar status 404 url inválida - Not Found");
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