import java.util.Random;
import java.util.Arrays;


public class SubsetSumProblem {

	public static void main(String[] args) {
		Random rand = new Random();

		
		// Creating Array and assigning random values
		int[] coins = new int[rand.nextInt(10)];
		int sum = rand.nextInt(20);
		
		coins[0] = 0;
		
		for (int i = 1; i < coins.length; i++) {
			coins[i] = rand.nextInt(10);
		}
		
		System.out.println("Given coins: " + Arrays.toString(coins));
		System.out.println("Sum: " + sum);
		System.out.println();
		
		
		//Dynamic program
		System.out.println(checkSubsetSum(coins, sum));
		
	}
	
	public static boolean checkSubsetSum(int[] coins, int sum) {
		//Array size variables
		int m = coins.length + 1;
		int n = sum + 1;
		
		boolean[][] DP = new boolean[m][n];
		
		//Base case
		for (int i = 0; i < DP.length; i++) {
			DP[i][0] = true;
		}
		
		
		for (int i = 1; i < DP.length; i++) {
			for (int r = 1; r < DP[i].length; r++) {
				try {
					DP[i][r] = (DP[i-1][r] || DP[i-1][r-coins[i]]);					
				} catch (ArrayIndexOutOfBoundsException e) {
					DP[i][r] = DP[i-1][r];
				}
			}
		}
		
		printMatrix(DP);
		
		
		return DP[m-1][n-1];
	}

	
	public static void printMatrix(boolean[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
	}
	
}
