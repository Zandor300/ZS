package com.zandor300.zs.block;

import com.zandor300.zs.Type;

/**
 * Represents a class.
 *
 * @author Zandor300
 */
public class Class extends Block implements Type {

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
		for (Block b : getSubBlocks()) {
			if (b instanceof Method) {
				Method method = (Method) b;
				if (method.getName().equals("main") && method.getType().equals("void") && method.getParams().length == 0) {
					method.run();
				}
			}
		}
	}
}
