package Selenium;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class CalcJavaRobot {

	public static void main(String[] args) throws IOException, InterruptedException, AWTException, HeadlessException, UnsupportedFlavorException {
		// TODO Auto-generated method stub
		//Lunch Calculator exe
Runtime .getRuntime().exec("calc.exe");
Thread.sleep(2000);

// Enter first input as 12
StringSelection x = new StringSelection("12");
Toolkit.getDefaultToolkit().getSystemClipboard().setContents(x, null);


Robot r = new Robot();
r.keyPress(KeyEvent.VK_CONTROL);
r.keyPress(KeyEvent.VK_V);
r.keyRelease(KeyEvent.VK_CONTROL);
r.keyRelease(KeyEvent.VK_V);
Thread.sleep(2000);

//Click on + operation 
r.keyPress(KeyEvent.VK_ADD);
r.keyRelease(KeyEvent.VK_ADD);

//Enter second Input as 24
 StringSelection y = new StringSelection("8");
 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(y, null);
 r.keyPress(KeyEvent.VK_CONTROL);
 r.keyPress(KeyEvent.VK_V);
 r.keyRelease(KeyEvent.VK_CONTROL);
 r.keyRelease(KeyEvent.VK_V);
 Thread.sleep(2000);
 
 //Click on = button 
 r.keyPress(KeyEvent.VK_EQUALS);
 r.keyRelease(KeyEvent.VK_EQUALS);
 Thread.sleep(2000);
 
 //Copy the output and print
// r.keyPress(KeyEvent.VK_CONTEXT_MENU);
// //r.keyRelease(KeyEvent.VK_CONTEXT_MENU);
// r.keyPress(KeyEvent.VK_DOWN);
// r.keyRelease(KeyEvent.VK_DOWN);
// r.keyPress(KeyEvent.VK_DOWN);
// r.keyRelease(KeyEvent.VK_DOWN);
// Thread.sleep(2000);
// 
// r.keyPress(KeyEvent.VK_ENTER);
// r.keyRelease(KeyEvent.VK_ENTER);
// Thread.sleep(2000);
 r.keyPress(KeyEvent.VK_CONTEXT_MENU);
	r.keyPress(KeyEvent.VK_DOWN);
	r.keyRelease(KeyEvent.VK_DOWN);
	r.keyRelease(KeyEvent.VK_CONTEXT_MENU);
	Thread.sleep(2000);
	
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
	Thread.sleep(3000);
 
 String z = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
 System.out.println(z);
 
 //Close the calc
 r.keyPress(KeyEvent.VK_ALT);
	r.keyRelease(KeyEvent.VK_F4);
	r.keyPress(KeyEvent.VK_F4);
	r.keyRelease(KeyEvent.VK_ALT);

	}


}
