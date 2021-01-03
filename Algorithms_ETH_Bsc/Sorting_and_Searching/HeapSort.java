
public class HeapSort {
	public static int[] heapSort(int[] A) {
		int mid = (A.length-1)/2;
		
		/* This for loop helps us create the heap in order to then heapsort the array*/
		for (int i = mid; i >= 0; i--) {
			restoreHeapCondition(A, i, A.length-1);
		}
		
		/* After the heap condition is fullfilled, we can begin sorting*/
		for (int i = A.length - 1; i > 0; i--) {
			
			/* Takes the max and puts it at the end of the array*/
			int temp = A[0];
			A[0] = A[i];
			A[i] = temp;
			
			/* Continues on subarray that is not sorted*/
			restoreHeapCondition(A, 0, i-1);
		}
		
		return A;
	}
	
	
	public static void restoreHeapCondition(int[] A, int mainPointer, int arrayLength) {
		/* This while loop continues as long as the "node" has children*/
		while (2 * mainPointer <= arrayLength) {
			int childrenPointer = 2 * mainPointer;
			
			if (childrenPointer + 1 <= arrayLength) {
				/* Change pointer to the bigger child*/
				if (A[childrenPointer] < A[childrenPointer + 1]) {
					childrenPointer++;
				}
				/* If the parent node is bigger than the children, we can stop this iteration*/
				if (A[mainPointer] >= A[childrenPointer]) {
					break;
				} else {
					/* If child is bigger than parent node, change them */
					int temp = A[mainPointer];
					A[mainPointer] = A[childrenPointer];
					A[childrenPointer] = temp;				
				}
			}
			
			mainPointer = childrenPointer;
			
			/* Stop if we are through the whole array*/
			if (arrayLength == 0) {
				break;
			}
		}
		
	}
}
