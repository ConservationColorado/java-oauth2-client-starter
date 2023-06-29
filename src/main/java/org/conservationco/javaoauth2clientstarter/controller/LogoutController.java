package org.conservationco.javaoauth2clientstarter.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.WebSession;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/oauth2/logout")
public class LogoutController {

    @PostMapping
    public Mono<Void> logout(WebSession session) {
        return session.invalidate();
    }

}
