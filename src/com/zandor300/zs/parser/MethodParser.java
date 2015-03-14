package com.zandor300.zs.parser;

import com.zandor300.zs.BuiltInType;
import com.zandor300.zs.Parameter;
import com.zandor300.zs.block.Block;
import com.zandor300.zs.block.Method;
import com.zandor300.zs.tokenizer.Token;
import com.zandor300.zs.tokenizer.Tokenizer;

import java.util.ArrayList;

public class MethodParser extends Parser<Method> {

	@Override
	public boolean shouldParse(String line) {
		return line
				.matches("(public|private) [a-zA-Z][a-zA-Z0-9]* \\(([a-zA-Z][a-zA-Z0-9]* [a-zA-Z][a-zA-Z0-9]*)*\\) returns [a-zA-Z][a-zA-Z0-9]*");
	}

	@Override
	public Method parse(Block superBlock, Tokenizer tokenizer) {
		tokenizer.nextToken(); // Skip the public/private token (for now).
		//TODO: Save the state of the method.

		String name = tokenizer.nextToken().getToken();

		tokenizer.nextToken(); // Skip the ( token.

		Token first = tokenizer.nextToken();

		ArrayList<Parameter> params = new ArrayList<Parameter>();

		if (!first.getToken().equals(")")) {
			String[] paramData = new String[]{first.getToken(), null}; // 0 =
			// type,
			// 1 = value

			while (tokenizer.hasNextToken()) {
				Token token = tokenizer.nextToken();

				if (token.getToken().equals(")"))
					break;

				if (paramData[0] == null) {
					paramData[0] = token.getToken();
				} else {
					paramData[1] = token.getToken();
					params.add(new Parameter(BuiltInType.valueOf(paramData[0]
							.toUpperCase()), paramData[1]));
					paramData = new String[2];
				}
			}
		}

		tokenizer.nextToken(); // Skip the returns token.

		String returnType = tokenizer.nextToken().getToken();

		return new Method(superBlock, name, returnType, params.toArray(new Parameter[params.size()]));
	}
}
