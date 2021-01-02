import java.util.Arrays;
import java.util.Random;

public class PlayGround {

	public static void main(String[] args) {
		Random rand = new Random();

		int[] A = { 3, 7, 5, 1, 4 };
		
		System.out.println(Arrays.toString(HeapSort.heapSort(A)));

	}

}
