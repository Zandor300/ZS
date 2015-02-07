package com.zandor300.zs.parser;

import com.zandor300.zs.block.Block;
import com.zandor300.zs.tokenizer.Tokenizer;

public abstract class Parser<T extends Block> {

	/**
	 * Takes a line and checks to see if it is for this parser by using regex.
	 * 
	 * @param line
	 * @return
	 */
	public abstract boolean shouldParse(String line);

	/**
	 * Take the superBlock and the tokenizer for the line and return a block of
	 * this parser's type.
	 * 
	 * @param superBlock
	 * @param tokenizer
	 * @return
	 */
	public abstract T parse(Block superBlock, Tokenizer tokenizer);
}
