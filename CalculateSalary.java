import java.io.*;

public class CalculateSalary {
	private static double dayPayment;
	private static int numOfDays;
	private static double basicSalary;
	
    public static void main(String[] args){
			
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		//get dayPayment & numOfDays from user
		try{
			System.out.println("Enter the Day Payment value: ");
			double dayPayment = Double.parseDouble(input.readLine());
			System.out.println("Enter the Number of Days: ");
			int numOfDays = Integer.parseInt(input.readLine());
			
			// calculate basicSalary
			double basicSalary = dayPayment * numOfDays;
			System.out.println("Basic Salary is: " + basicSalary);
		}catch(IOException e){
			System.out.println("Not entered the values");
		}
		        
		// create two new threads
        Thread thread2 = new Thread(new AllowancesThread2(basicSalary));
        Thread thread3 = new Thread(new EPFThread3(basicSalary));
		
        // schedule threads
        thread2.start();
        thread3.start();
		
		try{
			thread2.join();
			thread3.join();
		}catch(InterruptedException e){
			System.out.println("Thread2, Thread3 are failed to resume");
		}
		
		double allowances = thread2.getAllowances();
		System.out.println("Allowances: " + allowances);
		
		double epf = thread3.getEPF();
		System.out.println("EPF: " + epf);
		
		double finalSalary = basicSalary + allowances + epf;
		System.out.println("Final Salary is: " + finalSalary);
    }
}

class AllowancesThread2 implements Runnable {
	private double basicSalary;
	private double allowances;
	
	public AllowancesThread2(double basicSalary){
		this.basicSalary = basicSalary;
	}
	
    @Override
    public void run() {
		// calculate allowances
		double allowances = basicSalary * 0.05;
    }
	
	public double getAllowances(){
		return allowances;
	}
}

class EPFThread3 implements Runnable {
	private double basicSalary;
	private double epf;
	
	public EPFThread3(double basicSalary){
		this.basicSalary = basicSalary;
		
	}
	
	@Override
	public void run() {
		double epf = basicSalary * 0.08;
	}
	
	public double getEPF(){
		return epf;
	}
}


