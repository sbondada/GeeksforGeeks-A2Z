package linkedlist;

public class StackWithMiddleElement 
{
	public class Stack
	{
		Node top;
		Node middle;
		private int pushcounter;
		private int popcounter;
		public Stack(int val)
		{
			this.pushcounter=0;
			this.popcounter=0;
			this.top=new Node(val);
			this.middle=top;
		}
		public void push(int val)
		{
			System.out.println("push "+val);
			this.top.next=new Node(val);
			this.top.next.previous=this.top;
			this.top=this.top.next;
			this.pushcounter++;
			if(this.popcounter!=0)
			{
				this.popcounter++;
			}
			if(pushcounter==2)
			{
				pushcounter=0;
				middle=middle.next;
			}
		}
		public int pop()
		{
			int val=this.top.val;
			System.out.println("pop "+val);
			Node temp=this.top;
			this.top=this.top.previous;
			this.top.next=null;
			temp.previous=null;
			this.popcounter--;
			if(this.pushcounter!=0)
			{
				this.pushcounter--;
			}
			if(popcounter==-2)
			{
				popcounter=0;
				middle=middle.previous;
			}
			return val;
		}
		public int getMiddleElement()
		{
			System.out.println("middle "+middle.val);
			return middle.val;
		}
		public void printStack()
		{
			Node loc=this.top;
			while(loc!=null)
			{
				System.out.print(loc.val+" ");
				loc=loc.previous;
			}
			System.out.println();
		}
	}
	public class Node
	{
		int val;
		Node next;
		Node previous;
		public Node(int val)
		{
			this.previous=null;
			this.val=val;
			this.next=null;
		}
	}
	public static void main(String args[])
	{
		StackWithMiddleElement sme= new StackWithMiddleElement();
		StackWithMiddleElement.Stack s1= sme.new Stack(2);
		s1.push(3);
		s1.push(4);
		s1.push(5);
		s1.push(7);
		s1.push(8);
		s1.push(9);
		s1.printStack();
		s1.pop();
		s1.push(12);
		s1.pop();
		s1.printStack();
		System.out.println(s1.getMiddleElement());
		s1.pop();
		s1.printStack();
		System.out.println(s1.getMiddleElement());
	}
}
