package com.zandor300.zs;

import com.zandor300.zs.block.Block;

public class Variable extends Value {

	private final Block block;
	private final String name;

	public Variable(Block block, Type builtInType, String name, Object value) {
		super(builtInType, value);

		this.block = block;
		this.name = name;
	}

	public Block getBlock() {
		return block;
	}

	public String getName() {
		return name;
	}
}
