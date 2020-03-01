package com.rafaelrahn.demospringrrr.token;

public class Token {
    private String id;
    private Long validUntil;
    private Token refreshToken;
    private boolean valid;

    public Token(String id, Long validUntil, Token refreshToken, boolean valid) {
        this.id = id;
        this.validUntil = validUntil;
        this.refreshToken = refreshToken;
        this.valid = valid;
    }

    public Token() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Long validUntil) {
        this.validUntil = validUntil;
    }

    public Token getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(Token refreshToken) {
        this.refreshToken = refreshToken;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
