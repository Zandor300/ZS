package com.zandor300.zs;

public class Parameter {

	private final String name;
	private final Type type;

	public Parameter(Type type, String name) {
		this.type = type;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Type getType() {
		return type;
	}
}
