package com.rafaelrahn.demospringrrr.token;

import com.rafaelrahn.demospringrrr.exceptions.NotAuthorizedException;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "token")
public class TokenController {
    private final TokenService  tokenService;

    public TokenController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @GetMapping
    public Token getToken() {
        System.out.println("getToken");
        return tokenService.generateToken();
    }

    @PostMapping
    public Token refreshToken(@RequestBody String refreshTokenId) {
        System.out.println("refreshToken: " + refreshTokenId);
        return tokenService.refreshToken(refreshTokenId);
    }

    @PostMapping(value = "test")
    public boolean test(@RequestHeader("token") String tokenId) {
        System.out.println("test: " + tokenId);
        if (tokenService.validateToken(tokenId)) {
            return true;
        } else {
            throw new NotAuthorizedException();
        }

    }
}
