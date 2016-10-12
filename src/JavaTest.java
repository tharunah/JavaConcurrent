
public class JavaTest {

	public static void main(String[] args) {
		System.out.println();
		JavaTest javaTest = new JavaTest();
		javaTest.display(null);
	}
	
	public void display(String a){
		System.out.println("String -"+a);
	}
	
	public void display(Object b){
		System.out.println("Object-"+b);
	}
}
