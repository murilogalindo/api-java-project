import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {

    @Test
    public void shouldLoginAndReturnToken() {
        test = extent.createTest("GET /test - Deve retornar status 200 - Token válido");
        test.info("Iniciando teste de status /test");

        given()
                .contentType("application/json")
                .body("{ \"username\": \"emilys\", \"password\": \"emilyspass\" }")
                .when()
                .post("/auth/login")
                .then()
                .log().all()
                .statusCode(200)
                .body("accessToken", notNullValue());
    }
    @Test
    public void shouldLoginAndReturnInvalidCredentialUserName() {
        test = extent.createTest("GET /test - Deve retornar status 400 - Nome de usuário inválido");
        test.info("Iniciando teste de status /test");

        given()
                .contentType("application/json")
                .body("{ \"username\": \"emily\", \"password\": \"emilyspass\" }")
                .when()
                .post("/auth/login")
                .then()
                .log().all()
                .statusCode(400)
                .body("message", notNullValue());
                System.out.println("Erro: usuário inválido");
    }
        @Test
        public void shouldLoginAndReturnInvalidCredentialPassword() {
            test = extent.createTest("GET /test - Deve retornar status 400 - Senha de usuário inválido");
            test.info("Iniciando teste de status /test");

            given()
                    .contentType("application/json")
                    .body("{ \"username\": \"emilys\", \"password\": \"emilyspas2\" }")
                    .when()
                    .post("/auth/login")
                    .then()
                    .log().all()
                    .statusCode(400)
                    .body("message", notNullValue());
                    System.out.println("Erro: senha inválida");
        }

}
