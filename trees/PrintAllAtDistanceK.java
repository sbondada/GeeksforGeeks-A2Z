package trees;


public class PrintAllAtDistanceK 
{
	public class BinaryTree
	{
		public Node root;
		public BinaryTree(int val)
		{
			this.root=new Node(val);
		}
		public void addNode(int val)
		{
			Node temp=null;
			Node loc=this.root;
			while(loc!=null)
			{
				if(val>loc.val)
				{
					temp=loc;
					loc=loc.right;
				}
				else
				{
					temp=loc;
					loc=loc.left;
				}
			}
//			System.out.println(temp.val);
			if(temp.val<val)
			{
				temp.right=new Node(val);
			}
			else
			{
				temp.left=new Node(val);
			}
		}
		public void printDFSTree(Node loc)
		{
			if(loc==null)
			{
				System.out.println("_\t");
				return;
			}
			else
			{
				System.out.println(loc.val+" \t");
				printDFSTree(loc.left);
				printDFSTree(loc.right); 
			}
		}
		public void printTree(String type)
		{
			Node loc=this.root;
			if(type=="DFS")
			{
				printDFSTree(loc);
			}
		}
	}
	public class Node
	{
		public int val;
		public Node left;
		public Node right;
		public Node(int val) 
		{
			this.val=val;
			this.left=null;
			this.right=null;
		}
		public void setLeftNode(int val)
		{
			this.left=new Node(val);
		}
		public void setrightNOde(int val)
		{
			this.right=new Node(val);
		}
	}
	public void printlevelNodes(Node loc,int current,int k)
	{
		if(current==k && loc!=null)
		{
			System.out.println(loc.val);
			return;
		}
		if(loc!=null)
		{
			current++;
			printlevelNodes(loc.left, current,k);
			printlevelNodes(loc.right, current,k);
		}
		else
		{
			return;
		}
	}
	
	public void printNodeAtkLevel(BinaryTree tree,int k)
	{
		Node loc=tree.root;
		int current=0;
		this.printlevelNodes(loc,current,k);
	}
	
	public static void main(String args[])
	{
		PrintAllAtDistanceK padk= new PrintAllAtDistanceK();
		PrintAllAtDistanceK.BinaryTree tree= padk.new BinaryTree(65);
		tree.addNode(42);
		tree.addNode(72);
		tree.addNode(22);
		tree.addNode(48);
		tree.addNode(56);
		tree.addNode(67);
		tree.addNode(79);
//		tree.addNode(28);
//		tree.addNode(100);
//		tree.addNode(91);
//		tree.addNode(88);
//		tree.addNode(67);
//		tree.addNode(3);
//		tree.printTree("DFS");
		int k=3;
		padk.printNodeAtkLevel(tree, k);
	}
}

