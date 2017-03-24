
public class Link {
	Link next;
	String key = "";
	int index;
	
	public Link(String k, int i){
		next = null;
		this.key = k;
		this.index = i;
	}
	public void display(){
		System.out.println(key);
	}
}
