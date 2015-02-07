package com.zandor300.zs.tokenizer;

public enum TokenType {

	/*
	 * Absolutly nothing.
	 */
	EMPTY,

	/*
	 * A token. For example, ( ) = ,
	 */
	TOKEN,

	/*
	 * First character is a letter, any proceeding characters are letters of
	 * numbers.
	 */
	IDENTIFIER,

	/*
	 * A number.
	 */
	INTEGER_LITERAL,

	/*
	 * Anything enclosed in double quotes. "Hello" "1".
	 */
	STRING_LITERAL,
}
