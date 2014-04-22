package linkedlist;

public class MergeSort 
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
		public LinkedList(Node tempNode,Node current)
		{
			this.head=tempNode;
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
	public LinkedList frontBackSplit(LinkedList list) 
	{
		Node loc=list.head;
		Node fastloc=list.head;
		Node frontListCurrent=null,backListCurrent=null;
		//imp condition to remember 
		Node temp1=null;
		Node temp2=null;
		while(fastloc!=null && fastloc.next!=null) 
		{
			temp1=loc;
			loc=loc.next;
			temp2=fastloc.next;
			fastloc=fastloc.next.next;
		}
//		System.out.println(loc.val);
//		System.out.println(fastloc.val);
		LinkedList listb=null;
		if(fastloc==null)
		{
			frontListCurrent=temp1;
			backListCurrent=temp2;
            list.current=frontListCurrent;
            listb=this.new LinkedList(loc, backListCurrent);
            frontListCurrent.next=null;
		}
		else
        {
			frontListCurrent=loc;
			backListCurrent=fastloc;
            list.current=frontListCurrent;
		    listb=this.new LinkedList(loc.next, backListCurrent);
		    frontListCurrent.next=null;
		}
		return listb;
	}
	
	public LinkedList Merge(LinkedList list1,LinkedList list2)
	{
		Node loc1=list1.head;
		Node loc2=list2.head;
		Node mergeNodeHead=null;
		Node mergeCurrent=null;
		LinkedList mergelist;
		if(loc1.val<=loc2.val)
		{
			mergeNodeHead=loc1;
			mergeCurrent=mergeNodeHead;
			loc1=loc1.next;
		}
		else
		{
			mergeNodeHead=loc2;
			mergeCurrent=mergeNodeHead;
			loc2=loc2.next;
		}
		while(loc1!=null && loc2!=null)
		{
			if(loc1.val<=loc2.val)
			{
				mergeCurrent.next=loc1;
				mergeCurrent=mergeCurrent.next;
				loc1=loc1.next;
			}
			else
			{
				mergeCurrent.next=loc2;
				mergeCurrent=mergeCurrent.next;
				loc2=loc2.next;
			}
		}
		if(loc1==null)
		{
			mergeCurrent.next=loc2;
			mergeCurrent=list2.current;
		}
		else
		{
			mergeCurrent.next=loc1;
			mergeCurrent=list1.current;
		}
		mergelist=this.new LinkedList(mergeNodeHead, mergeCurrent);
		return mergelist;
		
	}
	public LinkedList Sort(LinkedList list)
	{
		if(list.head.next!=null)
		{
		LinkedList listb=this.frontBackSplit(list);
		list=this.Sort(list);
		listb=this.Sort(listb);
		return this.Merge(list, listb);
		}
		else
		{
			return list;
		}
	}
	public static void main(String args[])
	{
		MergeSort ms = new MergeSort();
		MergeSort.LinkedList list = ms.new LinkedList(2);
		list.addNode(3);
		list.addNode(5);
		list.addNode(7);
		list.addNode(8);
		list.addNode(10);
		list.addNode(4);
		list.addNode(6);
		list.addNode(9);
		list.addNode(11);
		list.addNode(21);
//		list.addNode(27);
		list.printList();
		MergeSort.LinkedList listb=ms.frontBackSplit(list);
		list.printList();
		listb.printList();
		LinkedList mergelist=ms.Merge(list, listb);
//		mergelist.addNode(31);
		mergelist.printList();
		LinkedList sortedList=ms.Sort(list);
		sortedList.printList();
	}
}
