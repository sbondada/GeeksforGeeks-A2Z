package linkedlist;

public class RotateList 
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
	public void rotate(LinkedList list,int k)
	{
		Node loc=list.head;
		for(int i=1;i<k;i++)
		{
			loc=loc.next;
		}
		Node head1=list.head;
		list.head=loc.next;
		loc.next=null;
		loc=list.head;
        while(loc.next!=null)
		{
			loc=loc.next;
		}
        loc.next=head1;
	}
	public static void main(String args[])
	{
		RotateList rl = new RotateList();
		RotateList.LinkedList list = rl.new LinkedList(3);
		list.addNode(4);
		list.addNode(2);
		list.addNode(6);
		list.addNode(9);
		list.addNode(8);
		list.addNode(5);
		list.addNode(7);
		list.addNode(10);
		list.addNode(11);
		list.addNode(21);
		list.addNode(17);
		list.printList();
		rl.rotate(list, 3);
		list.printList();
	}
}
