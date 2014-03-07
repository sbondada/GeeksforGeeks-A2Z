package linkedlist;

public class DoublyLinkedList 
{
	public Node head;
	public Node current;
	public class Node
	{
		int val;;
		Node prev;
		Node next;
		public Node(int val,Node prev)
		{
			this.val=val;
			this.prev=prev;
			this.next=null;
		}
	}
	public DoublyLinkedList(int val)  
	{
		this.head=new Node(val, null);
		this.current=this.head;
	}
	public void addNode(int val)
	{
		this.current.next=new Node(val,this.current);
		this.current=this.current.next;
	}
	public void delete(int val)
	{
		Node loc=this.head;
		while(loc!=null)
		{
			if(loc.val==val && loc!=this.head && loc!=this.current)
			{
				Node temp=loc.prev;
				temp.next=loc.next;
				loc.next.prev=temp;
				loc.next=null;
				loc.prev=null;
			}
			if(loc.val==val && loc==this.head)
			{
				Node temp=loc.next;
				temp.prev=null;
				loc.next=null;
				this.head=temp;
			}
			if(loc.val==val && loc ==this.current)
			{
				Node temp=loc.prev;
				loc.prev=null;
				temp.next=null;
				this.current=temp;
			}
			loc=loc.next;
		}
	}
	public void printList()
	{
		Node loc=this.head;
		while(loc!=null)
		{
			System.out.print(loc.val+" ");
			loc=loc.next;
		}
		System.out.println();
	}
	public static void main(String args[])
	{
		DoublyLinkedList list=new DoublyLinkedList(4);
		list.addNode(5);
		list.addNode(8);
		list.addNode(9);
		list.addNode(4);
		list.addNode(7);
		list.addNode(1);
		list.addNode(2);
		list.addNode(10);
		list.addNode(11);
		list.printList();
		list.delete(11);
		list.printList();
	}
}

