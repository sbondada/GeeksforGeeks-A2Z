package linkedlist;

public class ReverseAndAppendAltNodes 
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
	public void ReverseAlternateNodes(LinkedList list)
	{
		Node head2=null;
		Node head1=list.head;
		Node loc=head1.next;
        Node locminus=head1;
		while(loc!=null)
		{
            locminus.next=loc.next;
            loc.next=head2;
            head2=loc;
			locminus=locminus.next;
			loc=locminus.next;
		}
		locminus.next=head2;
	}
	public static void main(String args[])
	{
		ReverseAndAppendAltNodes raan=new ReverseAndAppendAltNodes();
		ReverseAndAppendAltNodes.LinkedList list=raan.new LinkedList(3);
		list.addNode(4);
		list.addNode(6);
		list.addNode(9);
		list.addNode(2);
		list.addNode(7);
		list.addNode(1);
		list.printList();
		raan.ReverseAlternateNodes(list);
		list.printList();
	}
}
