package me.joshlarson;

public class AI {
	
	public static final int INVALID = -1;
	public static final int UP = 0;
	public static final int RIGHT = 1;
	public static final int DOWN = 2;
	public static final int LEFT = 3;
	private static final int MAX_DEPTH = 5;
	
	public static int getOption(int lastOption, GameSnapshot snap) {
		return (int)exploreOptions(lastOption, null, snap, 0);
	}
	
	public static int getOption(int lastOption, int [][] board) {
		return getOption(lastOption, new GameSnapshot(board));
	}
	
	private static double exploreOptions(int lastOption, GameSnapshot before, GameSnapshot snap, int depth) {
		if (depth >= MAX_DEPTH)
			return INVALID;
		if (depth != 0 && before.equals(snap))
			return INVALID;
		double currentScore = snap.calculateScore(before);
		double bestScore = Double.MIN_VALUE;
		int bestMove = INVALID;
		double score = INVALID;
		for (int i = 0; i < 3; i++) {
			GameSnapshot attempt = snap;
			if (depth != 0)
				attempt = snap.simulateRandomBlock();
			score = exploreOptions(UP, attempt, attempt.shiftUp(), depth + 1);
			if (score > bestScore && score != -1) {
				bestScore = score;
				bestMove = UP;
			}
			score = exploreOptions(LEFT, attempt, attempt.shiftLeft(), depth + 1);
			if (score > bestScore && score != -1) {
				bestScore = score;
				bestMove = LEFT;
			}
			score = exploreOptions(RIGHT, attempt, attempt.shiftRight(), depth + 1);
			if (score > bestScore && score != -1) {
				bestScore = score;
				bestMove = RIGHT;
			}
			score = exploreOptions(DOWN, attempt, attempt.shiftDown(), depth + 1);
			if (score > bestScore && score != -1) {
				bestScore = score;
				bestMove = DOWN;
			}
		}
		if (depth == 0) {
			System.out.printf("Score: %.3f\n", bestScore);
			return bestMove;
		} else {
			return currentScore + bestScore;
		}
	}
	
}
