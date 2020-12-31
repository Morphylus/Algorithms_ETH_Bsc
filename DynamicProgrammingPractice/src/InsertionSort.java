
public class InsertionSort {

	public static int[] insertionSort(int[] A) {
		for (int i = 1; i < A.length; i++) {
			
			int j = BinarySearch.binarySearchIns(A, A[i], i-1);
			int temp = A[i];
			
			for (int k = i; k > j; k--) {
				A[k] = A[k-1];
			}
			A[j] = temp;
		}
		return A;
	}
	
}
