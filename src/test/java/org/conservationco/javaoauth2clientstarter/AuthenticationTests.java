package org.conservationco.javaoauth2clientstarter;

import org.conservationco.javaoauth2clientstarter.user.Name;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureWebTestClient
public class AuthenticationTests {

    @Autowired
    private WebTestClient client;

    @Test
    void authentication_ShouldRedirectUnauthenticatedAccessToProtectedEndpoint() {
        client.get()
                .uri("/user/me")
                .exchange()
                .expectStatus().is3xxRedirection();
    }

    @Test
    void authentication_ShouldRedirectUnauthenticatedAccessToGoogleLoginPage() {
        client.get()
                .uri("/user/me")
                .exchange()
                .expectHeader().valueEquals("Location", "/oauth2/authorization/google");
    }

    @Test
    void authentication_ShouldAllowAuthenticatedAccessToProtectedEndpoint() {
        client.mutateWith(mockOidcUser())
                .get()
                .uri("/user/me")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void authentication_ShouldReturnAuthenticatedUsersFullName() {
        String expected = MOCK_USER_FULL_NAME;
        String actual = client
                .mutateWith(mockOidcUser())
                .get()
                .uri("/user/me")
                .exchange()
                .expectBody(Name.class)
                .returnResult()
                .getResponseBody()
                .data();
        assertEquals(expected, actual);
    }

    private final String MOCK_USER_FULL_NAME = "Perry The Platypus";

    private SecurityMockServerConfigurers.OidcLoginMutator mockOidcUser() {
        return SecurityMockServerConfigurers
                .mockOidcLogin()
                .idToken((token) -> token.claim("name", MOCK_USER_FULL_NAME));
    }

}
