
public class BinarySearch {

	/*
	 * BinarySearch without bound: if position is not found, the Algorithm returns
	 * the position where 'key' should be
	 */
	public static int binarySearch(int[] A, int key) {
		int left = 0;
		int right = A.length - 1;
		int middle;

		while (left <= right) {
			middle = (int) Math.floor((left + right) / 2);

			if (A[middle] == key) {
				return middle;
			}

			if (key < A[middle]) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
		}
		return left;
	}

	/* Modified BinarySearch for InsertionSort:
	 * 'bound' defines where the binarySearch should take place: from A[0] to A[bound] */
	public static int binarySearchIns(int[] A, int key, int endIndex) {
		int left = 0;
		int right = endIndex;
		int middle;

		while (left <= right) {
			middle = (int) Math.floor((left + right) / 2);

			if (key < A[middle]) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
		}

		return left;

	}
}
