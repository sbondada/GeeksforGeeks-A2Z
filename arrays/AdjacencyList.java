package arrays;

public class AdjacencyList
{
	public HeadNode start;
	public HeadNode currentPointer;
	public AdjacencyList(int headVertex)
	{
		this.start=new HeadNode(headVertex);
		this.currentPointer=this.start;
		this.currentPointer.down=null;
	}
	public void addVertex(int vertex)
	{
		this.currentPointer.down=new HeadNode(vertex);
		this.currentPointer=this.currentPointer.down;
	}
	public void addList(NeighbourList nlist)
	{
		this.currentPointer.neighbourList=nlist;
	}
	public void printVertexNeighbours(int vertex)
	{
		HeadNode inc=this.start;
		while(inc!=null)
		{
			if(inc.vertex==vertex)
			{
				inc.neighbourList.printList();
			}
			inc=inc.down;
		}
	}
	public class NeighbourList
	{
		public NeighbourList(int headNeighbour)
		{
			this.head=new Node(headNeighbour);
			this.current=this.head;
			this.current.next=null;
		}
		public Node head;
		public Node current;
		public void add(int headVertex)
		{
			current.next=new Node(headVertex);
			current=current.next;
			current.next=null;
		}
		public void remove(int headVertex)
		{
			Node inc=head;
			Node incplus =head.next;
			if(inc.vertex==headVertex)
			{
				this.head=inc.next;
				inc.next=null;
			}
			while(incplus!=null)
			{
				if(incplus.vertex==headVertex)
				{
					inc.next=incplus.next;
					incplus.next=null;
				}
				inc=incplus;
				incplus=incplus.next;
			}
		}
		public void printList()
		{
			Node inc=this.head;
			while(inc!=null)
			{
				System.out.print(inc.vertex+" ");
				inc=inc.next;
			}
			System.out.println();
		}
	}
	public class Node
	{
		public Node(int vertex)
		{
			this.vertex=vertex;
		}
		public int vertex;
		public Node next;
	}
	public class HeadNode 
	{
		public HeadNode(int vertex)
		{
			this.vertex=vertex;
		}
		public int vertex;
		public NeighbourList neighbourList;
		public HeadNode down;
	}
	public static void main(String args[])
	{
		AdjacencyList al = new AdjacencyList(1);
		AdjacencyList.NeighbourList tempList=al.new NeighbourList(2);
		tempList.add(3);
		tempList.add(4);
		al.addList(tempList);
		al.addVertex(2);
		tempList=al.new NeighbourList(1);
		tempList.add(5);
		al.addList(tempList);
		al.addVertex(3);
		tempList=al.new NeighbourList(1);
		tempList.add(4);
		tempList.add(5);
		al.addList(tempList);
		al.addVertex(4);
		tempList=al.new NeighbourList(1);
		tempList.add(3);
		tempList.add(6);
		al.addList(tempList);
		al.addVertex(5);
		tempList=al.new NeighbourList(2);
		tempList.add(3);
		tempList.add(6);
		al.addList(tempList);
		al.addVertex(6);
		tempList=al.new NeighbourList(4);
		tempList.add(5);
		al.addList(tempList);
		al.printVertexNeighbours(4);
	}
}
