//import java.util.Scanner;
public class InfixToPostFixs
{
	public static Stack theStack; 
	private String input; 
	private String output = "";
	private String parsed="";
	public String forSnapShot="";
	public static String post="";
	public static String infix="";
	
	public static PseudoArray strs= new PseudoArray(50);
	
	public static int strsCount=0;
	public InfixToPostFixs(String str)  
	{ 
		System.out.printf("%-50s%-50s%-50s%-50s", "Character read", "Parsed", "Committed", "Stack");
		input = str; 
		theStack = new Stack();
	}
	public String convertInToPost()      
	{ 
		int count=0;
		for(int j=0; j<input.length(); j++)
		{ 
			char ch = input.charAt(j); 
			if(ch=='+'||ch=='-'||ch=='*'||ch=='/'||ch=='('||ch==')')
			{
				parsed+=" ";
				strCases(parsed);
				System.out.printf("%-50s",parsed);
				infix+=parsed;
				System.out.printf("%-50s",infix);
				
				parsed=ch+"";
				strCases(parsed);
				System.out.printf("%-50s",parsed);
				infix+=parsed;
				System.out.printf("%-50s",infix);
				
				parsed="";
				int b= ThreadTry.str.getSize();
				ThreadTry.str.add(theStack.displayStack(""), b);
				ThreadTry.iPushed.add(theStack.iPush+"", b);
				forSnapShot +=theStack.displayStack(" ") +"\n"; 
				++count;
			}
			else
			{
				parsed+=ch;
				if(j==input.length()-1)
				{
					strCases(parsed);
					System.out.printf("%-50s",parsed);
					infix+=parsed;
					System.out.printf("%-50s",infix);
				}
			}
		}
		while( !theStack.isEmpty() )   
		{ 
			if(theStack.q.p.getSize()==1&&count>1)
			{
				forSnapShot += theStack.displayStack(" ")+"\n"; 
				int b= ThreadTry.str.getSize();
			    ThreadTry.str.add(theStack.displayStack(""), b);
			    ThreadTry.iPushed.add(theStack.iPush+"", b);
				 int i= strs.getSize();
				strs.add(output, i);
				System.out.print(output);
				theStack.printCont("");
			}
			 output = output + theStack.pop();
			 int i= strs.getSize();
			strs.add(output, i);
			
		} 
		
		int b= ThreadTry.str.getSize();
		ThreadTry.str.add(theStack.displayStack("End"), b);
		ThreadTry.iPushed.add(theStack.iPush+"",b);
		forSnapShot += theStack.displayStack("End   ")+"\n";  
		System.out.printf("%-50s", "End");
		System.out.printf("%-50s", "");
		System.out.printf("%-50s",output);
		System.out.printf("%-50s", "Nothing to read");
		 return output;    	
	}
	public  void checkOperators(String operator, int prec1)
	{                               
		while( !theStack.isEmpty() )
		{ 
			String top = theStack.pop();
			if( top.equals("("))            
			{ 
				int a = theStack.q.p.getSize();
				theStack.push(top,a);
					break; 
			} 
			else                         
			{
				int prec2;                 
				if(top.equals("+") || top.equals("-"))
					prec2 = 1;
				else
					prec2 = 2; 
				
				if(prec2 < prec1)  
			    {   
					int a = theStack.q.p.getSize();
					theStack.push(top, a); 
					break;
				}
				else                      
					output = output + top;  
			}
		} 
		int a = theStack.q.p.getSize();
		theStack.push(operator+"", a);
	}	
	public  void checkParentheses(String ch)
	{                           
		while( !theStack.isEmpty() )
		{ 
			String chx = theStack.pop(); 
			if( chx.equals("(" ))   
				break;                 
			else                      
				output = output + chx;  
		}
	}
	public void strCases(String parse)
	{
		System.out.printf("%-50s",output);
	    theStack.printCont("");
		switch(parsed)
			{ 
				case "+":              
				case "-":
					checkOperators(parsed, 1);     
						break;               
				case "*":              
				case "/": 
					checkOperators(parsed, 2);     
						break;              
				case "(":
				{
					int a = theStack.q.p.getSize();
					theStack.push(parsed+"",a); 
						break;
				}				
				case ")":               
					checkParentheses(parsed);      
						break; 
				default:               
					output = output + parsed; 
						break;
			}
		 int i= strs.getSize();
		 strs.add(output, i);
	}
}
