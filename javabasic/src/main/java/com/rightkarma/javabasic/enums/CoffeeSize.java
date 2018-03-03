package com.rightkarma.javabasic.enums;

/**
 * 
 * Sample of Enum that has a constructor also
 *
 */
enum CoffeeSize {
	BIG(8), 
	HUGE(10), 
	OVERWHELMING(16) { 
		// start a code block that defines the "body" for this enum constant
		public String getLidCode() { 
			// override the method defined in CoffeeSize
			return "A";
		}
	}; // the semicolon is REQUIRED when more code follows
	
	/**
	 * 
	 * enum Constructor.
	 * This will instantiate field ounces for each enum
	 */
	private int ounces;
	CoffeeSize(int ounces) {
		this.ounces = ounces;
	}

	/**
	 * method to get the class state variable
	*/
	public int getOunces() {
		return ounces;
	}

	public String getLidCode() { // this method is overridden by the OVERWHELMING constant
		return "B"; // the default value we want to return for CoffeeSize constants
	}
	
	public static void main(String[] args) {
		for ( CoffeeSize cs : CoffeeSize.values() ) {
			System.out.println("=================================");
			System.out.println(cs);
			System.out.println(cs.getLidCode());
			System.out.println(cs.getOunces());
			
		}
	}
}