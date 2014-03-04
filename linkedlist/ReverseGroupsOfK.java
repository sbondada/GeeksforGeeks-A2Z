package linkedlist;


public class ReverseGroupsOfK 
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
	public void reverseLinkedListInGroups(LinkedList list,int k)
	{
		Node loc=list.head;
		Node temploc=null;
		int inc=1;
		Node temp=null;
		Node temptail=loc;
		Node tempCurrent=null;
		while(inc!=k)
		{
			temploc=loc;
			loc=loc.next;
			temploc.next=tempCurrent;
			tempCurrent=temploc;
			inc++;
		}
		list.head=tempCurrent;
		temptail.next=loc;
		while(loc!=null)
		{
			temploc=null;
            inc=1;
            temp=temptail;
            temptail=loc;
            tempCurrent=null;
            while(inc!=k && loc!=null) 
            {
                temploc=loc;
                loc=loc.next;
                temploc.next=tempCurrent;
                tempCurrent=temploc;
                inc++;
            }
            temp.next=tempCurrent;
            temptail.next=loc;
		}
	}
	public static void main(String args[])
	{
		ReverseGroupsOfK rgok = new ReverseGroupsOfK();
		ReverseGroupsOfK.LinkedList list= rgok.new LinkedList(4);
		list.addNode(5);
		list.addNode(2);
		list.addNode(9);
		list.addNode(7);
		list.addNode(0);
		list.addNode(9);
		list.addNode(12);
		list.addNode(8);
		list.addNode(98);
		list.addNode(12);
		list.addNode(11);
		list.addNode(21);
		list.printList();
		rgok.reverseLinkedListInGroups(list, 4);
		list.printList();
	}
}
