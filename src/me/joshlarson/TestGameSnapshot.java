package me.joshlarson;

public class TestGameSnapshot {
	
	public static void main(String [] args) {
		int [][] board = new int[][] {
				{0, 0, 0, 0},
				{0, 2, 2, 0},
				{0, 8, 4, 4},
				{8, 8, 0, 0},
		};
		GameSnapshot snap = new GameSnapshot(board);
		System.out.println("Original: ");
		System.out.println(snap);
		
		System.out.println();
		System.out.println("Left-shifted: ");
		System.out.println(snap.shiftLeft());
		
		System.out.println();
		System.out.println("Right-shifted: ");
		System.out.println(snap.shiftRight());
		
		System.out.println();
		System.out.println("Up-shifted: ");
		System.out.println(snap.shiftUp());
		
		System.out.println();
		System.out.println("Down-shifted: ");
		System.out.println(snap.shiftDown());
	}
	
}
