package linkedlist;

public class SegregateEvenOdds 
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
	public void segregateevenodds(LinkedList list)
	{
		Node evenHead=null;
		Node oddHead=null;
		Node evenCurrent=null;
		Node oddCurrent=null;
		Node loc=list.head;
		while(loc!=null)
		{
			if(loc.val%2==0)
			{
				if(evenHead==null)
				{
					evenHead=loc;
					evenCurrent=evenHead;
				}
				else
				{
					evenCurrent.next=loc;
					evenCurrent=evenCurrent.next;
				}
			}
			else
			{
				if(oddHead==null)
				{
					oddHead=loc;
					oddCurrent=oddHead;
				}
				else
				{
					oddCurrent.next=loc;
					oddCurrent=oddCurrent.next;
				}
			}
			loc=loc.next;
		}
		list.head=evenHead;
		evenCurrent.next=oddHead;
		oddCurrent.next=null;
		list.current=oddCurrent;
	}
	public static void main(String args[])
	{
		SegregateEvenOdds seo = new SegregateEvenOdds();
		SegregateEvenOdds.LinkedList list= seo.new LinkedList(3);
		list.addNode(4);
		list.addNode(5);
		list.addNode(8);
		list.addNode(9);
		list.addNode(12);
		list.addNode(23);
		list.addNode(54);
		list.addNode(98);
		list.addNode(82);
		list.addNode(38);
		list.addNode(83);
		list.addNode(41);
		list.addNode(47);
		list.printList();
		seo.segregateevenodds(list);
		list.printList();
	}
}
