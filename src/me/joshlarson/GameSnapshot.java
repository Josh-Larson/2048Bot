package me.joshlarson;

public final class GameSnapshot {
	
	private static final int SIZE = 4;
	private int[][] board;
	
	public GameSnapshot() {
		board = new int[SIZE][SIZE];
	}
	
	public GameSnapshot(int[][] board) {
		this.board = board;
		if (board.length != SIZE)
			throw new IllegalArgumentException("Illegal Board Size. Should be " + SIZE);
		if (board[0].length != SIZE)
			throw new IllegalArgumentException("Illegal Board Size. Should be " + SIZE);
	}
	
	public int [][] getBoard() {
		int [][] board = new int[SIZE][SIZE];
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				board[x][y] = this.board[x][y];
			}
		}
		return board;
	}
	
	public GameSnapshot clone() {
		return new GameSnapshot(getBoard());
	}
	
	public GameSnapshot simulateRandomBlock() {
		if (countEmpty() == 0)
			return clone();
		GameSnapshot clone = clone();
		int x = 0;
		int y = 0;
		do {
			x = (int)(Math.random() * 4);
			y = (int)(Math.random() * 4);
		} while (clone.get(x, y) != 0);
		clone.set(x, y, 2);
		return clone;
	}
	
	private int get(int x, int y) {
		if (x < 0 || y < 0 || x >= SIZE || y >= SIZE)
			return -1;
		return board[x][y];
	}
	
	private void set(int x, int y, int val) {
		if (x >= 0 && y >= 0 && x < SIZE && y < SIZE)
			board[x][y] = val;
	}
	
	private void shiftRowLeft(int startIndex, int row) {
		for (int x = startIndex; x < SIZE; x++) {
			if (get(x, row) != 0) {
				if (startIndex < x) {
					set(startIndex, row, get(x, row));
					set(x, row, 0);
					startIndex++;
				} else {
					startIndex = x + 1;
				}
			}
		}
	}
	
	public GameSnapshot shiftLeft() {
		GameSnapshot snap = clone();
		for (int y = 0; y < SIZE; y++) {
			snap.shiftRowLeft(0, y);
			for (int x = 0; x + 1 < SIZE; x++) {
				if (snap.get(x, y) == snap.get(x + 1, y)) {
					snap.set(x, y, snap.get(x, y) * 2);
					snap.set(x + 1, y, 0);
					snap.shiftRowLeft(x, y);
				}
			}
		}
		return snap;
	}
	
	private void shiftRowRight(int startIndex, int row) {
		for (int x = startIndex; x >= 0; x--) {
			if (get(x, row) != 0) {
				if (startIndex > x) {
					set(startIndex, row, get(x, row));
					set(x, row, 0);
					startIndex--;
				} else {
					startIndex = x - 1;
				}
			}
		}
	}
	
	public GameSnapshot shiftRight() {
		GameSnapshot snap = clone();
		for (int y = 0; y < SIZE; y++) {
			snap.shiftRowRight(SIZE - 1, y);
			for (int x = SIZE - 1; x - 1 >= 0; x--) {
				if (snap.get(x, y) == snap.get(x - 1, y)) {
					snap.set(x, y, snap.get(x, y) * 2);
					snap.set(x - 1, y, 0);
					snap.shiftRowRight(x - 1, y);
				}
			}
		}
		return snap;
	}
	
	private void shiftRowUp(int column, int startIndex) {
		for (int y = 0; y < SIZE; y++) {
			if (get(column, y) != 0) {
				if (startIndex < y) {
					set(column, startIndex, get(column, y));
					set(column, y, 0);
					startIndex++;
				} else {
					startIndex = y + 1;
				}
			}
		}
	}
	
	public GameSnapshot shiftUp() {
		GameSnapshot snap = clone();
		for (int x = 0; x < SIZE; x++) {
			snap.shiftRowUp(x, 0);
			for (int y = SIZE - 2; y > 0; y--) {
				if (snap.get(x, y) == snap.get(x, y + 1)) {
					snap.set(x, y, snap.get(x, y) * 2);
					snap.set(x, y + 1, 0);
					snap.shiftRowUp(x, y - 1);
				}
			}
		}
		return snap;
	}
	
	private void shiftRowDown(int column, int startIndex) {
		for (int y = startIndex; y >= 0; y--) {
			if (get(column, y) != 0) {
				if (startIndex > y) {
					set(column, startIndex, get(column, y));
					set(column, y, 0);
					startIndex--;
				} else {
					startIndex = y - 1;
				}
			}
		}
	}
	
	public GameSnapshot shiftDown() {
		GameSnapshot snap = clone();
		for (int x = 0; x < SIZE; x++) {
			snap.shiftRowDown(x, SIZE - 1);
			for (int y = SIZE - 1; y > 0; y--) {
				if (snap.get(x, y) == snap.get(x, y - 1)) {
					snap.set(x, y, snap.get(x, y) * 2);
					snap.set(x, y - 1, 0);
					snap.shiftRowDown(x, y - 1);
				}
			}
		}
		return snap;
	}
	
	private int getPower(int num) {
		int res = 1;
		while (Math.pow(2, res) < num)
			res += 1;
		return res;
	}
	
	private double getAverageValue() {
		double avg = 0;
		int count = 0;
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				int val = get(x, y);
				if (val != 0) {
					count++;
					avg += val;
				}
			}
		}
		return avg / count;
	}
	
	public int countEmpty() {
		int empty = 0;
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				int val = get(x, y);
				if (val == 0)
					empty++;
			}
		}
		return empty;
	}
	
	public int calculateScore(GameSnapshot before) {
		if (before == null)
			return 0;
		int emptyDiff = countEmpty() - before.countEmpty();
		int avgDiff = (int)(getAverageValue() - before.getAverageValue());
		int score = 0;
		int avg = 0;
		int count = 0;
		int lowest = 2048;
		int highest = 0;
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				int val = get(x, y);
				if (val < lowest)
					lowest = val;
				if (val > highest)
					highest = val;
				if (val != 0) {
					avg += val;
					count++;
				}
			}
		}
		avg = (int)((highest-lowest)*.3+lowest);
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				int val = get(x, y);
				if (val >= avg) {
					score += 2;
				}
			}
		}
		if (emptyDiff > 0)
			return score + emptyDiff * 10;
		return score;
	}
	
	@Override
	public String toString() {
		String str = "";
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				System.out.print(get(x, y));
				if (x + 1 < SIZE)
					System.out.print(", ");
				if (get(x, y) < 10)
					System.out.print(" ");
			}
			System.out.println();
		}
		return str;
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof GameSnapshot) || o == null)
			return false;
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				if (board[x][y] != ((GameSnapshot) o).board[x][y])
					return false;
			}
		}
		return true;
	}
}
