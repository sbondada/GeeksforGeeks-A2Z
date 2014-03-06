package linkedlist;

public class CircularRightShift 
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
	public void shiftRight(LinkedList list,int k)
	{
		Node loc=list.head;
		Node temploc=list.head;
		Node revHead = null;
		Node revTail=null;
		while(loc!=null)
		{
			if(k!=-1)
			{
				loc=loc.next;
				k--;
			}
			else
			{
				loc=loc.next;
				temploc=temploc.next;
			}
		}
		revHead=temploc.next;
		revTail=revHead;
		temploc.next=null;
		list.current=temploc;
		temploc=revHead;
		temploc=temploc.next;
		while(temploc!=null)
		{

			Node temp=temploc;
			temploc=temploc.next;
			temp.next=revHead;
			revHead=temp;
		}
		revTail.next=list.head;
		list.head=revHead;
	}
	public static void main(String args[])
	{
		CircularRightShift crs = new CircularRightShift();
		CircularRightShift.LinkedList list = crs.new LinkedList(4);
		list.addNode(6);
		list.addNode(5);
		list.addNode(9);
		list.addNode(7);
		list.addNode(8);
		list.addNode(12);
		list.addNode(78);
		list.addNode(99);
		list.addNode(11);
		list.addNode(8);
		list.printList();
		crs.shiftRight(list, 5);
		list.printList();
	}
}
