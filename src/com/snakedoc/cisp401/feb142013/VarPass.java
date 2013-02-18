package com.snakedoc.cisp401.feb142013;

public class VarPass {
	public static void main(String[] args) {
		// test pass-by-value
		int x = 10;
		if (methodA(x) != x) {
			System.out.println("a and x values are unchanged");
		} else {
			System.out.println("x was replaced by value a");
		}
		// test pass-by-reference
		k9 fifi = new k9(); // create a fifi instance of class k9
		System.out.println(fifi.getBark());
		methodB(fifi);
		if (fifi.getBark().equals("Woof")) {
			System.out.println("fifi.bark is unchanged");
		} else {
			System.out.println("fifi's bark has been altered!");
		}
		System.out.println("Fifi now makes a " + fifi.getBark());
	}
	
	public static int methodA(int a) {
		a = 5;
		return a;
	}
	
	public static void methodB(k9 a) {
		// change bark to yip in instance a, NOT instance fifi
		a.bark = "yip, yip";
	}
}

class k9 extends VarPass {
	// define a class type k9
	public String bark;
	
	public k9() {
		// constructor initialized var bark to 'woof'
		 bark = "Woof";
	}
	public String getBark() {
		return bark;
	}
}