package linkedlist;

public class UnionIntersectionOfList 
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
		public LinkedList(Node head,Node current)
		{
			this.head=head;
			this.current=current;
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
	public LinkedList Intersection(LinkedList list1,LinkedList list2)
	{
		Node loc1=list1.head;
		Node temp1=null,temp2=null;
		Node loc2=list2.head;
		Node intersectionHead=null;
		Node intersectionCurrent=null;
		while(loc1!=null)
		{
			loc2=list2.head;
			while(loc2!=null)
			{
				if(loc1.val==loc2.val)
				{
					if(intersectionHead==null)
					{
						intersectionHead=loc1;
						intersectionCurrent=intersectionHead;
					}
					else
					{
						temp1.next=null;
						intersectionCurrent.next=loc1;
						intersectionCurrent=intersectionCurrent.next;
					}
				}
				loc2=loc2.next;
			}
			temp1=loc1;
			loc1=loc1.next;
		}
		intersectionCurrent.next=null;
		return this.new LinkedList(intersectionHead,intersectionCurrent);
	}
	public LinkedList Union(LinkedList list1,LinkedList list2)
	{
		Node loc1=list1.head;
		Node loc2=list2.head;
		Node temp2=null;
		Node unionHead =list1.head;
		Node unionCurrent = list1.current;
		while(loc2!=null)
		{
			loc1=unionHead;
			Boolean found=false;
			while(loc1!=null)
			{
//				System.out.print(loc1.val+" ");
				if(loc1.val==loc2.val)
				{
					found=true;
				}
				loc1=loc1.next;
			}
			if(found==false)
			{
				if(temp2!=null)
				{
                    temp2.next=null;
				}
				unionCurrent.next=loc2;
				unionCurrent=unionCurrent.next;
			}
//			System.out.println();
			temp2=loc2;
			loc2=loc2.next;
			if(found==false)
			{
				unionCurrent.next=null;
			}
		}
		return this.new LinkedList(unionHead,unionCurrent);
	}
	public static void main(String args[])
	{
	UnionIntersectionOfList uil= new UnionIntersectionOfList();
	UnionIntersectionOfList.LinkedList list1=uil.new LinkedList(3);
	list1.addNode(2);
	list1.addNode(4);
	list1.addNode(8);
	list1.addNode(9);
	list1.addNode(5);
	list1.addNode(12);
	list1.printList();
	UnionIntersectionOfList.LinkedList list2=uil.new LinkedList(4);
	list2.addNode(3);
	list2.addNode(7);
	list2.addNode(10);
	list2.addNode(6);
	list2.addNode(9);
	list2.printList();
//	LinkedList intersectionList=uil.Intersection(list1, list2);
//	intersectionList.printList();
	LinkedList unionList=uil.Union(list1, list2);
	unionList.printList();
	}
}
