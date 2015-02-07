package com.zandor300.zs.tokenizer;

public class Token {

	private final String token;
	private final TokenType type;

	public Token(String token, TokenType type) {
		this.token = token;
		this.type = type;
	}

	public String getToken() {
		return token;
	}

	public TokenType getType() {
		return type;
	}
}
