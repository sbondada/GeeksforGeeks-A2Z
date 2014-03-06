package linkedlist;

public class AlternateSplitOfList 
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
		public LinkedList(Node head,Node current)
		{
			this.head=head;
			this.current=current;
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
	public LinkedList[] splitAlternatetoLists(LinkedList list) 
	{
		Node loc=list.head;
		Node evenhead=null,evencurrent=null;
		Node oddhead=null,oddcurrent=null;
		int inc=0;
		while(loc!=null)
		{
			inc++;
			if(inc==1)
			{
				if(evenhead==null)
				{
					evenhead=loc;
					evencurrent=evenhead;
				}
				else
				{
					evencurrent.next=loc;
					evencurrent=evencurrent.next;
				}
			}
			else if(inc==2)
			{
				if(oddhead==null)
				{
					oddhead=loc;
					oddcurrent=oddhead;
				}
				else
				{
					oddcurrent.next=loc;
					oddcurrent=oddcurrent.next;
				}
				inc=0;
			}
			loc=loc.next;
		}
	 evencurrent.next=null;
	 oddcurrent.next=null;
	 
	 LinkedList splitList[]=new LinkedList[2];
	 splitList[0]=new LinkedList(evenhead,evencurrent);
	 splitList[1]=new LinkedList(oddhead,oddcurrent);
	 return splitList;
	}
	public static void main(String argts[])
	{
		AlternateSplitOfList asol = new AlternateSplitOfList();
		AlternateSplitOfList.LinkedList list=asol.new LinkedList(4);
		list.addNode(6);
		list.addNode(9);
		list.addNode(0);
		list.addNode(9);
		list.addNode(1);
		list.addNode(3);
		list.addNode(4);
		list.addNode(10);
		list.addNode(12);
		list.addNode(32);
		list.printList();
		LinkedList[] splitList=asol.splitAlternatetoLists(list);
		splitList[0].printList();
		splitList[1].printList();
	}
}
