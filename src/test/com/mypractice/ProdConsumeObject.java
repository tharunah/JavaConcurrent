package test.com.mypractice;

public class ProdConsumeObject {

	int count;
	int i = 0;

	public synchronized void produce() {
		while (count < 25) {
			if (i %2 == 0) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			i += 1;
			System.out.println("I produced...+"+i);
			count++;
			notify();
		}
	}
   
	public synchronized void consumer(){
		while(count <25){
			if(i%2 != 0){
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			i+=1;
			System.out.println("I consumed...+"+i);

			notify();
		}
	}
}
