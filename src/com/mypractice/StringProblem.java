package com.mypractice;

public class StringProblem {

	public static void main(String... agr) {

		StringProblem sp = new StringProblem();
		System.out.println(sp.withouEnd2("tharun"));
		sp.internCheck();
	}

	public String withouEnd2(String str) {
		if (str.length() != 0) {
			String s = str.substring(1);
			//System.out.println(s.length());
			if (s.length() != 0)
				return s.replace(s.substring(s.length() - 1), "");
		}
		return "";
	}
	
	public void internCheck(){
		
		String a = "abc";
		String b = new String("abc");
		
		if(a==b){
			System.out.println("a == b: true ");
		} else {
			System.out.println("a == b: false ");  // false
		}
			
		//a.intern();
		b=b.intern();
		
		if(a==b){
			System.out.println("a == b: true ");
		} else {
			System.out.println("a == b: false ");  // false
		}
		
	}
}
