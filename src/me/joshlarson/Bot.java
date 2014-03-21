package me.joshlarson;
/*
 * added change log (this thing!)
 * added getPix___(); functions (fairly self explanatory)
 * added sleep function (defaults to off) to simulate human typing (to hopefully trick programs looking for bots)
 */

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class Bot {
	static Robot robot;
	static boolean sleep = false;
	
	public static void setup(){
		try {
			robot = new Robot();
		} catch (AWTException e){
			e.printStackTrace();
		}
	}
	
	public static boolean toggleSleep(){
		if(sleep) sleep = false;
		if(!sleep) sleep = true;
		return sleep;
	}
	
	public static int getPixRed(int x, int y){
		return robot.getPixelColor(x, y).getRed();
	}
	
	public static int getPixGreen(int x, int y){
		return robot.getPixelColor(x, y).getGreen();
	}
	
	public static int getPixBlue(int x, int y){
		return robot.getPixelColor(x, y).getBlue();
	}
	
	public static void moveMouse(int x, int y){
		robot.mouseMove(x, y);
	}
	
	public static void leftClick(){
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
	}
	
	public static void rigthClick(){
		robot.mousePress(InputEvent.BUTTON2_MASK);
		robot.mouseRelease(InputEvent.BUTTON2_MASK);
	}
	
	public static boolean isPixDarkerThan(int x, int y, int r, int g, int b){
		if(getPixRed(x, y) < r)
			if(getPixGreen(x, y) < g)
				if(getPixBlue(x, y) < b)
					return true;
		return false;
	}
	
	public static boolean isPixColor(int x, int y, int r, int g, int b){
		if(getPixRed(x, y) == r)
			if(getPixGreen(x, y) == g)
				if(getPixBlue(x, y) == b)
					return true;
		return false;
	}
	
	public static void printcolor(int x, int y){
		System.out.println("x: " + x + "\ty: " + y + "\t" + getPixRed(x, y) + ", " + getPixGreen(x, y) + ", " + getPixBlue(x, y));
	}
	
	public static void typeStuff(String x) {
		while(x.length() > 0){
			int delay = (int) Math.random() * 50;
			if (sleep = true) try { Thread.sleep(delay); } catch (InterruptedException ie) {}
			if (x.charAt(0) == 'a') pressAKey();
			if (x.charAt(0) == 'b') pressBKey();
			if (x.charAt(0) == 'c') pressCKey();
			if (x.charAt(0) == 'd') pressDKey();
			if (x.charAt(0) == 'e') pressEKey();
			if (x.charAt(0) == 'f') pressFKey();
			if (x.charAt(0) == 'g') pressGKey();
			if (x.charAt(0) == 'h') pressHKey();
			if (x.charAt(0) == 'i') pressIKey();
			if (x.charAt(0) == 'j') pressJKey();
			if (x.charAt(0) == 'k') pressKKey();
			if (x.charAt(0) == 'l') pressLKey();
			if (x.charAt(0) == 'm') pressMKey();
			if (x.charAt(0) == 'n') pressNKey();
			if (x.charAt(0) == 'o') pressOKey();
			if (x.charAt(0) == 'p') pressPKey();
			if (x.charAt(0) == 'q') pressQKey();
			if (x.charAt(0) == 'r') pressRKey();
			if (x.charAt(0) == 's') pressSKey();
			if (x.charAt(0) == 't') pressTKey();
			if (x.charAt(0) == 'u') pressUKey();
			if (x.charAt(0) == 'v') pressVKey();
			if (x.charAt(0) == 'w') pressWKey();
			if (x.charAt(0) == 'x') pressXKey();
			if (x.charAt(0) == 'y') pressYKey();
			if (x.charAt(0) == 'z') pressZKey();
			if (x.charAt(0) == ' ') pressSpaceKey();
			if (x.charAt(0) == '?') pressQuestionKey();
			if (x.charAt(0) == '\\' && x.charAt(1) == 'n') pressEnterKey();
			if (x.charAt(0) == '\\' && x.charAt(1) != 'n') pressBackSlashKey();
			if (x.charAt(0) == '(') pressOpenPerKey();
			if (x.charAt(0) == ')') pressClosePerKey();
			if (x.charAt(0) == ':') pressColnKey();
			if (x.charAt(0) == '!') pressExclamKey();
			if (x.charAt(0) == '.') pressExclamKey();
			if (x.charAt(0) == 0x11) pressLeftKey();
			if (x.charAt(0) == 0x12) pressUpKey();
			if (x.charAt(0) == 0x13) pressDownKey();
			if (x.charAt(0) == 0x14) pressRightKey();
			x = x.substring(1);
		}		
	}

	private static void pressAKey(){
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);
	}
	
	private static void pressBKey(){
		robot.keyPress(KeyEvent.VK_B);
		robot.keyRelease(KeyEvent.VK_B);
	}
	
	private static void pressCKey(){
		robot.keyPress(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_C);
	}
	
	private static void pressDKey(){
		robot.keyPress(KeyEvent.VK_D);
		robot.keyRelease(KeyEvent.VK_D);
	}
	
	private static void pressEKey(){
		robot.keyPress(KeyEvent.VK_E);
		robot.keyRelease(KeyEvent.VK_E);
	}
	
	private static void pressFKey(){
		robot.keyPress(KeyEvent.VK_F);
		robot.keyRelease(KeyEvent.VK_F);
	}
	
	private static void pressGKey(){
		robot.keyPress(KeyEvent.VK_G);
		robot.keyRelease(KeyEvent.VK_G);
	}
	
	private static void pressHKey(){
		robot.keyPress(KeyEvent.VK_H);
		robot.keyRelease(KeyEvent.VK_H);
	}
	
	private static void pressIKey(){
		robot.keyPress(KeyEvent.VK_I);
		robot.keyRelease(KeyEvent.VK_I);
	}
	
	private static void pressJKey(){
		robot.keyPress(KeyEvent.VK_J);
		robot.keyRelease(KeyEvent.VK_J);
	}
	
	private static void pressKKey(){
		robot.keyPress(KeyEvent.VK_K);
		robot.keyRelease(KeyEvent.VK_K);
	}
	
	private static void pressLKey(){
		robot.keyPress(KeyEvent.VK_L);
		robot.keyRelease(KeyEvent.VK_L);
	}
	
	private static void pressMKey(){
		robot.keyPress(KeyEvent.VK_M);
		robot.keyRelease(KeyEvent.VK_M);
	}
	
	private static void pressNKey(){
		robot.keyPress(KeyEvent.VK_N);
		robot.keyRelease(KeyEvent.VK_N);
	}
	
	private static void pressOKey(){
		robot.keyPress(KeyEvent.VK_O);
		robot.keyRelease(KeyEvent.VK_O);
	}
	
	private static void pressPKey(){
		robot.keyPress(KeyEvent.VK_P);
		robot.keyRelease(KeyEvent.VK_P);
	}
	
	private static void pressQKey(){
		robot.keyPress(KeyEvent.VK_Q);
		robot.keyRelease(KeyEvent.VK_Q);
	}
	
	private static void pressRKey(){
		robot.keyPress(KeyEvent.VK_R);
		robot.keyRelease(KeyEvent.VK_R);
	}
	
	private static void pressSKey(){
		robot.keyPress(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_S);
	}
	
	private static void pressTKey(){
		robot.keyPress(KeyEvent.VK_T);
		robot.keyRelease(KeyEvent.VK_T);
	}
	
	private static void pressUKey(){
		robot.keyPress(KeyEvent.VK_U);
		robot.keyRelease(KeyEvent.VK_U);
	}
	
	private static void pressVKey(){
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
	}
	
	private static void pressWKey(){
		robot.keyPress(KeyEvent.VK_W);
		robot.keyRelease(KeyEvent.VK_W);
	}
	
	private static void pressXKey(){
		robot.keyPress(KeyEvent.VK_X);
		robot.keyRelease(KeyEvent.VK_X);
	}
	
	private static void pressYKey(){
		robot.keyPress(KeyEvent.VK_Y);
		robot.keyRelease(KeyEvent.VK_Y);
	}
	
	private static void pressZKey(){
		robot.keyPress(KeyEvent.VK_Z);
		robot.keyRelease(KeyEvent.VK_Z);
	}
	
	private static void pressSpaceKey(){
		robot.keyPress(KeyEvent.VK_SPACE);
		robot.keyRelease(KeyEvent.VK_SPACE);
	}
	
	private static void pressEnterKey(){
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	private static void pressQuestionKey(){
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_SLASH);
		robot.keyRelease(KeyEvent.VK_SLASH);
		robot.keyRelease(KeyEvent.VK_SHIFT);
	}
	
	private static void pressOpenPerKey(){
		robot.keyPress(KeyEvent.VK_LEFT_PARENTHESIS);
		robot.keyRelease(KeyEvent.VK_LEFT_PARENTHESIS);
	}
	
	private static void pressClosePerKey(){
		robot.keyPress(KeyEvent.VK_RIGHT_PARENTHESIS);
		robot.keyRelease(KeyEvent.VK_RIGHT_PARENTHESIS);
	}
	
	private static void pressColnKey(){
		robot.keyPress(KeyEvent.VK_COLON);
		robot.keyRelease(KeyEvent.VK_COLON);
	}
	
	public static void pressRightKey(){
		robot.keyPress(KeyEvent.VK_RIGHT);
		robot.keyRelease(KeyEvent.VK_RIGHT);
	}
	
	public static void pressUpKey(){
		robot.keyPress(KeyEvent.VK_UP);
		robot.keyRelease(KeyEvent.VK_UP);
	}
	
	public static void pressLeftKey(){
		robot.keyPress(KeyEvent.VK_LEFT);
		robot.keyRelease(KeyEvent.VK_LEFT);
	}
	
	public static void pressDownKey(){
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
	}
	
	private static void pressExclamKey(){
		robot.keyPress(KeyEvent.VK_EXCLAMATION_MARK);
		robot.keyRelease(KeyEvent.VK_EXCLAMATION_MARK);
	}
	
	private static void pressBackSlashKey(){
		robot.keyPress(KeyEvent.VK_BACK_SLASH);
		robot.keyRelease(KeyEvent.VK_BACK_SLASH);
	}

}
