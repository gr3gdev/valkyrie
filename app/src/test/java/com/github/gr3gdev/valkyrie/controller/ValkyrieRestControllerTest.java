package com.github.gr3gdev.valkyrie.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.github.gr3gdev.valkyrie.model.UserModel;

@SpringBootTest
@AutoConfigureMockMvc
public class ValkyrieRestControllerTest {

    @Autowired
    ValkyrieRestController controller;

    @Autowired
    private MockMvc mockMvc;

    Map<String, String> post(UserModel userModel, ResultMatcher status) throws Exception {

        final MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id", "public-client");

        final ObjectMapper mapper = new ObjectMapper();
        final MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/register")
                .params(params)
                .with(httpBasic("public-client", "secret"))
                .content(mapper.writeValueAsString(userModel))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status)
                .andReturn();
        if (result.getResponse().getStatus() == 400) {
            final MapLikeType mapType = mapper.getTypeFactory().constructMapLikeType(Map.class, String.class,
                    String.class);
            return mapper.readValue(result.getResponse().getContentAsString(),
                    mapType);
        } else {
            return null;
        }
    }

    @Test
    void validatedRegister() throws Exception {
        final UserModel userModel = new UserModel();

        Map<String, String> errors = post(userModel, MockMvcResultMatchers.status().isBadRequest());

        assertEquals("must not be blank", errors.get("firstname"));
        assertEquals("must not be blank", errors.get("lastname"));
        assertEquals("must not be blank", errors.get("username"));
        assertEquals("must not be blank", errors.get("password"));
        assertEquals("must not be blank", errors.get("confirmPassword"));
        assertEquals("must not be blank", errors.get("email"));
        assertEquals("must not be blank", errors.get("confirmEmail"));
        assertNull(errors.get("userModel"));

        userModel.setFirstname("f");
        userModel.setLastname("l");
        userModel.setUsername("u");
        userModel.setPassword("p");
        userModel.setConfirmPassword("cp");
        userModel.setEmail("e");
        userModel.setConfirmEmail("ce");

        errors = post(userModel, MockMvcResultMatchers.status().isBadRequest());

        assertNull(errors.get("firstname"));
        assertNull(errors.get("lastname"));
        assertEquals("size must be between 4 and 32", errors.get("username"));
        assertEquals("size must be between 8 and 100", errors.get("password"));
        assertEquals("size must be between 8 and 100", errors.get("confirmPassword"));
        assertEquals("must be a well-formed email address", errors.get("email"));
        assertEquals("must be a well-formed email address", errors.get("confirmEmail"));

        userModel.setUsername("username");
        userModel.setPassword("password");
        userModel.setConfirmPassword("passw0rd");
        userModel.setEmail("address@email.com");
        userModel.setConfirmEmail("address@email.com");

        errors = post(userModel, MockMvcResultMatchers.status().isBadRequest());

        assertNull(errors.get("firstname"));
        assertNull(errors.get("lastname"));
        assertNull(errors.get("username"));
        assertNull(errors.get("password"));
        assertNull(errors.get("confirmPassword"));
        assertNull(errors.get("email"));
        assertNull(errors.get("confirmEmail"));
        assertEquals("Passwords are not the same", errors.get("userModel"));

        userModel.setConfirmPassword("password");
        userModel.setConfirmEmail("address@email.net");

        errors = post(userModel, MockMvcResultMatchers.status().isBadRequest());

        assertNull(errors.get("firstname"));
        assertNull(errors.get("lastname"));
        assertNull(errors.get("username"));
        assertNull(errors.get("password"));
        assertNull(errors.get("confirmPassword"));
        assertNull(errors.get("email"));
        assertNull(errors.get("confirmEmail"));
        assertEquals("Emails are not the same", errors.get("userModel"));

        userModel.setConfirmEmail("address@email.com");

        assertNull(post(userModel, MockMvcResultMatchers.status().isOk()));
    }
}
