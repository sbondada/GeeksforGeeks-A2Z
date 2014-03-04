package linkedlist;

public class SingularLinkedListSortedInsert 
{
	public class CircularSortedList
	{
		public Node head;
		private Node end;
		public CircularSortedList(int val) 
		{
			this.head=new Node(val);
			this.head.next=this.head;
			this.end=this.head;
		}
		public void insert(int val)
		{
			Node temp=null;
			Node loc=this.head;
			if(val<=loc.val)
			{
//				System.out.println("initial");
				this.head=new Node(val);
				this.head.next=loc;
				this.end.next=this.head;
				return;
			}
			temp=loc;
			loc=loc.next;
			while(val>loc.val && loc!=this.head)
			{
				temp=loc;
				loc=loc.next;
			}	
			temp.next=new Node(val);
            temp.next.next=loc;
			if(loc==this.head)
			{
				this.end=temp.next;
			}
		}
		public void printlist()
		{
			Node loc=this.head.next;
			System.out.print(this.head.val+" ");
			while(loc!=this.head)
			{
				System.out.print(loc.val+" ");
				loc=loc.next;
			}
			System.out.println();
		}
	}
	public class Node 
	{
		public int val;
		public Node next;
		public Node(int val)
		{
			this.val=val;
			this.next=null;
		}
	}
	public static void main(String args[])
	{
		SingularLinkedListSortedInsert slsi = new SingularLinkedListSortedInsert();
		SingularLinkedListSortedInsert.CircularSortedList list = slsi.new CircularSortedList(4);
//		list.printlist();
		list.insert(3);
//		list.printlist();
		list.insert(6);
//		list.printlist();
		list.insert(3);
//		list.printlist();
		list.insert(7);
//		list.printlist();
		list.insert(3);
//		list.printlist();
		list.insert(3);
//		list.printlist();
		list.insert(3);
//		list.printlist();

		
	}
}
