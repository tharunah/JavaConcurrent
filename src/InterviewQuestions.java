import java.util.HashMap;

public class InterviewQuestions {

	public static void main(String[] args) {
/*
		System.out.println("Factorial =" + factorial(4));
		System.out.println(characterCount("this is tharun").toString());
        System.out.print("FibonacciSeries : 0 1 ");
        for(int i=2; i<=10; i++){
         System.out.print(fibonaci(i) +" ");
        }*/
		int a [] = {3,1,7,8,4,2};
        pyramid1(10);
        insertionSort(a);

	}

	public static int factorial(int n) {
		if (n == 0) {
			return 1;
		}
		return n * factorial(n - 1);
	}
	
	public static HashMap<String, Integer> characterCount(String inputStr){
		char[] ch = inputStr.toCharArray();
		HashMap<String, Integer> m = new HashMap<>();
		for(int i=0; i<ch.length; i++){
			String key = ""+ch[i];
			if(m.containsKey(key)){
				int c = m.get(key);
				m.put(key, ++c);
					
			} else {
				m.put(key, 1);
			}
			
		}
		
		return m;		
	}
	
	public static int fibonaci(int n){
		if(n==1 || n==2){
			return 1;
		}
		return fibonaci(n-1)+fibonaci(n-2);
	}

	
	public static void pyramid1(int n){
		int rows = n;
		
		for(int i =1; i<=rows; i++){
			for(int j = 1; j<= (rows-i)*2; j++)
				System.out.print(" ");
			
			for(int k = i; k>=1;k-- )
				System.out.print(" "+k);
			
			for(int k=2;k<=i; k++)
			    System.out.print(" "+k);
			
			System.out.println();
			
		}
		
	}
	
	public static void insertionSort(int[] a){
		
		int i,j,key,temp;
		
		for(i=1;i<a.length;i++){
			key = a[i];
			j=i-1;
			while(j>=0 && a[j]>key){
				temp = a[j];
				a[j]=a[j+1];
				a[j+1] = temp;
				j--;
				
			}
		}
		for(int n:a)
		System.out.println(n);
		
	}
	
}
