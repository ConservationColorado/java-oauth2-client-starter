package org.conservationco.javaoauth2clientstarter.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.server.WebFilterExchange;
import org.springframework.security.web.server.authentication.ServerAuthenticationSuccessHandler;
import reactor.core.publisher.Mono;

import java.net.URI;

public class OAuth2LoginSuccessHandler
        implements ServerAuthenticationSuccessHandler {

    @Override
    public Mono<Void> onAuthenticationSuccess(WebFilterExchange webFilterExchange, Authentication authentication) {
        redirectUser(webFilterExchange.getExchange().getResponse());
        // here's where you could store the user in a repository
        return Mono.empty();
    }

    private void redirectUser(ServerHttpResponse response) {
        response.setStatusCode(HttpStatus.TEMPORARY_REDIRECT);
        response.getHeaders().setLocation(URI.create("your-url"));
    }

}
