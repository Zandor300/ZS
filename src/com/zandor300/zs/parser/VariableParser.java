package com.zandor300.zs.parser;

import com.zandor300.zs.Type;
import com.zandor300.zs.Variable;
import com.zandor300.zs.block.Block;
import com.zandor300.zs.tokenizer.Token;
import com.zandor300.zs.tokenizer.TokenType;
import com.zandor300.zs.tokenizer.Tokenizer;

public class VariableParser extends Parser<Block> {

	@Override
	public boolean shouldParse(String line) {
		return line.matches("var [a-zA-Z]+ [a-zA-Z]+ = \"?[a-zA-Z0-9]\"?");
	}

	@Override
	public Block parse(Block superBlock, Tokenizer tokenizer) {
		tokenizer.nextToken(); // Skip the var token.

		Type type = Type
				.valueOf(tokenizer.nextToken().getToken().toUpperCase());

		if (type == Type.VOID) {
			throw new IllegalStateException(
					"Cannot declare variables fo type void.");
		}

		String name = tokenizer.nextToken().getToken();

		tokenizer.nextToken(); // SKip the = token.

		Token v = tokenizer.nextToken();
		Object value = null;

		if (v.getType() == TokenType.INTEGER_LITERAL) {
			value = Integer.valueOf(v.getToken());
		} else if (v.getType() == TokenType.STRING_LITERAL) {
			value = v.getToken();
		} else /* If it's an identifier */{
			value = superBlock.getVariable(v.getToken()).getValue();
		}

		superBlock.addVariable(new Variable(superBlock, type, name, value));
		return null;
	}

}
