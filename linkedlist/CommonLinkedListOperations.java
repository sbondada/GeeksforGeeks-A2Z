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
		list.addNode(1);
		list.addNode(13);
		list.addNode(18);
		list.addNode(19);
		list.addNode(17);
		list.addNode(14);
		list.addNode(15);
		list.printList();
//		CommonLinkedListOperations.temp=list.Head;
//		boolean checkCondition=cllo.isListPalindrome(list.Head);
//		System.out.println(checkCondition);
		cllo.swapElementsInLists(list);
		list.printList();
	}
}
