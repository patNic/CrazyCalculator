import java.util.*;
import javax.swing.*;

public class ThreadTry extends Thread 
{
	public static String myPostfix="";
	public static String myExp="";
	public static PseudoArray str = new PseudoArray(40);
	public static PseudoArray iPushed= new PseudoArray(40);
	public void run()
	{
		try
		{
			Thread.sleep(1000);
			for(int i=0; i < str.getSize()-1; i++)
			{
				Gui.table[0].setText(str.getElement(i));
				Thread.sleep(1000);
				if(iPushed.getElement(i).equals(false+""))
				{
					Gui.table[1].setText(reverse(str.getElement(i)));
					Gui.table[2].setText(reverse(str.getElement(i)));
					Thread.sleep(1000);
					
					Gui.table[1].setText(str.getElement(i));
					Gui.table[2].setText(str.getElement(i));
					Thread.sleep(1000);
				}
				else
				{
					Gui.table[1].setText(str.getElement(i));
					Gui.table[2].setText(str.getElement(i));
					Thread.sleep(1000);
				}
				
				if(InfixToPostFixs.strsCount< InfixToPostFixs.strs.getSize())
				{
				Gui.textArea[1].setText(InfixToPostFixs.strs.getElement(InfixToPostFixs.strsCount));
				++InfixToPostFixs.strsCount;
				}
					
			}
			Gui.table[1].setText("End");
			Gui.table[2].setText("End");
			Gui.table[0].setText("End");
			
			Thread.sleep(1000);
			
			Gui.table[1].setText("");
			Gui.table[2].setText("");
			Gui.table[0].setText("");
			
			Gui.textArea[1].setText(myPostfix);
			str= new PseudoArray(40);
			iPushed=new PseudoArray(40);
			stop();
		}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}
	public String reverse(String s)
	{
		String ret="";
		for(int k= s.length()-1; k>=0; k--)
			if(s.charAt(k)+""!="\n")
			ret+=s.charAt(k);
		return ret;
	}
	
}
