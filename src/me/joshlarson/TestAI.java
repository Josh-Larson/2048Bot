package me.joshlarson;

public class TestAI {
	
	private static int lastOption = AI.INVALID;
	
	public static void main(String [] args) {
		int [][] board = new int[][] {
				{0, 2, 0, 0},
				{0, 2, 2, 0},
				{0, 8, 4, 4},
				{8, 8, 0, 4},
		};
		GameSnapshot snap = new GameSnapshot(board);
		System.out.println("Original: ");
		System.out.println(snap);
		System.out.println();
		System.out.println("Test: ");
		System.out.println(snap.shiftUp());
		
//		for (int i = 0; i < 10; i++) {
		while (true) {
			GameSnapshot after = simulateAI(snap);
			if (snap.equals(after))
				break;
			snap = after;
			if (snap == null)
				break;
			
			snap.simulateRandomBlock();
			System.out.println();
			if (after != null) {
				System.out.println("After:");
				System.out.println(snap);
			} else {
				System.out.println("No suitable move found");
			}
			try { Thread.sleep(1000); } catch (InterruptedException e) { break; }
		}
	}
	
	private static GameSnapshot simulateAI(GameSnapshot snap) {
		GameSnapshot after = null;
		int move = AI.getOption(lastOption, snap.getBoard());
		lastOption = move;
		switch (move) {
			case AI.UP:
				after = snap.shiftUp();
				break;
			case AI.LEFT:
				after = snap.shiftLeft();
				break;
			case AI.DOWN:
				after = snap.shiftDown();
				break;
			case AI.RIGHT:
				after = snap.shiftRight();
				break;
			default:
				System.out.println("ERROR! No move found!");
				break;
		}
		return after;
	}
	
}
