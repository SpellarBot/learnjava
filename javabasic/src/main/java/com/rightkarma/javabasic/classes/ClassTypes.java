package com.rightkarma.javabasic.classes;

/**
 * example of public , package protected, inner , inner member and anonymous class
 * 
 */
public class ClassTypes {

	/**
	 * following method would use MemberClass and AnnonymousClass
	 */
	public void someMethod() {
		// member class
		class MemberClass{
			
		}
		// instantiate MemberClass
		MemberClass memberClass = new MemberClass();
		// anonymous class
		InterfaceForAnnonymousclass annonymousclass = new InterfaceForAnnonymousclass() {
			// class definition
		};
	}
	
		
	
	/**
	 * Terminology: Nested classes are divided into two categories: static and non-static. 
	 * Nested classes that are declared static are called static nested classes. 
	 * Non-static nested classes are called inner classes. 
	 * 
	 * example of inner class
	 */
	class innerClass{
		// class body
	}
	
	/**
	 * example of static inner class i.e. static nested class
	 * */
	public static class StaticNestedClass{
		public StaticNestedClass() {
			
		}
		
		public String sayHi() {
			return "Hi";
		}
	}
}

/**
 * example of package protected
 */
class PackageProtected {
	
}

interface InterfaceForAnnonymousclass{
	
}
