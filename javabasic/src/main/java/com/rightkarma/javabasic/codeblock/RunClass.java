package com.rightkarma.javabasic.codeblock;

class ParentClass {
	static int i=0; // using counter to track each statement. in case syso on console is printed out of order.
	{
		System.out.println(++i+" Parent non-static block");
	}
	
	static 
	{
		System.out.println(++i+" Parent static block");
	}
	
	ParentClass(){
		System.out.println(++i+" Parent Constructor");
	}
}

class ChildClass extends ParentClass {
	{
		System.out.println(++i+" Child non-static block");
	}
	
	static 
	{
		System.out.println(++i+" Child static block");
	}
	
	ChildClass(){
		System.out.println(++i+" Child Constructor");
	}
}

public class RunClass{
	public static void main(String[] args) {
		ChildClass obj=new ChildClass();
	}	
}

/**
OUTPUT
1 Parent static block
2 Child static block
3 Parent non-static block
4 Parent Constructor
5 Child non-static block
6 Child Constructor

Take aways:
1. static blocks execute at class loading time. hence you see static blocks printed. parent class is loaded before child class.
2. next, parent class object has to be created before child. 
	So parent class prints before child class. within that, non-static block is exectued before constructor.
3. finally child class code executes.

*/