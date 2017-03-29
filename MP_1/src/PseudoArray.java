
public class PseudoArray {
	LinkList l = new LinkList();
	int size = 0;
	private int count = 0;
	public PseudoArray(int size){
		this.size = size;
	}
	public int getSize(){
		return count;
	}
	public boolean isEmpty(){
		return (l.isEmpty());
	}
	public void add(String k, int i){
		if(count < size){
			l.add(k,i);
			++count;
		}else{
			System.out.println("Out of bounds!");
		}
	}
	public String delete(int i){
		
		String deleted = l.delete(i);
		--count;
		return deleted;
	}
	public void display(){
		l.display();
	}
	public String getElement(int i){
		String element = l.getElement(i);
		
		return element;
	}
	public static void main(String args[]){
		PseudoArray p = new PseudoArray(5);
		p.add("0", 0);
		p.add("1", 1);
		p.add("2", 2);
		p.add("3", 3);
		p.display();
		System.out.println("----");
		System.out.println("deleted: "+p.delete(0));
		p.display();
		System.out.println("index 2: "+p.getElement(2));
		
	}
	
}
