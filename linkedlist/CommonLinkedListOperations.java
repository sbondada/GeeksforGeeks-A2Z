package linkedlist;

public class CommonLinkedListOperations 
{
	static Node temp;
	public class LinkedList
	{
		Node Head;
		Node Current;
		public LinkedList(int val)
		{
			this.Head=new Node(val);
			this.Current=this.Head;
		}
		public void addNode(int val)
		{
			this.Current.next=new Node(val);
			this.Current=this.Current.next;
		}
		public void printList()
		{
			Node temp=this.Head;
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
	//recursive method for reversals still not yet completed
	public void ReccurReverse(Node curr)
	{
		if(curr!=null)
		{
			if(curr.next!=null)
			{
				curr=curr.next.next;
				ReccurReverse(curr);
			}
			else
			{
				return;
			}
			int transval=temp.val;
			temp.val=curr.val;
			curr.val=transval;
			temp=temp.next.next;
		}
		else
		{
			return;
		}
	}
	// code to reverse the alternate node in a linked list
	public void ReverseAlternatesInList(LinkedList list)
	{
		Node start1=list.Head;
		Node current1=start1;
		Node start2=list.Head.next; 
		Node current2=start2;
		start1.next=start1.next.next;
		current1=current1.next;
		current2.next=null;
		while(current1!=null && current1.next!=null)
		{
			Node temp=current1.next;
			current1.next=current1.next.next;
			temp.next=current2;
			current2=temp;
			current1=current1.next;
		}
		start2=current2;
		Node temp1=start1;
		Node temp2=start2;
		while(temp1!=null && temp2!=null)
		{
			Node temp=temp1.next;;
			temp1.next=temp2;
			Node tmp=temp2.next;
			temp2.next=temp;
			temp1=temp;
			temp2=tmp;
		}
		list.printList();
		if(temp1==null)
		{
			
		}
	}
	//function to find the intesection point
	public Node findPointOfIntersection(LinkedList list)
	{
		Node temp1=list.Head, temp2=temp1.next;
		while(temp1!=temp2)
		{
			temp1=temp1.next;
			temp2=temp2.next.next;
		}
		int looplen=1;
		temp2=temp2.next;
		while(temp1!=temp2)
		{
			temp2=temp2.next;
			looplen++;
		}
		temp2=list.Head;
		while(looplen!=0)
		{
			temp2=temp2.next;
			looplen--;
		}
		temp1=list.Head;
		while(temp1!=temp2)
		{
			temp1=temp1.next;
			temp2=temp2.next;
		}
		return temp1;
	}
	
	public void reverseGroupOfN(LinkedList list, int k)
	{
		Node start=null,End=null;
		Node temp1=list.Head;
		Node temp2=temp1.next;
		Node temp3= temp2.next;
//		while()
	}
	//swapping the alternate elements
		public void swapElementsInLists(LinkedList list)
		{
			Node t1=null;
			Node t2=list.Head;
			Node t3=t2.next;
			t2.next=t3.next;
			t3.next=t2;
			list.Head=t3;
			while(true)
			{
				t1=t2;
				t2=t2.next;
				t3=t2.next;
				if(t3!=null)
				{
				t2.next=t3.next;
				t3.next=t2;
				t1.next=t3;
				}
				else
				{
					break;
				}
			}
		}
	// reversing a linked list using reccursions imp reursion method
	public boolean isListPalindrome(Node curr)
	{
		if(curr!=null)
		{
			boolean tempcond=isListPalindrome(curr.next);
			if(tempcond==true)
			{
				if(temp.val==curr.val)
				{
					temp=temp.next;
					return true;
				}
				else
				{
					temp=temp.next;
					return false;
				}
			}
			else
			{
				return false;
			}
		}
		else
		{
			return true;
		}
	}
	public static void main(String args[])
	{
		CommonLinkedListOperations cllo = new CommonLinkedListOperations();
		CommonLinkedListOperations.LinkedList list = cllo.new LinkedList(5);	
		list.addNode(4);
		list.addNode(7);
		list.addNode(9);
		list.addNode(8);
		list.addNode(3);
//		Node temp=cllo.new Node(29);
//		list.Current.next=temp;
//		list.Current=list.Current.next;
		list.addNode(1);
		list.addNode(13);
		list.addNode(18);
		list.addNode(19);
		list.addNode(17);
		list.addNode(14);
		list.addNode(15);
//		list.Current.next=temp;
		list.printList();
//		CommonLinkedListOperations.temp=list.Head;
//		boolean checkCondition=cllo.isListPalindrome(list.Head);
//		System.out.println(checkCondition);
//		cllo.swapElementsInLists(list);
//		list.printList();
//		Node intNode=cllo.findPointOfIntersection(list);
//		System.out.println(intNode.val);
		cllo.ReverseAlternatesInList(list);
	}
}
