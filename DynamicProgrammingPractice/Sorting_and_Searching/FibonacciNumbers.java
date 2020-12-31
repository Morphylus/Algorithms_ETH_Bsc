import java.util.Scanner;

public class FibonacciNumbers {

	public static void main(String[] args) {
		
		Scanner console = new Scanner(System.in);
		
		System.out.println("Which n-th Fibonnaci Number do you want to calculate: ");
		int n = console.nextInt();
		
		float[] fibo = new float[n+1];
		
		fibo[0] = 0;
		fibo[1] = 1;
		
		for (int i = 2; i <= n; i++) {
			fibo [i] = fibo[i-1] + fibo[i-2];
		}
		
		System.out.println("The " + n + "th fibonnaci number is: " + fibo[n]);

	}

}
