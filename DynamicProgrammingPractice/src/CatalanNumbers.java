
public class CatalanNumbers {

	public static void main(String[] args) {
		
		System.out.println(catalanNumber(5));

	}
	
	public static int catalanNumber(int n) {
		int[] catNumbers = new int[n];
		catNumbers[0] = 1;
		catNumbers[1] = 1;
		
		for (int i = 2; i < catNumbers.length; i++) {
			catNumbers[i] = 0;
			for (int r = 0; r < i; r++) {
				catNumbers[i] += catNumbers[r] * catNumbers[i-r-1];
			}
		}
		
		return catNumbers[n-1];
	}

}