package com.zandor300.zs.parser;

import com.zandor300.zs.block.Block;
import com.zandor300.zs.block.Class;
import com.zandor300.zs.tokenizer.Tokenizer;

public class ClassParser extends Parser<Class> {

	@Override
	public boolean shouldParse(String line) {
		return line.matches("class [a-zA-Z][a-zA-Z0-9]*");
	}

	@Override
	public Class parse(Block superBlock, Tokenizer tokenizer) {
		// Skip the class token.
		tokenizer.nextToken();

		// Get the string value of the next token (the name of the class).
		String name = tokenizer.nextToken().getToken();

		return new Class(name);
	}

}
