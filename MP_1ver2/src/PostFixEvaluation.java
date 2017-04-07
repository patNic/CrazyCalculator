public class PostFixEvaluation
 { 
	private Stack myStack= new Stack();
	private String input; 
	public static String post="";
	public static String postEval="";
	
	private double numA=0, numB=0, ans=0;
	private String parsed="";
	public static PseudoArray postAr= new PseudoArray(100);
	int o=0;
	
	public PostFixEvaluation(String str) 
	{
		System.out.println();
		System.out.printf("%-50s%-50s%-50s", "Character read", "Parsed", "Stack");
		System.out.println();
		input = str; 
	}
	public double checkStr() 
	{	
		boolean opOnly=false;
		char ch;
		int j=0; 
	
		for(j=0; j<input.length(); j++)
		{
		   ch = input.charAt(j); 
			if(ch=='+'||ch=='-'||ch=='*'||ch=='/')
			{
				opOnly=true;
				if(parsed!="")
				{
					int a = myStack.q.p.getSize();
					myStack.push( parsed, a );
					
					System.out.printf("%-50s", parsed);
					post+=parsed+" ";
					System.out.printf("%-50s", post);
					postAr.add(post, o);
					++o;
					
					int b= Thread2.strNum.getSize();
					Thread2.strNum.add(myStack.displayStack(""), b);
					Thread2.push.add(myStack.iPush+"", b);
					
					myStack.printCont("");
				}
				parsed=ch+"";
				
				System.out.printf("%-50s", parsed);
				post+=parsed+" ";
				System.out.printf("%-50s", post);
				postAr.add(post, o);
				++o;
				
				evaluate(parsed);
				parsed="";
			}
			else if(ch == ' ')
			{
				opOnly=true;
				if(parsed!="")
				{
					int a = myStack.q.p.getSize();
					myStack.push( parsed, a );
					
					System.out.printf("%-50s", parsed);
					post+=parsed+" ";
					System.out.printf("%-50s", post);
					postAr.add(post, o);
					++o;
					
					int b= Thread2.strNum.getSize();
					Thread2.strNum.add(myStack.displayStack(""),b);
					Thread2.push.add(myStack.iPush+"", b);
					parsed="";
					myStack.printCont("");
				}
			}
			else
			{
				parsed+=ch;
			}
		}
			if(opOnly==false){
				ans = Double.parseDouble(parsed);
				int b= Thread2.strNum.getSize();
				Thread2.strNum.add(myStack.displayStack(""),b);
				Thread2.push.add(myStack.iPush+"", b);
			}else{
				ans = Double.parseDouble(myStack.pop()); 
				int b= Thread2.strNum.getSize();
				Thread2.strNum.add(myStack.displayStack(""),b);
				Thread2.push.add(myStack.iPush+"", b);
			}
		return ans; 
	}
	public void evaluate(String ch)
	{
		myStack.displayStack(parsed);
		if(myStack.q.p.getSize()>1)
		{
				numA = Double.parseDouble(myStack.pop());
				int b= Thread2.strNum.getSize();
				Thread2.strNum.add(myStack.displayStack(""),b);
				Thread2.push.add(myStack.iPush+"", b);
				b= Thread2.strNum.getSize();
				numB = Double.parseDouble(myStack.pop());
				Thread2.strNum.add(myStack.displayStack(""),b);
				Thread2.push.add(myStack.iPush+"", b);
		}
		switch(ch)                      
		{
			case "+":
				ans = numB + numA; 
				break;
			case "-":
				ans = numB - numA;
				break;
			case "*": 
				ans = numB * numA; 
				break;
			case "/":
				ans = numB / numA; 
					break;
			default: 
				ans = 0;
		}	
		int a = myStack.q.p.getSize();
		myStack.push(ans+"", a);
		myStack.printCont("");
		int b= Thread2.strNum.getSize();
		Thread2.strNum.add(myStack.displayStack(""),b);
		Thread2.push.add(myStack.iPush+"", b);
	}
}   
