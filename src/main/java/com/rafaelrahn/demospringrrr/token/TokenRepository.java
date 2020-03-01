package com.rafaelrahn.demospringrrr.token;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class TokenRepository {
    private Map<String, Token> tokens = new HashMap<>();

    public void addToken(Token token) {
        tokens.put(token.getId(), token);
    }

    public Collection<Token> listOfToken() {
        return tokens.values();
    }

    public void removeToken(String id) {
        tokens.remove(id);
    }

    public Token findTokenById(String id) {
        return tokens.get(id);
    }

}
