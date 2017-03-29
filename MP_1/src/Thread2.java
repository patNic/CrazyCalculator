import java.util.*;
import javax.swing.*;

public class Thread2 extends Thread 
{
	public static PseudoArray strNum = new PseudoArray(40);

	public void run()
	{
		try
		{
			for(int i=0; i < strNum.getSize()-1; i++)
			{
				Gui.table[3].setText(strNum.getElement(i));
				Thread.sleep(1000);
				if(InfixToPostFixs.strsCount< InfixToPostFixs.strs.getSize())
				{
					Gui.textArea[1].setText(InfixToPostFixs.strs.getElement(InfixToPostFixs.strsCount));
					++InfixToPostFixs.strsCount;
				}
			}
			Gui.table[3].setText("End");
			
			Gui.textArea[1].setText(ThreadTry.myPostfix);
			
			Gui.textArea[2].setText(ThreadTry.myExp);
			Gui.table[3].setText("");
			
			strNum= new PseudoArray(40);
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
