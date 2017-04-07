
public class PseudoArray {
	LinkList l = new LinkList();
	int size = 0;
	public static boolean outOfBounds=false;
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
			outOfBounds=true;
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
	
}
