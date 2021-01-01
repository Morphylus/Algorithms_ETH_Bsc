import java.util.Arrays;
import java.util.Random;

public class ArrayCreation {
	
	// Creates a random Array
	public static int[] createRandomArray(int len, int range) {
		Random rand = new Random();
		int[] array = new int[len];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(range);
		}
		
		System.out.println("Random array: " + Arrays.toString(array));
		
		return array;
		
	}
	
	// Creates a random Array that is sorted
	public static int[] createSortedArray(int len, int maxDiff) {
		Random rand = new Random();
		int[] array = new int[len];
		array[0] = rand.nextInt(maxDiff);
		
		for (int i = 1; i < array.length; i++) {
			array[i] = array[i-1] + rand.nextInt(maxDiff);
		}
		
		System.out.println("Sorted array: " + Arrays.toString(array));
		
		return array;
	}
	
	// Prints an Array
	public static void printArray(int[] A) {
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
	}

}
