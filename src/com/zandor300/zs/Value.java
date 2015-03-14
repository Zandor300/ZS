package com.zandor300.zs;

/**
 * Represents a value.
 *
 * @author Zandor300
 */
public class Value {

	private final Type builtInType;
	private Object value;

	public Value(Type builtInType, Object value) {
		this.builtInType = builtInType;
		this.value = value;
	}

	public Type getBuiltInType() {
		return builtInType;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
}
