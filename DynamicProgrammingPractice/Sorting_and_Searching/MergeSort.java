
public class MergeSort {

	/* This method calls mergeSort recursively until its broken down into the smallest parts*/
	public static int[] mergeSort(int[] A, int left, int right) {
		if (left < right) {
			int middle = (int) Math.floor((left + right) / 2);
			mergeSort(A, left, middle);
			mergeSort(A, middle + 1, right);
			merge(A, left, middle, right);			
		}
		
		return A;
	}

	public static void merge(int[] A, int left, int middle, int right) {
		// Create temporary array
		int[] B = new int[right - left + 1];

		// Creating two different pointers on each subarray and a pointer 'k' on array B
		int leftPointer = left;
		int rightPointer = middle + 1;
		int k = 0;

		/* This while loops does the pointer part, pointing at to numbers, comparing them and
		 * putting the small one in front (in array 'B')*/
		while (leftPointer <= middle && rightPointer <= right) {
			if (A[leftPointer] < A[rightPointer]) {
				B[k] = A[leftPointer];
				leftPointer++;
				k++;
			} else {
				B[k] = A[rightPointer];
				rightPointer++;
				k++;
			}
		}
		
		/* After the loop finishes, it is possible that one array is longer than the other,
		 * so we take over the rest of the array, note that only one of those while loops
		 * gets executed*/
		while (leftPointer <= middle) {
			B[k] = A[leftPointer];
			leftPointer++;
			k++;
		}

		while (rightPointer <= right) {
			B[k] = A[rightPointer];
			rightPointer++;
			k++;
		}
		
		/* This for-loop takes all the now ordered values from array 'B' into array 'A'*/
		for (int i = left; i <= right; i++) {
			A[i] = B[i - left];
		}
		
	}
}
