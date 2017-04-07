
public class LinkList {
	Link first;
	private int countLink = 0;
	public LinkList(){
		first = null;
	}
	public boolean isEmpty(){
		return (first == null);
	}
	public void add(String k, int i){
			Link newLink = new Link(k,i);
			newLink.next = first;
			first = newLink;
			++countLink;
			
	}
	public int getCountLink(){
		return countLink;
	}
	public String delete(int n)
	{
		String deleted = "";
		if( first.index == n )
		{
			deleted = first.key;
			first = first.next;
		}else{
			Link current = first;
			Link previous = null;
			while(current != null && current.index != n )
			{
				previous = current;
				current = current.next;
			}
			deleted = previous.next.key;
			previous.next = current.next;
			
		}
		
		return deleted;
	
	}
	public void display(){
		Link dis = first;
		while(dis!=null){
			dis.display();
			dis = dis.next;
		}
	}
	public String getElement(int i){
		Link thisLink = first;
		if(!isEmpty()){
            while(thisLink.index != i){
                if(thisLink.next == null){
					break;
                } else {
                    thisLink = thisLink.next;
                }
            }
        } else {
            System.out.println("\t\t[Empty LinkedList]");
        }
		return thisLink.key;
	}
}
