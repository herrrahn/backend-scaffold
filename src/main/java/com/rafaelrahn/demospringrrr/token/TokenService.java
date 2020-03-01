package com.rafaelrahn.demospringrrr.token;

import com.rafaelrahn.demospringrrr.exceptions.NotAuthorizedException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.server.NotAcceptableStatusException;

import java.util.UUID;

@Service
public class TokenService {
    private final TokenRepository tokenRepository;
    private final Token refreshToken;

    public TokenService(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
        refreshToken = new Token(UUID.randomUUID().toString(),
                System.currentTimeMillis() + 1000 * 30,
                null,
                true);
    }

    public Token generateToken() {
        Token token = new Token();
        token.setId(UUID.randomUUID().toString());
        token.setValidUntil(System.currentTimeMillis() + 3000L);
        token.setRefreshToken(refreshToken);
        token.setValid(true);
        tokenRepository.addToken(token);
        return token;
    }

    @Scheduled(fixedDelay = 2000L)
    public void invalidateToken() {
        refreshToken.setValid(validateToken(refreshToken));

        tokenRepository.listOfToken().forEach( token -> {
            if (token.isValid() && !validateToken(token)) {
                token.setValid(false);
                tokenRepository.addToken(token);
            }
        });
    }

    private boolean validateToken(Token token) {
        if (token == null) throw new NotAuthorizedException();
        return token.getValidUntil() > System.currentTimeMillis();
    }

    public boolean validateToken(String tokenId) {
        return validateToken(tokenRepository.findTokenById(tokenId));
    }

    public Token refreshToken(String refreshTokenId) {
        if (!refreshTokenId.equals(refreshToken.getId())) {
            throw new NotAcceptableStatusException("token is not valid!");
        }
        if (!validateToken(refreshToken)) {
            throw new NotAuthorizedException();
        }
        return generateToken();
    }
}
