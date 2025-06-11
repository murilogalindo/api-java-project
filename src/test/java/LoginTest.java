import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class LoginTest extends src.test.java.BaseTest {

    @Test
    public void shouldLoginAndReturnToken() {
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
