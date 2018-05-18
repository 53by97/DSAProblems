package day1;

class PairSum {
	private int index1;
	private int index2;

	public PairSum(boolean found, int index1, int index2) {
		this.index1 = index1;
		this.index2 = index2;
	}

	@Override
	public String toString() {
		return "PairSum [index1=" + index1 + ", index2=" + index2 + "]";
	}

}

public class PairSumInSortedArray {

	public static void main(String[] args) {
		final int[] input = { 1, 2, 4, 5, 5 };
		final int sum = 9;

		final PairSum pairSum = findPairSumInSortedArray(input, sum);

		System.out.println(pairSum);
	}

	private static PairSum findPairSumInSortedArray(int[] input, int sum) {
		int low = 0;
		int high = input.length - 1;

		while (low < high) {
			final int cSum = input[low] + input[high];
			if (cSum == sum) {
				return new PairSum(true, low, high);
			} else if (cSum < sum) {
				low++;
			} else {
				high--;
			}
		}

		return null;
	}

}
