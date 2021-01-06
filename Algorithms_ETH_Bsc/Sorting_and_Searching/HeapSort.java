
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
			
			/* Set a pointer to the left child*/
			int childrenPointer = 2 * mainPointer;
			
			/* If there is a right child that is bigger than the left child, ignore left child
			 * and continue with right child*/
			if (childrenPointer + 1 <= arrayLength) {
				if (A[childrenPointer] < A[childrenPointer + 1]) {
					childrenPointer++;
				}
			}
			
			/* HeapCondition fullfiled, we dont need to check further*/
			if (A[mainPointer] >= A[childrenPointer]) {
				break;
			}
			
			/* Change largest child with parent node*/
			int temp = A[mainPointer];
			A[mainPointer] = A[childrenPointer];
			A[childrenPointer] = temp;
			
			/* Continue with child*/
			mainPointer = childrenPointer;
		}
		
	}
}
