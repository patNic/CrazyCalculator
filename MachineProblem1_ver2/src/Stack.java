public class Stack {
	Queue q = new Queue();
	Queue u = new Queue();
	Queue e = new Queue();
	
	public void push(String k, int i){
		q.enqueue(k,i);
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
		System.out.print(s);
		snapShot+=s;
		System.out.print("Stack (bottom-->top): "); 
		//snapShot +="Stack (bottom-->top): ";
		for(int j=0; j< q.p.getSize(); j++)
		{
			System.out.print(q.getElement(j));
			snapShot+=""+q.getElement(j)+"\n";
			System.out.print(' ');
			snapShot +=' ';
		} 
			System.out.println(" ");
			snapShot += " ";
			return snapShot;
	} 
}
