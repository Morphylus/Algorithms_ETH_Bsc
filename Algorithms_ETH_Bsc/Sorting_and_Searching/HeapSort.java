
public class HeapSort {
	public static int[] heapSort(int[] A) {
		int mid = (int) Math.floor((A.length-1)/2);
		
		for (int i = mid; i > 0; i--) {
			restoreHeapCondition(A, i, A.length-1);
		}
		
		for (int i = A.length - 1; i < 0; i--) {
			int temp = A[0];
			A[0] = A[A.length-1];
			A[A.length-1] = temp;
			
			restoreHeapCondition(A, 1, i-1);
		}
		
		return A;
	}
	
	
	public static void restoreHeapCondition(int[] A, int mainPointer, int arrayLength) {
		while (2 * mainPointer <= arrayLength) {
			int childrenPointer = 2 * mainPointer;
			
			if (childrenPointer + 1 <= arrayLength) {
				if (A[childrenPointer] > A[childrenPointer + 1]) {
					childrenPointer++;
				}
			}
			if (A[mainPointer] <= A[childrenPointer]) {
				int temp = A[mainPointer];
				A[mainPointer] = A[childrenPointer];
				A[childrenPointer] = temp;
			}
			mainPointer = childrenPointer;
		}	
		
	}
}
