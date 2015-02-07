package com.zandor300.zs.block;

/**
 * Represents a class.
 * 
 * @author Zandor300
 *
 */
public class Class extends Block {

	private final String name;

	public Class(String name) {
		super(null);

		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public void run() {
		// Run main method.
	}
}
