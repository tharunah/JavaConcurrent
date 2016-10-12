package test.com.mypractice;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class ConvertNumberRunningJUnit {

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(ConvertNumberTest.class);
		if(result.wasSuccessful()){
			System.out.println("Everything looks good ....");
		}
		for (Failure failure : result.getFailures()) System.out.println(failure.getMessage());
				
	}
	
}
