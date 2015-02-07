package com.zandor300.zs;

/**
 * Represents a value.
 * 
 * @author Zandor300
 *
 */
public class Value {

	private final Type type;
	private Object value;

	public Value(Type type, Object value) {
		this.type = type;
		this.value = value;
	}

	public Type getType() {
		return type;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
}
