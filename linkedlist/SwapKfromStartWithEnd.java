package linkedlist;

public class SwapKfromStartWithEnd 
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
    public void swapvalKfromStartandEnd(LinkedList list,int k)
	{
		Node loc1=list.head;
		Node loc2=null;
		Node temp1=null;
		Node temp2=null;
		int inc=1;
		if(k>1 && k<list.listSize()+1)
		{
                while(loc1!=null)
                {
                        if(inc==k)
                        {
                                temp1=loc1;
                                loc2=list.head;
                        }
                        if(inc>k)
                        {
                                loc2=loc2.next;
                        }
                        loc1=loc1.next;
                        inc++;
                }
                temp2=loc2;
                int temp=temp1.val;
                temp1.val=temp2.val;
                temp2.val=temp;
		}
		else
		{
			System.out.println("enter the k gretaer than 0 less equal to "+list.listSize());
		}
    }

	public void swapNodeKfromStartandEnd(LinkedList list,int k)
	{
		Node loc1=list.head;
		Node loc2=null;
		Node temp1=null;
		Node temp2=null;
		int inc=1;
		while(loc1!=null)
		{
			if(inc==k-1)
			{
				temp1=loc1;
			}
			if(inc==k+1)
			{
				loc2=list.head;
			}
			if(inc>k+1)
			{
				loc2=loc2.next;
			}
			loc1=loc1.next;
			inc++;
		}

	}
	
	public static void main(String args[])
	{
		SwapKfromStartWithEnd sswe = new SwapKfromStartWithEnd();
		SwapKfromStartWithEnd.LinkedList list= sswe.new LinkedList(3);
		list.addNode(4);
		list.addNode(5);
		list.addNode(6);
		list.addNode(9);
		list.addNode(3);
		list.addNode(0);
		list.addNode(10);
		list.printList();
		System.out.println("length of list "+list.listSize());
		sswe.swapvalKfromStartandEnd(list, -1);
		list.printList();
	}

}
