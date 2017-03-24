
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
	public String delete(){
		Link del = first;
		String deleted = "";
		if(countLink>1){
			while(del!=null){
				if(del.next.next == null){
					deleted = del.next.key;
					del.next = null;
				}
				del = del.next;
			}
		}else{
			deleted = first.key;
			first = first.next;
		}
		
		//System.out.println("in LL: "+deleted);
		--countLink;
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
	public static void main(String args[]){
		LinkList l = new LinkList();
		l.add("0", 0);
		l.add("1", 1);
		l.add("2", 2);
		l.add("3", 3);
		l.display();
		System.out.println("----");
		System.out.println("deleted: "+l.delete());
		l.display();
		System.out.println("index 2: "+l.getElement(2));
		
	}
	
}
