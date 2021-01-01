import java.util.Arrays;
import java.util.Random;

public class PlayGround {

	public static void main(String[] args) {
		Random rand = new Random();
		
		int[] A = ArrayCreation.createRandomArray(8, 30);
		System.out.println(Arrays.toString(MergeSort.mergeSort(A, 0, A.length-1)));
		
		
	}

}
