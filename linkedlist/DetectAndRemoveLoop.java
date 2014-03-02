package linkedlist;

public class DetectAndRemoveLoop 
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
		public LinkedList(Node tempNode,Node current)
		{
			this.head=tempNode;
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
	public boolean checkIfListHasLoop(LinkedList list)
	{
		Node loc=list.head;
		Node fastloc=list.head.next;
		while(fastloc!=null && fastloc.next!=null)
		{
			if(fastloc==loc)
			{
				return true;
			}
			loc=loc.next;
			fastloc=fastloc.next.next;
		}
		return false;
	}
	public Node getHeadOfLoop(LinkedList list)
	{
		Node loc=list.head;
		Node fastloc=list.head.next;
		while(loc!=fastloc)
		{
			loc=loc.next;
			fastloc=fastloc.next.next;
		}
		int looplen=1;
		loc=loc.next;
		while(loc!=fastloc)
		{
			looplen++;
			loc=loc.next;
		}
		loc=list.head;
		Node slowloc=null;
		int inc=1;
		while(loc!=slowloc)
		{
			if(inc>=looplen)
			{
				if(slowloc==null)
				{
					slowloc=list.head;
				}
				else
				{
				slowloc=slowloc.next;
				}
			}
			inc++;
			loc=loc.next;
		}
		return loc;
	}
	public void RemoveLoop(LinkedList list,Node loopHead)
	{
		Node loc=loopHead.next;
		while(loc.next!=loopHead)
		{
			loc=loc.next;
		}
		loc.next=null;
	}
	public static void main(String args[])
	{
		DetectAndRemoveLoop drl = new DetectAndRemoveLoop();
		DetectAndRemoveLoop.LinkedList list= drl.new LinkedList(3);
		list.addNode(2);
		list.addNode(9);
		list.addNode(8);
		list.addNode(0);
		DetectAndRemoveLoop.Node headloop=drl.new Node(83);
		list.current.next=headloop;
		list.current=list.current.next;
		list.addNode(21);
		list.addNode(11);
		list.addNode(8);
		list.addNode(19);
		list.addNode(10);
		list.addNode(99);
		list.addNode(24);
		list.current.next=headloop;
		if(drl.checkIfListHasLoop(list))
		{
			System.out.println("the list has a loop");
            headloop=drl.getHeadOfLoop(list);
            System.out.println("head value "+headloop.val);
            drl.RemoveLoop(list, headloop);
            list.printList();
		}
		else
		{
			System.out.println("no loop in the list");
		}
	}
}
