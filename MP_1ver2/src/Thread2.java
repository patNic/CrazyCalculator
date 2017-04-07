import java.util.*;
import javax.swing.*;

public class Thread2 extends Thread 
{
	public static PseudoArray strNum = new PseudoArray(100);
	public static PseudoArray reversed= new PseudoArray(100);
	public static PseudoArray stackCon= new PseudoArray(100);
	public static PseudoArray otherCon= new PseudoArray(100);
	public  static PseudoArray ar;
	public static PseudoArray push= new PseudoArray(100);
	int n=0;
	
	public void run()
	{
		try
		{
			int o=0; 
			int y=0;
			int c=0;
			for(int i=0; i < strNum.getSize()-1; i++)
			{
				Thread.sleep(1000);
				if(InfixToPostFixs.strsCount< InfixToPostFixs.strs.getSize())
				{
					Gui.textArea[1].setText(InfixToPostFixs.strs.getElement(InfixToPostFixs.strsCount));
					Thread.sleep(1000);
					++InfixToPostFixs.strsCount;
				}
				if(ThreadTry.k<InfixToPostFixs.popped.getSize())
				{
					Gui.stat[3].setText(InfixToPostFixs.popped.getElement(ThreadTry.k));
					++ThreadTry.k;
				}
			}
			Gui.stat[3].setText("Nothing to read");
			Gui.textArea[1].setText(ThreadTry.myPostfix);
			Thread.sleep(1000);
			
				for(int i=0; i < strNum.getSize()-1; i++)
				{
					String a=reverse(strNum.getElement(i));
					reverseAr();
					String temp2="";
					String temp3="";
					
					for(int u=0; u < ar.getSize(); u++)
					{
						temp2+=ar.getElement(u);
						temp2+="\n";
						
					}
					stackCon.add(temp2, o);
					for(int u=0; u < ar.getSize(); u++)
					{
						temp3+=reversed.getElement(u);
						temp3+="\n";
					}
					otherCon.add(temp3, o);
					
					++o;
				}
				
			for(int u=0; u < stackCon.getSize(); u++)
			{
				if(PostFixEvaluation.postAr.getSize()>n)
				{
					Gui.stat[3].setText(PostFixEvaluation.postAr.getElement(n));
					++n;
				}
					
				Gui.table[0].setText(stackCon.getElement(u));
				Thread.sleep(1000);
				if(push.getElement(u).equals(false+""))
				{
					Gui.table[1].setText(otherCon.getElement(u));
					Gui.table[2].setText(otherCon.getElement(u));
					Gui.table[3].setText(otherCon.getElement(u));
					Thread.sleep(1000);
				
					Gui.table[1].setText(stackCon.getElement(u));
					Gui.table[2].setText(stackCon.getElement(u));
					Gui.table[3].setText(stackCon.getElement(u));
					Thread.sleep(1000);
				}
				else
				{	
					Gui.table[1].setText(stackCon.getElement(u));
					Gui.table[2].setText(stackCon.getElement(u));
					Gui.table[3].setText(stackCon.getElement(u));
				}	
			}
			Gui.stat[3].setText("Nothing to read");
			Gui.table[3].setText("End");
			Gui.table[1].setText("End");
			Gui.table[2].setText("End");
			Gui.table[0].setText("End");
			Gui.textArea[2].setText(ThreadTry.myExp);
			
			
			strNum= new PseudoArray(40);
			reversed= new PseudoArray(100);
			stackCon= new PseudoArray(100);
			otherCon= new PseudoArray(100);
			
			
			push= new PseudoArray(100);
			n=0;
			PostFixEvaluation.postAr= new PseudoArray(100);
			InfixToPostFixs.popped= new PseudoArray(100);
			ThreadTry.k=0;
			
			Gui.refreshButton.setEnabled(true);
			stop();
		}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}
	public String reverse(String s)
	{
		ar= new PseudoArray(100);
		String ret="";
		int j=ar.getSize();
		for(int i=0;i < s.length(); i++)
		{
			if(s.charAt(i)!='-'&&s.charAt(i)!='\n')
				ret+=s.charAt(i);
			else
			{
				if(ret!="")
				{
					ar.add(ret, j)
					;
					++j;
				}
				ret="";
			}
		}
		return ret;
	}
	public String reversed(String s)
	{
		String ret="";
		for(int k= s.length()-1; k>=0; k--)
			if(s.charAt(k)+""!="\n")
			ret+=s.charAt(k);
		return ret;
	}
	public void reverseAr()
	{
		int j=0;
		for(int i = ar.getSize()-1; i>=0; i--)
		{
			reversed.add(ar.getElement(j), i);
			++j;
		}
	}
}
