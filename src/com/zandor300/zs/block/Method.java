package com.zandor300.zs.block;

import com.zandor300.zs.BuiltInType;
import com.zandor300.zs.Matcher;
import com.zandor300.zs.Parameter;
import com.zandor300.zs.Type;
import com.zandor300.zs.Value;
import com.zandor300.zs.Variable;

public class Method extends Block {

	private final String name, type;
	private final Parameter[] params;
	private Value returnValue;

	public Method(Block superBlock, String name, String type, Parameter[] params) {
		super(superBlock);

		this.name = name;
		this.type = type;
		this.params = params;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public Parameter[] getParams() {
		return params;
	}

	@Override
	public void run() {
		invoke();
	}

	public Value invoke(Value... values) {
		Type t = Matcher.match(type);

		if (values.length != params.length) {
			throw new IllegalArgumentException(
					"Wrong number of values for parameters.");
		}

		for (int i = 0; i < values.length && i < params.length; i++) {
			Parameter p = params[i];
			Value v = values[i];

			if (p.getType() != v.getBuiltInType()) {
				throw new IllegalStateException("Parameter " + p.getName()
						+ " should be " + p.getType() + ". Got " + v.getBuiltInType());
			}

			addVariable(new Variable(this, p.getType(), p.getName(),
					v.getValue()));
		}

		for (Block b : getSubBlocks()) {
			b.run();

			if (returnValue != null) {
				break;
			}
		}

		if (returnValue == null && t != BuiltInType.VOID) {
			throw new IllegalStateException("Expected return value, got none.");
		}

		Value localReturnValue = returnValue;
		returnValue = null;
		return localReturnValue;
	}
}
