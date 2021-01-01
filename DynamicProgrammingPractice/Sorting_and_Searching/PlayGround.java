import java.util.Arrays;
import java.util.Random;

public class PlayGround {

	public static void main(String[] args) {
		Random rand = new Random();

		int[] A = ArrayCreation.createRandomArray(10, 20);
		int[] B = QuickSort.quickSort(A, 0, A.length - 1);
		
		Arrays.sort(A);
		System.out.println(Arrays.toString(A));
		System.out.println(Arrays.toString(B));
		
	}

}
