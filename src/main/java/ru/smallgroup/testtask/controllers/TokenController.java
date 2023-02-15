package ru.smallgroup.testtask.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.smallgroup.testtask.services.TokenService;

@Slf4j
@RestController
public class TokenController {

    private final TokenService tokenService;

    public TokenController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/token")
    public String token(Authentication authentication) {
        log.debug("Token requested - user {}", authentication.getName());
        String token = tokenService.generateToken(authentication);
        log.debug("Token {}", token);
        return token;
    }
}
