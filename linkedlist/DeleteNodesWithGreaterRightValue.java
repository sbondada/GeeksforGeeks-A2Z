package linkedlist;

import java.util.List;

import org.w3c.dom.ls.LSInput;

public class DeleteNodesWithGreaterRightValue 
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
	public void deleteGreaterRightValue(LinkedList list)
	{
		Node loc=list.head;
		Node locminus=null;
		Node temp=null;
		while(loc.next!=null)
		{
			if(loc.val<loc.next.val)
			{
				if(locminus!=null)
				{
					locminus.next=loc.next;
					temp=loc;
					loc=loc.next;
					temp.next=null;
				}
				else
				{
					list.head=loc.next;
					temp=loc;
					loc=loc.next;
					temp.next=null;
				}
			}
			else
			{
				if(locminus!=null)
				{
					locminus=locminus.next;
                    loc=loc.next;
				}
				else
				{
					locminus=loc;
					loc=loc.next;
				}
			}
		}
	}
	public static void main(String args[])
	{
		DeleteNodesWithGreaterRightValue dngrv = new DeleteNodesWithGreaterRightValue();
		DeleteNodesWithGreaterRightValue.LinkedList list = dngrv.new LinkedList(3);
		list.addNode(4);
		list.addNode(5);
		list.addNode(8);
		list.addNode(9);
		list.addNode(3);
		list.addNode(98);
		list.addNode(23);
		list.addNode(11);
		list.addNode(45);
		list.addNode(22);
		list.addNode(14);
		list.addNode(4);
		list.printList();
		dngrv.deleteGreaterRightValue(list);
		list.printList();
	}
}
