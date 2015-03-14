package com.zandor300.zs;

/**
 * Created by Zandor300.
 * Date: 13-3-2015
 * Time: 19:18
 * PC: ZANDOR-PC
 */
public class Matcher {

	public static Type match(String str) {
		return BuiltInType.valueOf(str.toUpperCase());
	}

}
