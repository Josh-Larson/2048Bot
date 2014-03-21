package me.joshlarson;

public class NumberGame {
	/*
	 * rgb of 0		190, 179, 166 
	 * rgb of 2		232, 222, 211 
	 * rgb of 4		230, 216, 191
	 * rgb of 8		226, 163, 110 
	 * rgb of 16	225, 135, 90 
	 * rgb of 32	223, 112, 85
	 * rgb of 64	220, 86, 58 
	 * rgb of 128	227, 195, 106 
	 * rgb of 256	226, 192, 92
	 * rgb of 512	225, 80, 187
	 * rgb of 1024	225, 68, 184
	 * rgb of 2048	224, 59, 180
	 */
	private static final int [][] COLOR_MAP = {
		{204, 192, 179}, // 0
		{238, 228, 218}, // 2
		{237, 224, 200}, // 4
		{242, 177, 121}, // 8
		{245, 149, 99},  // 16
		{246, 124, 95},  // 32
		{246, 94, 59},   // 64
		{237, 207, 114}, // 128
		{237, 204, 97},  // 256
		{237, 200, 80},  // 512
		{237, 197, 63},  // 1024
		{224, 59, 180}   // 2048
	};
	private final int scale = 120;
	private final int upLeftX = 163;
	private final int upLeftY = 222;
	private final int searchX = 212;
	private final int searchY = 352;
	
	public int grid[][] = new int[4][4];

	public NumberGame() {
		Bot.setup();
	}
	
	public boolean update(){
		if (isGameOver()) {
			System.out.println("Game Over.");
			return true;
		}
		for (int i = 0; i < 4; i ++) {
			for (int j = 0; j < 4; j ++) {
				int x = upLeftX + (i * scale);
				int y = upLeftY + (j * scale);
				int r = Bot.getPixRed(x, y);
				int g = Bot.getPixGreen(x, y);
				int b = Bot.getPixBlue(x, y);
				boolean found = false;
				for (int c = 0; c < COLOR_MAP.length; c++) {
					if (r == COLOR_MAP[c][0] && g == COLOR_MAP[c][1] && b == COLOR_MAP[c][2]) {
						found = true;
						if (c == 0) {
							grid[i][j] = 0;
						} else {
							grid[i][j] = 1 << c;
						}
					}
				}
				if (!found) {
					grid[i][j] = -1;
					System.out.println("ERROR: color not defined: (" + i + ", " + j + ") " +
						r + ", " + g + ", " + b + ", " + 
						"x: " + x + ", y: " + y);
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean isGameOver(){
		if (Bot.isPixColor(searchX, searchY, 200, 188, 175)) return true;
		else return false;
	}
	
	public void printToConsole(){
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 4; j++){
				if (grid[j][i] < 10)System.out.print(grid[j][i] + " , ");
				else System.out.print(grid[j][i] + ", ");
			}
			System.out.println();
		}
	}
}