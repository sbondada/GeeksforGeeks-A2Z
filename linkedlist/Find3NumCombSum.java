package linkedlist;

public class Find3NumCombSum 
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
	public int[] matchSumFromLists(LinkedList list1,LinkedList list2, LinkedList list3,int sum)
	{
		Node loc1=list1.head;
		int[] array= new int[3];
		while(loc1!=null)
		{
			Node loc2=list2.head;
			while(loc2!=null)
			{
				Node loc3= list3.head;
				while(loc3!=null)
				{
					if(loc1.val+loc2.val+loc3.val==sum)
					{
						array[0]=loc1.val;
						array[1]=loc2.val;
						array[2]=loc3.val;
						return array;
					}
				loc3=loc3.next;
				}
			loc2=loc2.next;
			}
		loc1=loc1.next;
		}
		return null;
	}
	public static void main(String args[])
	{
		Find3NumCombSum fncs = new Find3NumCombSum();
		Find3NumCombSum.LinkedList list1 = fncs.new LinkedList(1);
		list1.addNode(2);
		list1.addNode(8);
		list1.addNode(6);
		list1.addNode(3);
		list1.addNode(1);
		list1.addNode(9);
		list1.addNode(8);
		list1.addNode(6);
		Find3NumCombSum.LinkedList list2 = fncs.new LinkedList(3); 
		list2.addNode(4);
		list2.addNode(12);
		list2.addNode(8);
		list2.addNode(9);
		list2.addNode(0);
		list2.addNode(7);
		list2.addNode(1);
		list2.addNode(2);
		Find3NumCombSum.LinkedList list3 = fncs.new LinkedList(0); 
		list3.addNode(2);
		list3.addNode(1);
		list3.addNode(9);
		list3.addNode(7);
		list3.addNode(5);
		list3.addNode(3);
		list3.addNode(0);
		list1.printList();
		list2.printList();
		list3.printList();
		int[] array=fncs.matchSumFromLists(list1, list2, list3, 18);
		if(array!=null)
		{
			for(int i=0;i<array.length;i++)
			{
				System.out.print(array[i]+" ");
			}
		}
	}
}
