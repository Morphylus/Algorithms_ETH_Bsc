
public class BubbleSort {

	public static int[] bubbleSort(int[] A) {
		
		for (int j = 0; j < A.length-1; j++) {
			for (int i = 0; i < A.length-1; i++) {
				if (A[i] > A[i+1]) {
					int temp = A[i];
					A[i] = A[i+1];
					A[i+1] = temp;
				}
			}
		}
		return A;
	}
	
}
