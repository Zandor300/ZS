package com.zandor300.zs;

import com.zandor300.zs.tokenizer.Tokenizer;

public class Testing {

	public static void main(String[] args) {
		String code = "class HelloWorld\n"
				+ "method main requires () returns void\n"
				+ "print \"Hello World\"";
		Tokenizer tokenizer = new Tokenizer(code);

		while (tokenizer.hasNextToken())
			System.out.println(tokenizer.nextToken().getToken());
	}
}
