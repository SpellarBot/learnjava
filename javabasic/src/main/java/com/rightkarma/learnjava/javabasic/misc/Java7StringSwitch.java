package com.rightkarma.learnjava.javabasic.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Java7StringSwitch {
	static Random randomNum = new Random();
	static List<Person> people = createPersonList();

	public static void main(String[] args){
		for ( int i=0;i<10;i++){
			mainLogic();
		}
			
	}

	private static void mainLogic() {

		int index = randomNum.nextInt(3); // 3 will not come.. this will give 0,1,2
		System.out.println(index);
		Person p = people.get(index);

		switch (p.getName()) { // java 7 - you can put a switch statement on a
								// string value
		case "A":
			System.out.println("found A");
			break;
		case "B":
			System.out.println("found B");
			break;
		case "C":
			System.out.println("found C");
			break;
		default:
			System.out.println("whose that ?");
		}
	}

	private static List<Person> createPersonList() {
		Person p1 = new Person("A", 31);
		Person p2 = new Person("B", 32);
		Person p3 = new Person("C", 29);
		List<Person> list = new ArrayList<>(); // Note java 7 does not need
												// class name on right side
		list.add(p1);
		list.add(p2);
		list.add(p3);
		return list;
	}

}
