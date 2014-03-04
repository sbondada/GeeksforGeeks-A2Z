package linkedlist;

public class MatchTwoLinkedLists 
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
	public boolean findMatch(Node node1,Node node2)
	{
		if(node1==null && node2==null)
		{
			return true;
		}
		if((node1==null && node2!=null) || (node2==null && node1!=null) || (node1.val!=node2.val))
		{
			return false;
		}
		if(node1.val==node2.val && node1!=null && node2!=null)
		{
			node1=node1.next;
			node2=node2.next;
			return findMatch(node1, node2);
		}
		return false;
	}
	public static void main(String args[])
	{
		MatchTwoLinkedLists mtll = new MatchTwoLinkedLists();
		MatchTwoLinkedLists.LinkedList list1= mtll.new LinkedList(4);
		list1.addNode(6);
		list1.addNode(6);
		list1.addNode(6);
		list1.addNode(5);
		list1.addNode(6);
		list1.addNode(6);
		list1.addNode(6);
		list1.printList();
		MatchTwoLinkedLists.LinkedList list2= mtll.new LinkedList(4);
		list2.addNode(6);
		list2.addNode(6);
		list2.addNode(6);
		list2.addNode(5);
		list2.addNode(6);
		list2.addNode(6);
		list2.addNode(6);
		list2.printList();
		System.out.println(mtll.findMatch(list1.head,list2.head));
		
	}
}
