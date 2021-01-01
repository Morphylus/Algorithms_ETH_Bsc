
public class QuickSort {
	public static int[] quickSort(int[] A, int left, int right) {
		/* Recursive calls of quickSort on the subproblems*/
		if (left < right) {
			/*k will be in the right position, so we continue to do quickSearch on all the other elements
			 * that are not in the right position*/
			int k = partition(A, left, right);
			quickSort(A, left, k - 1);
			quickSort(A, k + 1, right);
		}
		
		return A;
	}
	
	public static int partition(int[] A, int left, int right) {
		/* First, we set a leftpointer, a rightpinter and a pivot element (the one all to the right)*/
		int leftPointer = left;
		int rightPointer = right - 1;
		int pivot = A[right];
		
		/* First while loop: loops until the eelement at 'leftPointer' is bigger then the pivot
		 * Second while loop: loops until the element at 'rightPointer' is smaller then the pivot
		 * Now those two elements get changed
		 * This continues until the leftPointer and rightPointer intersect, now the pivot element gets
		 * inserted in the middle of it, it is now in the right place*/
		do {
			// Move leftPointer
			while (leftPointer < right && A[leftPointer] <= pivot) {
				leftPointer++;
			}
			
			// Move rightPointer
			while (rightPointer > left && A[rightPointer] >= pivot) {
				rightPointer--;
			}
			
			// Change position of elements
			if (leftPointer < rightPointer) {
				int temp = A[leftPointer];
				A[leftPointer] = A[rightPointer];
				A[rightPointer] = temp;
			}
		} while (leftPointer < rightPointer);
		
		// Put pivot in the middle (correct position)
		int temp = A[leftPointer];
		A[leftPointer] = A[right];
		A[right] = temp;
		
		return leftPointer;
	}
}
