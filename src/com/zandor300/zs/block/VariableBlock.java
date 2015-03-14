package com.zandor300.zs.block;

import com.zandor300.zs.BuiltInType;
import com.zandor300.zs.Matcher;
import com.zandor300.zs.Type;
import com.zandor300.zs.Variable;

/**
 * Created by Zandor300.
 * Date: 7-2-2015
 * Time: 13:32
 * PC: ZANDOR-PC
 */
public class VariableBlock extends Block {

	private String type, name;
	private Object value;

	public VariableBlock(Block superBlock, String type, String name, Object value) {
		super(superBlock);

		this.type = type;
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	@Override
	public void run() {
		Type t = Matcher.match(type);

		if (t == BuiltInType.VOID)
			throw new IllegalStateException("Cannot declare variables of type void.");

		getSuperBlock().addVariable(new Variable(getSuperBlock(), t, name, value));
	}
}
