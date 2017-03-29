public class Queue{
	PseudoArray p = new PseudoArray(50);
	int index = 0;
	public void enqueue(String k,int index){
		p.add(k, index);
	}
	public String dequeue(){
		String dequeued = p.delete(index);
		index++;
		if(isEmpty()) index = 0;
		return dequeued;
	}
	public void display(){
		p.display();
	}
	public boolean isEmpty(){
		return (p.isEmpty());
	}
	public String getElement(int i){
		String element = p.getElement(i);
		return element;
	}
	public static void main(String args[]){
		Queue q = new Queue();
		q.enqueue("0", 0);
		q.enqueue("1", 1);
		q.enqueue("2", 2);
		q.enqueue("3", 3);
		q.display();
		System.out.println("----");
		System.out.println("deleted: "+q.dequeue());
		q.display();
		System.out.println("index 2: "+q.getElement(2));
		System.out.println("----");
		System.out.println("deleted: "+q.dequeue());
		q.display();
		System.out.println("index 2: "+q.getElement(2));
		System.out.println("deleted: "+q.dequeue());
		System.out.println("deleted: "+q.dequeue());
		q.display();
		System.out.println(q.isEmpty());
		q.enqueue("0", 0);
		q.display();
		q.dequeue();
		System.out.println(q.isEmpty());
		q.display();
	}
}
