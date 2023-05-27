package org.example.Utils;

import org.json.JSONObject;

public class AuthenticationRequest {
    private String email;
    private String password;
    public JSONObject requestBody;

    public AuthenticationRequest(String email, String password) {
        this.email = email;
        this.password = password;
        createMainBody();
    }

    private void createMainBody() {
        JSONObject data = new JSONObject();
        data.put("email", email);
        data.put("password", password);
        requestBody = data;
    }
}
