package linkedlist;

public class Sort0s1s2s 
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
	public void sort(LinkedList list)
	{
		Node loc=list.head;
		Node head0=null,head1=null,head2=null;
		Node loc0=null,loc1=null,loc2=null;
		while(loc!=null)
		{
			if(loc.val==0)
			{
				if(head0==null)
				{
					head0=loc;
					loc0=loc;
				}
				else
				{
					loc0.next=loc;
					loc0=loc0.next;
				}
			}
			if(loc.val==1)
			{
				if(head1==null)
				{
					head1=loc;
					loc1=loc;
				}
				else
				{
					loc1.next=loc;
					loc1=loc1.next;
				}
			}
			if(loc.val==2)
			{
				if(head2==null)
				{
					head2=loc;
					loc2=loc;
				}
				else
				{
					loc2.next=loc;
					loc2=loc2.next;
				}
			}
			loc=loc.next;
		}
		list.head=head0;
		loc0.next=head1;
		loc1.next=head2;
		loc2.next=null;
	}
	public static void main(String args[])
	{
		Sort0s1s2s s012= new Sort0s1s2s();
		Sort0s1s2s.LinkedList list = s012.new LinkedList(2);
		list.addNode(0);
		list.addNode(2);
		list.addNode(1);
		list.addNode(1);
		list.addNode(0);
		list.addNode(0);
		list.addNode(0);
		list.addNode(1);
		list.addNode(1);
		list.addNode(2);
		list.addNode(2);
		list.addNode(2);
		list.printList();
		s012.sort(list);
		list.printList();
	}
}
