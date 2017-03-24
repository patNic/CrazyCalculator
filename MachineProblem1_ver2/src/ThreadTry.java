import java.util.*;
import javax.swing.*;

public class ThreadTry extends Thread 
{
	public static ArrayList<String> str = new ArrayList<String>();
	
	public void run()
	{
		try
		{
			for(int i=0; i < str.size(); i++)
			{
				Gui.table[0].setText(str.get(i));
				Thread.sleep(1000);
			}
			str.clear();
			stop();
		}
			catch(Exception e)
			{
				System.out.println("An exception occured");
			}
	}
}
