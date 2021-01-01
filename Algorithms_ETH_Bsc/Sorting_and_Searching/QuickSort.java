
public class QuickSort {
	public static int[] quickSort(int[] A, int left, int right) {
		if (left < right) {
			int k = partition(A, left, right);
			quickSort(A, left, k - 1);
			quickSort(A, k + 1, right);
		}
		
		return A;
	}
	
	public static int partition(int[] A, int left, int right) {
		int leftPointer = left;
		int rightPointer = right - 1;
		int pivot = A[right];
		
		do {
			while (leftPointer < right && A[leftPointer] <= pivot) {
				leftPointer++;
			}
			
			while (rightPointer > left && A[rightPointer] >= pivot) {
				rightPointer--;
			}
			
			if (leftPointer < rightPointer) {
				int temp = A[leftPointer];
				A[leftPointer] = A[rightPointer];
				A[rightPointer] = temp;
			}
		} while (leftPointer < rightPointer);
		
		int temp = A[leftPointer];
		A[leftPointer] = A[right];
		A[right] = temp;
		
		return leftPointer;
	}
}
