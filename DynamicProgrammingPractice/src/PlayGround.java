import java.util.Arrays;
import java.util.Random;

public class PlayGround {

	public static void main(String[] args) {
		
		int[] A = createRandomArray(20, 500);

		System.out.println(Arrays.toString(BubbleSort.bubbleSort(A)));

	}
	
	public static int[] createRandomArray(int len, int range) {
		Random rand = new Random();
		int[] array = new int[len];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(range);
		}
		
		System.out.println("Random array: " + Arrays.toString(array));
		
		return array;
		
	}

}
