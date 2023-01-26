import java.io.*;

class Thread1 extends Thread {
	
    public void run() {
        // executed Thread1
        System.out.println("Thread is running");
    }
}

class Thread2 extends Thread {
    public void run() {
        // executed Thread2
        System.out.println("Thread2 is running");
    }
}

public class CalculateSalary {
    public static void main(String[] args) throws IOException {
				
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the Day Payment value: ");
		double dayPayment = Double.parseDouble(input.readLine());
		System.out.println("Entered Day Payment value is: " + dayPayment);
		
		System.out.println("Enter the Number of Days employee works: ");
		int numOfDays = Integer.parseInt(input.readLine());
		System.out.println("Entered Days are: " + numOfDays);
        
		// create two new threads
        Thread thread1 = new Thread1();
        Thread thread2 = new Thread2();
		
        // start the threads
        thread1.start();
        thread2.start();
		
        // main thread(CalculateSalary)
        System.out.println("Main thread is running");
    }
}
