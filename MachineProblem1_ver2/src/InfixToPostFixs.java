//import java.util.Scanner;
public class InfixToPostFixs
{
	public static Stack theStack; 
	private String input; 
	private String output = "";
	private String parsed="";
	public String forSnapShot="";
	
	public InfixToPostFixs(String str)  
	{ 
		input = str; 
		theStack = new Stack();
	}
	public String convertInToPost()      
	{ 
		for(int j=0; j<input.length(); j++)
		{ 
			char ch = input.charAt(j); 
			if(ch=='+'||ch=='-'||ch=='*'||ch=='/'||ch=='('||ch==')')
			{
				parsed+=" ";
				strCases(parsed);
				parsed=ch+"";
				strCases(parsed);
				parsed="";
				ThreadTry.str.add(theStack.displayStack(" "+"\n"));
				forSnapShot +=theStack.displayStack(" ") +"\n"; 
			}
			else
			{
				parsed+=ch;
				if(j==input.length()-1)
				{
					strCases(parsed);
					ThreadTry.str.add(theStack.displayStack(" "+"\n"));
					forSnapShot +=theStack.displayStack(" ") +"\n"; 
				}
			}
		}
		while( !theStack.isEmpty() )   
		{ 
			forSnapShot += theStack.displayStack(" ")+"\n"; 
			ThreadTry.str.add(theStack.displayStack(" "+"\n"));
			 output = output + theStack.pop();
		} 
		ThreadTry.str.add(theStack.displayStack("End "+"\n"));
		forSnapShot += theStack.displayStack("End   ")+"\n";  
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
			
	}
	public static void main(String[] args)
	{
		String input="20*(15+300)-50/(90+5)";
		InfixToPostFixs theTrans = new InfixToPostFixs(input); 
		String output = theTrans.convertInToPost(); 
		System.out.println("Postfix is " + output + "\n"); 
		//PostFixEvaluation aParser = new PostFixEvaluation(output);
		//double output1 = aParser.checkStr(); 
		//System.out.println("Evaluates to " + output1);
	}
}