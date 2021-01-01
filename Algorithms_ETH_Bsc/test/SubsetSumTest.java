import static org.junit.Assert.*;

import org.junit.Test;

public class SubsetSumTest {

	@Test
	public void testSmallArrays() {
		int[] coins1 = { 0, 1 };
		int[] coins2 = {};
		int[] coins3 = { 0 };

		assertTrue(SubsetSumProblem.checkSubsetSum(coins1, 1));
		assertTrue(SubsetSumProblem.checkSubsetSum(coins3, 0));
		assertFalse(SubsetSumProblem.checkSubsetSum(coins2, 1));
		assertFalse(SubsetSumProblem.checkSubsetSum(coins3, 1));
	}

	@Test
	public void testBigArrays() {
		int[] coins1 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
		int[] coins2 = { 0, 2, 7, 4, 9, 13, 8, 3, 74, 13, 96, 2, 8, 1, 9, 42, 8, 53, 8, 21 };
		
		assertTrue(SubsetSumProblem.checkSubsetSum(coins1, 91));
		assertTrue(SubsetSumProblem.checkSubsetSum(coins2, 74));
		assertFalse(SubsetSumProblem.checkSubsetSum(coins1, 111));
		assertFalse(SubsetSumProblem.checkSubsetSum(coins2, 10000));
	}

}
