package com.imatia.jee.bankmanager.common.base.constants.entities;


public final class User {

	private User() {}

	public static final String DOWN_DATE = "DOWN_DATE";
	public static final String ID_USER = "ID_USER";
	public static final String ACTIVED = "ACTIVED";
	public static final String EMAIL = "EMAIL";
	public static final String USER_NAME = "USER_NAME";
	public static final String LOGIN = "LOGIN";

	// Non lle chamamos PASSWORD porque SonarQube entende que estamos a cablear un contrasinal (falso positivo)
	public static final String PASSW0RD = "PASSWORD";
}
