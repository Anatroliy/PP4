package com.itm.space.backendresources;

import com.itm.space.backendresources.controller.RestExceptionHandler;
//import lombok.Value;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.keycloak.admin.client.Keycloak;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(username = "User", password = "123q123e", authorities = "ROLE_MODERATOR")
public class FstTest extends BaseIntegrationTest {
    @MockBean
    private Keycloak keycloak;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private RestExceptionHandler restExceptionHandler;
    @Value("${keycloak.realm}")
    private String realmItm;
    @Test
    @SneakyThrows
    public void helloTest(){
        MockHttpServletResponse response = mvc.perform(get("/api/users/hello")).andReturn().getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals("User",response.getContentAsString());
    }

}
