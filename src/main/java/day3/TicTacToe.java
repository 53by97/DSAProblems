package day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TicTacToe {

	private final static int ROWS = 3;
	private final static int COLS = 3;

	public static void main(String[] args) {

		int[][] board = new int[ROWS][COLS];

		try (InputStreamReader is = new InputStreamReader(System.in); BufferedReader br = new BufferedReader(is)) {
			while (true) {
				System.out.print("\nEnter player 1 input: ");
				String[] p1Input = br.readLine().split(" ");
				int x = Integer.parseInt(p1Input[0]);
				int y = Integer.parseInt(p1Input[1]);
				board[x][y] = 1;

				printBoard(board);

				if (won(board, x, y, 1)) {
					System.out.println("Player 1 won");
					break;
				}

				if (full(board)) {
					System.out.println("It's a draw");
					break;
				}

				System.out.print("\nEnter player 2 input: ");
				String[] p2Input = br.readLine().split(" ");
				x = Integer.parseInt(p2Input[0]);
				y = Integer.parseInt(p2Input[1]);
				board[x][y] = 2;

				printBoard(board);

				if (won(board, x, y, 2)) {
					System.out.println("Player 2 won");
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static boolean won(int[][] board, int x, int y, int pid) {
		boolean flag = false;

		int i = -1;
		while (++i < ROWS && board[i][y] == pid) {
		}

		if (i == ROWS) {
			flag = true;
		}

		int j = -1;
		if (!flag) {
			while (++j < COLS && board[x][j] == pid) {
			}

			if (j == COLS) {
				flag = true;
			}
		}

		i = -1;
		j = -1;
		if (!flag) {
			while (++i < ROWS && ++j < COLS && board[i][j] == pid) {
			}

			if (i == ROWS) {
				flag = true;
			}
		}
		
		i = ROWS;
		j = -1;
		if (!flag) {
			while (--i >= 0 && ++j < COLS && board[i][j] == pid) {
			}

			if (i == -1) {
				flag = true;
			}
		}

		return flag;
	}

	private static boolean full(int[][] board) {
		boolean full = true;
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				if (board[i][j] == 0) {
					full = false;
					break;
				}
			}
		}
		return full;
	}

	private static void printBoard(int[][] board) {
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
}
