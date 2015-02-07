package com.zandor300.zs.tokenizer;

import java.util.regex.Pattern;

public class TokenData {

	private final Pattern pattern;
	private final TokenType type;

	public TokenData(Pattern pattern, TokenType type) {
		this.pattern = pattern;
		this.type = type;
	}

	public Pattern getPattern() {
		return pattern;
	}

	public TokenType getType() {
		return type;
	}
}
