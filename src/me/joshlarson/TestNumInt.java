package me.joshlarson;

public class TestNumInt {
	
	public static void main(String[] args) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ie) {
		}
		NumberGame x = new NumberGame();
		boolean running = true;
		Bot.moveMouse(300, 400);
		Bot.leftClick();
		Bot.leftClick();
		int lastOption = AI.UP;
		while (running) {
			if (x.isGameOver()) {
				running = false;
				continue;
			}
			if (!x.update())
				try { Thread.sleep(50); } catch (Exception e) { }
			long start = System.nanoTime();
			int opt = AI.getOption(lastOption, x.grid);
			System.out.printf("AI Exec Time: %.3fms\n", (System.nanoTime() - start)/1E6);
			lastOption = opt;
			switch (opt) {
				case AI.UP:
					Bot.pressUpKey();
					System.out.println("Up");
					break;
				case AI.DOWN:
					Bot.pressDownKey();
					System.out.println("Down");
					break;
				case AI.LEFT:
					Bot.pressLeftKey();
					System.out.println("Left");
					break;
				case AI.RIGHT:
					Bot.pressRightKey();
					System.out.println("Right");
					break;
				default:
					System.out.println("Quitting");
					running = false;
					break;
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException ie) {
			}
		}
	}
}
