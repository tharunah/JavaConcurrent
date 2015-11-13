package com.mypractice;

public class StringProblem {

	public static void main(String... agr) {

		StringProblem sp = new StringProblem();
		System.out.println(sp.withouEnd2(""));
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
}
