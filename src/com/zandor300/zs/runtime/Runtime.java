package com.zandor300.zs.runtime;

import com.zandor300.zs.block.Block;
import com.zandor300.zs.block.Class;
import com.zandor300.zs.block.Method;
import com.zandor300.zs.parser.ClassParser;
import com.zandor300.zs.parser.MethodParser;
import com.zandor300.zs.parser.Parser;
import com.zandor300.zs.parser.VariableParser;
import com.zandor300.zs.tokenizer.Tokenizer;

import java.util.ArrayList;

/**
 * Created by Zandor300.
 * Date: 13-3-2015
 * Time: 18:58
 * PC: ZANDOR-PC
 */
public class Runtime {

	private ArrayList<Class> classes;

	public Runtime() {
		this.classes = new ArrayList<Class>();

		String code = "class Variables" + "\n" +

				"public main () returns void" + "\n" +
				"var string str = \"Hello\"" + "\n" +

				"public printString (string str) returns void";

		Parser<?>[] parsers = new Parser<?>[]{new ClassParser(), new MethodParser(), new VariableParser()};

		Class main = null;

		Block block = null;

		boolean success = false;

		for (String line : code.split("\n")) {
			success = false;
			line = line.trim();
			Tokenizer tokenizer = new Tokenizer(line);

			for (Parser<?> parser : parsers) {
				if (parser.shouldParse(line)) {
					Block newBlock = parser.parse(block, tokenizer);

					if (newBlock instanceof Class) {
						classes.add((Class) newBlock);
					} else if (newBlock instanceof Method) {
						block.getBlockTree().get(0).addBlock(newBlock);
					} else {
						block.addBlock(newBlock);
					}

					System.out.println("Found block of type " + newBlock.getClass().getSimpleName());

					block = newBlock;
					success = true;
					break;
				}
			}

			if (!success) {
				throw new IllegalArgumentException("Invalid line: " + line);
			}
		}

		for (Class c : classes) {
			for (Block b : c.getSubBlocks()) {
				if (b instanceof Method) {
					Method method = (Method) b;
					if (method.getName().equals("main") && method.getType().equals("void") && method.getParams().length == 0) {
						main = c;
					}
				}
			}
		}

		if (main == null) {
			throw new IllegalStateException("No main method found.");
		}

		main.run();
	}

	public static void main(String[] args) {
		new Runtime();
	}
}
