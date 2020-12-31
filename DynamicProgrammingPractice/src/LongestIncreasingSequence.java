import java.util.Random;
import java.util.Arrays;

public class LongestIncreasingSequence {

	public static void main(String[] args) {
		Random rand = new Random();
		
		int[] numbers = new int[20];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = rand.nextInt(40);
		}
		
		
		System.out.println(Arrays.toString(numbers));
		
	}
	
	public int findLongestSequence(int[] numbers) {
		int[] longest = new int[numbers.length];
		
		longest[0] = 1;
		
		for (int i = 1; i < longest.length; i++) {
			for (int r = 0; r < i; r++) {
				
			}
		}
		
		
		
		return 0;
	}

}
