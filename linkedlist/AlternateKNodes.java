package linkedlist;

public class AlternateKNodes 
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
	public void	replaceAlternateNodes(LinkedList list,int k)  
	{
		Node loc=list.head.next;
		Node temp=null;
		Node reverseAlternateCurrent=list.head;
		list.head=loc;
		reverseAlternateCurrent.next=null;
		Node reverseAlternateHead=null;
		k--;
		while(k>0)
		{
			temp=loc;
			loc=loc.next;
			temp.next=loc.next;
			reverseAlternateHead=loc;
			loc=temp.next;
			reverseAlternateHead.next=reverseAlternateCurrent;
			reverseAlternateCurrent=reverseAlternateHead;
			k-=2;
		}
		Node revloc=reverseAlternateHead;
		loc=list.head;
		list.head=revloc;
		revloc=revloc.next;
		list.head.next=loc;
		while(revloc!=null)
		{
			temp=loc;
			loc=loc.next;
			temp.next=revloc;
			revloc=revloc.next;
			temp.next.next=loc;
		}
	}
	public static void main(String args[])
	{
		AlternateKNodes akn = new AlternateKNodes();
		AlternateKNodes.LinkedList list = akn.new LinkedList(3);
		list.addNode(2);
		list.addNode(4);
		list.addNode(9);
		list.addNode(7);
		list.addNode(8);
		list.addNode(12);
		list.addNode(19);
		list.addNode(21);
		list.addNode(22);
		list.addNode(32);
		list.addNode(11);
		list.printList();
		int k=7;
		akn.replaceAlternateNodes(list,k);
		list.printList();
	}
}
