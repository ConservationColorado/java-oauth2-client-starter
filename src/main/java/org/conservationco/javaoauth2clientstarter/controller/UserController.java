package org.conservationco.javaoauth2clientstarter.controller;

import org.conservationco.javaoauth2clientstarter.user.Name;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/me")
    public Mono<ResponseEntity<Name>> getCurrentUsersName(@AuthenticationPrincipal OidcUser user) {
        return Mono.just(
                ResponseEntity.ok(
                        new Name(user.getIdToken().getClaims().get("name").toString())
                )
        );
    }

}
