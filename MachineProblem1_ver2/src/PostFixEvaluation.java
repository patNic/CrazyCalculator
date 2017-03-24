public class PostFixEvaluation
 { 
	private Stack myStack= new Stack();
	private String input; 
	
	private double numA=0, numB=0, ans=0;
	private String parsed="";
	
	public PostFixEvaluation(String str) 
	{
		input = str; 
	}
	public double checkStr() 
	{	
		System.out.println("pasa: "+input);
		boolean opOnly=false;
		char ch;
		int j=0; 
		
		System.out.println("Size: "+input.length());
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
				}
				parsed=ch+"";
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
					parsed="";
				}
			}
			else
			{
				parsed+=ch;
			}
		}
			if(opOnly==false){
				ans = Double.parseDouble(parsed);
			}else{
				ans = Double.parseDouble(myStack.pop()); 
			}
		return ans; 
	}
	public void evaluate(String ch)
	{
		myStack.displayStack(parsed); 
		if(myStack.q.p.getSize()>1)
		{
				numA = Double.parseDouble(myStack.pop());
				numB = Double.parseDouble(myStack.pop());
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
	}
}   
