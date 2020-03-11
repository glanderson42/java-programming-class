package main;

import person.Person;
import person.Gender;

public class Main {
	public static void main(String[] args) {
		Person p1 = new Person("Kiss", 
								"Bela", 
								"Engineer", 
								Gender.MALE, 
								1970);
		Person p2 = new Person("Kiss", 
								"Bela", 
								"Engineer", 
								Gender.MALE, 
								1970);
		
		Person p3 = new Person("Kiss", 
								"Bela", 
								"Engineer", 
								Gender.MALE, 
								1971);
		
		System.out.println(p1.toString());
		System.out.println(p3.toString());
		System.out.println(p1.equals(p2));
		System.out.println(p1.equals(p3));
	}
}
