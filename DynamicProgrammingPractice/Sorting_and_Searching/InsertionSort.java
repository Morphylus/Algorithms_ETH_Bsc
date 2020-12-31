
public class InsertionSort {

	public static int[] insertionSort(int[] A) {
		for (int i = 1; i < A.length; i++) {
			
			// This will assign 'j' to the position where the key A[i] should be
			int j = BinarySearch.binarySearchIns(A, A[i], i-1);
			
			// Saving the key so we can use it later
			int temp = A[i];
			
			/* Shifting the array (for 1 to the right) 
			 * from the position where the key should be, to where the key is rn
			 */
			for (int k = i; k > j; k--) {
				A[k] = A[k-1];
			}
			
			//Now fill in the key into the right index
			A[j] = temp;
		}
		return A;
	}
	
}
