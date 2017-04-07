import java.util.*;
import javax.swing.*;

public class ThreadTry extends Thread 
{
	public static String myPostfix="";
	public static String myExp="";
	public static PseudoArray str = new PseudoArray(40);
	public static PseudoArray iPushed= new PseudoArray(40);
	public static boolean stop=false;
	public static int k=0;
	public void run()
	{
		try
		{
			Gui.stat[0].setText("Infix to Postfix Conversion");
			Gui.stat[1].setText("Operator Stack");
			for(int i=0; i < str.getSize()-1; i++)
			{
				if(ThreadTry.k<InfixToPostFixs.popped.getSize())
				{
				Gui.stat[3].setText(InfixToPostFixs.popped.getElement(k));
				++k;
				}
				
				Thread.sleep(1000);
				Gui.table[0].setText(str.getElement(i));
				Thread.sleep(1000);
				if(iPushed.getElement(i).equals(false+""))
				{
					
					Gui.table[1].setText(reverse(str.getElement(i)));
					Gui.table[2].setText(reverse(str.getElement(i)));
					Gui.table[3].setText(reverse(str.getElement(i)));
					Thread.sleep(1000);
					
					Gui.table[1].setText(str.getElement(i));
					Gui.table[2].setText(str.getElement(i));
					Gui.table[3].setText(str.getElement(i));
					Thread.sleep(1000);
				}
				else
				{	
					
					Gui.table[1].setText(str.getElement(i));
					Gui.table[2].setText(str.getElement(i));
					Gui.table[3].setText(str.getElement(i));
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
			Gui.table[3].setText("End");
			
			Thread.sleep(1000);
		   	
			Gui.table[1].setText("");
			Gui.table[2].setText("");
			Gui.table[0].setText("");
			Gui.table[3].setText("");
			
			stop=true;
			Gui.textArea[1].setText(myPostfix);
			str= new PseudoArray(40);
			
			iPushed=new PseudoArray(40);
			Thread.sleep(1000);
			Gui.stat[0].setText("Postfix Evaluation");
			Gui.stat[1].setText("Number Stack");
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
