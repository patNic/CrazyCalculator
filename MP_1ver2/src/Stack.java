public class Stack {
	Queue q = new Queue();
	Queue u = new Queue();
	Queue e = new Queue();
	public static boolean iPush=true;
	public void push(String k, int i){
		q.enqueue(k,i);
		iPush = true;
	}
	public String pop(){
		int c  = q.p.getSize() - 1;
		for(int a = 0;a<c;a++){
			u.enqueue(q.dequeue(), a);
		}
		String popped = q.dequeue();
		for(int b = 0;b<c;b++){
			q.enqueue(u.dequeue(), b);
		}
		iPush = false;
		return popped;
	}
	public String peek(){
		String k=q.getElement(q.p.getSize() - 1);
		return k;
	}
	public boolean isEmpty(){
		return (q.isEmpty());
	}
	public void display(){
		q.display();
	}
	public String getElement(int i){
		return (q.getElement(i));
	}
	public String displayStack(String s) 
	{
		String snapShot = "";
		snapShot+=s;
		
		for(int j=0; j< q.p.getSize(); j++)
		{
			snapShot+=""+q.getElement(j)+"\n------\n";
			snapShot +=' ';
		} 
			snapShot += " ";
			return snapShot;
	} 
	public String printCont(String s) 
	{
		String snapShot = "";
		snapShot+=s;
		for(int j=0; j< q.p.getSize(); j++)
		{
			snapShot+=""+q.getElement(j);
			snapShot +=' ';
		}
		System.out.printf("%-50s",snapShot);
		System.out.println();
		return snapShot;
	}
}
