package org.example.Test;

import org.testng.annotations.Test;
import org.example.Utils.AuthenticationRequest;
import static org.hamcrest.core.IsNull.notNullValue;
import java.util.logging.Logger;
import static io.restassured.RestAssured.given;

public class ValidLoginTest {
    private static final Logger LOGGER = Logger.getLogger("Login Test");

    @Test(priority = 1)
    public void testLoginValidCredentials() {
        String email = System.getProperty("email");
        String password = System.getProperty("password");

        if (email == null || password == null) {
            LOGGER.warning("Email or password not provided. Skipping testLoginValidCredentials.");
            return;
        }

        AuthenticationRequest authenticationRequest = new AuthenticationRequest(email, password);
        LOGGER.info("Submit authentication POST request");

        // GIVEN
        given()
                .baseUri("https://demo.placelab.com")
                .contentType("application/json")
                .body(authenticationRequest.requestBody.toString())

                // WHEN
                .when().post("/api/v2/sessions")

                // THEN
                .then()
                .statusCode(201)
                .contentType("application/json")
                .body("api_token", notNullValue());
    }
}
