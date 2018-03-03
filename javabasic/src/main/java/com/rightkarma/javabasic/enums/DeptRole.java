package com.rightkarma.javabasic.enums;

/**
 * Example of Enum with a constructor
 * Enum values are like HOD, PROFESSOR etc
 * Takes a char as constructor variable. 
 * You can get this variable using a get method ( here getNameVar )  
 * */
public enum DeptRole {
	HOD("H"), PROFESSOR("P"), ASSISTANT("A");

	private String nameVar;

	private DeptRole(String nameAsString) {
		this.nameVar = nameAsString;
	}
	
	public String getNameVar() {
		return nameVar;
	}
	
	@Override
	public String toString() {
		return this.getNameVar();
	}
	
	public static void main(String[] args) {
		System.out.println(DeptRole.ASSISTANT);
		System.out.println(DeptRole.HOD);
	}

}
