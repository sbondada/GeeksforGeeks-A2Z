package linkedlist;

public class IntersectionList 
{
	public class LinkedList
	{
		Node head;
		public LinkedList(int val)
		{
			this.head=new Node(val);
		}
		public void addNode(int val)
		{
			Node temp=new Node(val);
			temp.next=this.head;
			this.head=temp;
		}
		public void addNode(Node temp)
		{
			temp.next=this.head;
			this.head=temp;
		}
		public void printList()
		{
			Node temp=this.head;
			while(temp!=null)
			{
				System.out.print(temp.val+" ");
				temp=temp.next;
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
	public Node getIntersectionPoint(Node curr1, Node curr2)
	{
		Node temp1=curr1;
		Node temp2=curr2;
		int length1=0,length2=0;
		while(temp1!=null)
		{
			temp1=temp1.next;
			length1++;
		}
		while(temp2!=null)
		{
			temp2=temp2.next;
			length2++;
		}
		if(length1>length2)
		{
			int inc=0;
			while(inc<length1-length1)
			{
				curr1=curr1.next;
				inc++;
			}
		}
		else
		{
			int inc=0;
			while(inc<length2-length1)
			{
				curr2=curr2.next;
				inc++;
			}
		}
		while(!curr1.equals(curr2))
		{
			curr1=curr1.next;
			curr2=curr2.next;
		}
		return curr1;
	}
	public static void main(String args[])
	{
		IntersectionList il = new IntersectionList();
		IntersectionList.LinkedList list = il.new LinkedList(7);
		list.addNode(19);
		list.addNode(16);
		list.addNode(4);
		list.addNode(5);
		list.addNode(11);
		Node temp=il.new Node(23);
		list.addNode(temp);
		list.addNode(12);
		list.addNode(6);
		list.addNode(2);
		list.addNode(0);
		list.addNode(9);
		list.printList();
	}
}
