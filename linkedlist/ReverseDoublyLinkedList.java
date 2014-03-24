package linkedlist;

public class ReverseDoublyLinkedList 
{
	Node head;
	Node current;
	public ReverseDoublyLinkedList(int val) 
	{
		this.head=new Node(val);
		this.current=this.head;
	}
	public void addNode(int val)
	{
		this.current.next=new Node(val);
		this.current=this.current.next;
	}
	public void printList()
	{
		Node temp=this.head;
		while(temp!=null)
		{
			System.out.print(temp.val+" ");
			temp=temp.next;
		}
		System.out.println();
	}
	public Node reccurReverse(Node curr,Node prev) 
	{
		if(curr==null)
		{
			prev.prev=null;
			return null;
		}
		else
		{
			Node tempNext=curr.next;
			curr.next=prev;
			Node temp=reccurReverse(tempNext, curr);
			curr.prev=temp;
			return curr;
		}
	}
	public void recurrev()
	{
		reccurReverse(this.head,null);
		Node temp;
		temp=this.head;
		this.head=this.current;
		this.current=temp;
	}
	public void IterativeReverse()
	{
		Node temp1=this.head;
		Node temp2=temp1.next;
		Node temp3=temp2.next;
		temp2.next=temp1;
		temp2.prev=temp3;
		temp1.next=null;
		temp1.prev=temp2;
		temp1=temp2;
		temp2=temp3;
		temp3=temp3.next;
		while(temp3!=null)
		{
			temp2.next=temp1;
			temp2.prev=temp3;
			temp1=temp2;
			temp2=temp3;
			temp3=temp3.next;
		}
		temp2.next=temp1;
		temp2.prev=null;
		this.current=this.head;
		this.head=temp2;
	}
	public class Node
	{
		Node next;
		Node prev;
		int val;
		public Node(int val)
		{
			this.val=val;
			this.next=null;
			this.prev=null;
		}
	}
	public static void main(String args[])
	{
		ReverseDoublyLinkedList rdll = new ReverseDoublyLinkedList(4);
		rdll.addNode(3);
		rdll.addNode(6);
		rdll.addNode(9);
		rdll.addNode(7);
		rdll.addNode(10);
		rdll.addNode(23);
		rdll.addNode(56);
		rdll.addNode(22);
		rdll.addNode(88);
		rdll.addNode(11);
		rdll.addNode(12);
		rdll.printList();
//		rdll.IterativeReverse();
//		rdll.printList();
		rdll.recurrev();
		rdll.printList();
	}
}
