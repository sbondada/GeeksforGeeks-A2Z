package linkedlist;

public class PairwiseSwap 
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
		}
	}
	public void swapPairwise(LinkedList list)
	{
		Node loc=list.head;
		Node locplus=list.head.next;
		loc.next=locplus.next;
		locplus.next=loc;
		list.head=locplus;
        locplus=loc.next.next;
        Node temp=loc;
        loc=loc.next;
		while(loc!=null)
		{
			loc.next=locplus.next;
			locplus.next=loc;
			temp.next=locplus;
			temp=loc;
			if(loc.next!=null)
			{
                locplus=loc.next.next;
                loc=loc.next;
			}
			else
			{
				break;
			}
		}
	}
	public static void main(String args[])
	{
		PairwiseSwap ps = new PairwiseSwap();
		PairwiseSwap.LinkedList list = ps.new LinkedList(1);
		list.addNode(2);
		list.addNode(3);
		list.addNode(4);
		list.addNode(5);
		list.addNode(6);
		list.addNode(7);
		list.addNode(8);
		list.printList();
		ps.swapPairwise(list);
		list.printList();

	}
}
