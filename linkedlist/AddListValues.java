package linkedlist;

public class AddListValues 
{
    public class LinkedList
	{
		Node head;
		Node current;
		public LinkedList(int val)
		{
			this.head=new Node(val);
			this.current=this.head;
		}
		public void addNode(int val) 
		{
			this.current.next=new Node(val);
			this.current=this.current.next;
			this.current.next=null;
		}
		public void removeNode(int pos)
		{
			Node loc=this.head;
			int inc=0;
			while(inc!=pos-1)
			{
				loc=loc.next;
				inc++;
			}
			Node temp=loc.next.next;
			loc.next.next=null;
			loc.next=temp;
		}
		public int listSize()
		{
			Node loc=this.head;
			int inc=0;
			while(loc!=null)
			{
				inc++;
				loc=loc.next;
			}
			return inc;
		}
		public void printList()
		{
			Node loc=this.head;
			while(loc!=null)
			{
				System.out.print(loc.val);
				System.out.print(" ");
				loc=loc.next;
			}
			System.out.println();
		}
	}
	public class Node
	{
		int val;
		Node next;
		public Node(int val)
		{
			this.val=val;
			this.next=null;
		}
	}
	public static void main(String args[])
	{
		AddListValues alv = new AddListValues();
		AddListValues.LinkedList list1 = alv.new LinkedList(2);
		list1.addNode(4);
		list1.addNode(5);
		list1.addNode(1);
		list1.printList();
		AddListValues.LinkedList list2 = alv.new LinkedList(3);
		list2.addNode(5);
		list2.addNode(2);
		list2.addNode(2);
		list2.addNode(9);
		list2.printList();
	}
}
