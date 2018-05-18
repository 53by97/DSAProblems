package day1;

public class PossibleCoinsSum {

	public static void main(String[] args) {
		final int[] coinsSet = { 1, 2, 5 };
		final int numCoins = coinsSet.length;
		final int sum = 5;

		final int possibleWays = findPossibleCoinsSum(coinsSet, numCoins, sum);

		System.out.println("Total possible ways: " + possibleWays);
	}

	private static int findPossibleCoinsSum(int[] coinsSet, int numCoins, int sum) {
		if (sum == 0) {
			return 1;
		}

		if (sum < 0) {
			return 0;
		}

		if (numCoins <= 0 && sum >= 1) {
			return 0;
		}

		return findPossibleCoinsSum(coinsSet, numCoins - 1, sum)
				+ findPossibleCoinsSum(coinsSet, numCoins, sum - coinsSet[numCoins - 1]);
	}

}
