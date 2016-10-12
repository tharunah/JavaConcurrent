
public class PizzBuzz {

	public static void main(String[] args) {
		String s;
		for (int i = 1; i < 100; i++) {
			
			s = i % 3 == 0 ? "Pizz" : "";
			s += i % 5 == 0 ? "Buzz" : "";
            if(s.equals(""))
            	System.out.println(i);
            else
               System.out.println(s);
		}
	}

}
