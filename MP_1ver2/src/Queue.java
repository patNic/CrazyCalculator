
public class Queue {
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
}
