package day2;

public class MaxIncSubSeqLength {

	public static void main(String[] args) {
		final int[] inputArr = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
		final int inputLen = inputArr.length;

		final int maxIncSubSeqLen = findMaxIncSubSeqLen(inputArr, inputLen);
		System.out.println(maxIncSubSeqLen);
	}

	public static int findMaxIncSubSeqLen(int arr[], int inputLen) {
		final int[] incSubSeqLengths = new int[inputLen];

		for (int i = 0; i < inputLen; i++) {
			incSubSeqLengths[i] = 1;
		}

		for (int i = 1; i < inputLen; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && incSubSeqLengths[i] < incSubSeqLengths[j] + 1)
					incSubSeqLengths[i] = incSubSeqLengths[j] + 1;
			}
		}

		int maxIncSubSeqLen = 0;
		for (int i = 0; i < inputLen; i++) {
			if (maxIncSubSeqLen < incSubSeqLengths[i]) {
				maxIncSubSeqLen = incSubSeqLengths[i];
			}
		}

		return maxIncSubSeqLen;
	}

}
