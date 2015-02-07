package com.zandor300.zs.block;

import java.util.ArrayList;

import com.zandor300.zs.Variable;

/**
 * Represents a block of code.
 */
public abstract class Block {

	private final Block superBlock;
	private final ArrayList<Block> subBlocks;
	private final ArrayList<Variable> variables;

	public Block(Block superBlock) {
		this.superBlock = superBlock;
		this.subBlocks = new ArrayList<>();
		this.variables = new ArrayList<>();
	}

	/**
	 * Return the superBlock;
	 * 
	 * @return
	 */
	public Block getSuperBlock() {
		return superBlock;
	}

	public Block[] getSubBlocks() {
		return subBlocks.toArray(new Block[subBlocks.size()]);
	}

	/**
	 * Add a subBlock to the superBlock.
	 * 
	 * @param block
	 */
	public void addBlock(Block block) {
		subBlocks.add(block);
	}

	/**
	 * Get a variable by its name.
	 * 
	 * @param name
	 * @return
	 */
	public Variable getVariable(String name) {
		// Check the superblocks first.

		for (Variable v : variables)
			if (v.getName().equals(name))
				return v;
		return null;
	}

	/**
	 * Add a variable to the block.
	 * 
	 * @param v
	 */
	public void addVariable(Variable v) {
		variables.add(v);
	}

	/**
	 * Execute the block of code.
	 */
	public abstract void run();
}
