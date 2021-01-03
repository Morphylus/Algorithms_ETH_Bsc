import java.util.Arrays;
import java.util.Random;

public class PlayGround {

	public static void main(String[] args) {
		Random rand = new Random();

		int[] A = ArrayCreation.createRandomArray(10, 20);
		int[] B = A;
		
		Arrays.sort(B);
		
		System.out.println(Arrays.toString(HeapSort.heapSort(A)));
		System.out.println(Arrays.toString(B));

		for (int i = 0; i < B.length; i++) {
			if (A[i] != B[i]) {
				System.out.println("Wrong sorting!");
				break;
			}
		}
	}

}
