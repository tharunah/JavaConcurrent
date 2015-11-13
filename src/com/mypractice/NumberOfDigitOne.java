package com.mypractice;

public class NumberOfDigitOne {

	public int countDigitOne(int n) {
		int count = 0;

		  for (long k = 1; k <= n; k *= 10) {
		    long r = n / k, m = n % k;
		    // sum up the count of ones on every place k
		    count += (r + 8) / 10 * k + (r % 10 == 1 ? m + 1 : 0);
		  }

		  return count;
	}

	public boolean isPowerOfTwo(int n) {

		if (n > 0 && (n % 2) == 0) {
			int div = n / 2;
			System.out.println(div);
			while (div > 1) {
				if ((div % 2) != 0 && div > 1) {
					return false;
				} else
					div = div / 2;
			}
			return true;
		} else if(n==1) return true;
		return false;
	}
	
	
	    public int[] twoSum(int[] nums, int target) {
	        int result[] = {0,0};
	        int i=1,j=1;
	        for(;i<= nums.length;i++) {
	        	System.out.println(i+""+j+""+nums.length);
	        	for(j=i+1;j<=nums.length;j++) {
	        		System.out.println(nums[i-1]+""+nums[j-1]+""+nums.length);
	        			if((nums[i-1]+nums[j-1]) == target){
	        			result[0] = i;
	        			result[1] = j;
	        			break ; 
	        		}
	        	}
	         }
	        return result;	
	      }

}
