package linkedlist;

public class MergeList 
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
	public void  mergelists(LinkedList list1,LinkedList list2)
	{
		Node loc1=list1.head;
		Node temp1;
		Node loc2=list2.head;
		Node temp2;
		while(loc1.next!=null && loc2!=null)
		{
            temp2=loc2;
            temp1=loc1.next;
			loc2=loc2.next;
			loc1.next=temp2;
			temp2.next=temp1;
			loc1=temp1;
			list1.printList();
		}
		if (loc1.next==null)
		{
			loc1.next=loc2;
		}
	}
	public static void main(String args[])
	{
		MergeList ml = new MergeList();
		MergeList.LinkedList list1= ml.new LinkedList(1);
		list1.addNode(2);
		list1.addNode(3);
		list1.addNode(4);
		list1.addNode(5);
		list1.addNode(6);
		list1.addNode(7);
		list1.addNode(8);
		list1.printList();
		MergeList.LinkedList list2= ml.new LinkedList(10);
		list2.addNode(11);
		list2.addNode(12);
		list2.addNode(13);
		list2.addNode(14);
		list2.addNode(15);
		list2.addNode(16);
		list2.addNode(17);
		list2.addNode(18);
		list2.printList();
		ml.mergelists(list1, list2);
		list1.printList();
	}
}
