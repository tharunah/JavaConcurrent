package com.mypractice;

public class StringToNumber {

	public int stringToInt(String str) {
      int number=0;
      int i=0;
      int n = str.length();
      boolean isNagative = false;
      if(str.charAt(0) == '-'){
    	  isNagative = true;
    	  i=1;
      }
      while(i<n){
    	  number *=10;
    	  number+= (str.charAt(i)-'0');
    	  i++;
      }
      if(isNagative)
    	  number= -number;
      return number;
	}
	
	public static void main(String[] args) {
		String str = "-235235";
		StringToNumber stn = new StringToNumber();
		System.out.println(stn.stringToInt(str));
	}
}
