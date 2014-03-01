package linkedlist;

public class SkipLIst 
{
	final int SKIPVALUE;
	int skip;
	SplNode skipHead;
	SplNode skipCurrent;
	RegNode head;
	RegNode current;
	
	public class RegNode
	{
		public int val;
		public RegNode next;
		public RegNode(int val)
		{
			this.val=val;
			this.next=null;
		}
	}
	public class SplNode
	{
		public RegNode down;
		public SplNode next;
		public SplNode(RegNode node)
		{
			this.down=node;
			this.next=null;
		}
	}
	public SkipLIst(int val,int skip)
	{
		this.head=new RegNode(val);
		this.current=this.head;
		this.skipHead=new SplNode(this.head);
		this.skipCurrent=this.skipHead;
		this.SKIPVALUE=skip;
		this.skip=this.SKIPVALUE;
	}
	public void addNode(int val)
	{
		this.current.next=new RegNode(val);
		this.current=this.current.next;
		this.skip--;
		if(skip==0)
		{
			this.skipCurrent.next=new SplNode(this.current);
			this.skipCurrent=this.skipCurrent.next;
			this.skip=this.SKIPVALUE;
		}
	}
	public void printList()
	{
		RegNode loc=this.head;
		while(loc!=null)
		{
			System.out.print(loc.val+" ");
			loc=loc.next;
		}
		System.out.println();
	}
	public void printSkipList()
	{
		SplNode loc=this.skipHead;
		while(loc!=null)
		{
			System.out.print(loc.down.val+" ");
			loc=loc.next;
		}
		System.out.println();
	}
	public int search(int pos)
	{
		int skippos=0;
		SplNode loc=this.skipHead;
		while(skippos+this.SKIPVALUE<=pos)
		{
			skippos=skippos+this.SKIPVALUE;
			loc=loc.next;
		}
		RegNode loc1=loc.down;
		while(skippos<pos && loc1!=null)
		{
			skippos++;
			loc1=loc1.next;
		}
		return loc1.val;
	}
	public static void main(String args[])
	{
		SkipLIst sl = new SkipLIst(2, 5);
		sl.addNode(3);
		sl.addNode(4);
		sl.addNode(7);
		sl.addNode(9);
		sl.addNode(0);
		sl.addNode(12);
		sl.addNode(67);
		sl.addNode(87);
		sl.addNode(23);
		sl.addNode(9);
		sl.addNode(6);
		sl.addNode(10);
		sl.addNode(72);
		sl.addNode(98);
		sl.addNode(11);
		sl.addNode(21);
		sl.addNode(32);
		sl.addNode(39);
		sl.addNode(33);
		sl.addNode(22);
		sl.printList();
		sl.printSkipList();
		System.out.println(sl.search(9));
	}


}
