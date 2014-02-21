package linkedlist;

public class DeleteMnodesafterN 
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
	public void deleteMafterN(LinkedList list,int M,int N)
	{
		Node loc=list.head;
		int inc=1;
		Node temp;
		while(loc!=null)
		{
			if(inc==N)
			{
				temp=loc;
				for(int i=0;i<M && loc.next!=null;i++)
				{
					loc=loc.next;
				}
				temp.next=loc.next;
			}
			inc++;
			loc=loc.next;
			
		}
	}
	public static void main(String args[])
	{
		DeleteMnodesafterN dman = new DeleteMnodesafterN();
		DeleteMnodesafterN.LinkedList list = dman.new LinkedList(1);
		list.addNode(2);
		list.addNode(3);
		list.addNode(4);
		list.addNode(5);
		list.addNode(6);
		list.addNode(7);
		list.addNode(8);
		list.printList();
		dman.deleteMafterN(list, 7, 3);
		list.printList();
	}
}
