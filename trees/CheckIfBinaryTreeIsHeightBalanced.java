package trees;

import java.util.ArrayList;

public class CheckIfBinaryTreeIsHeightBalanced 
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
		public void printBFSTree(Node loc)
		{// the function is not yet working properly
			ArrayList<Node> queue = new ArrayList<>();
			queue.add(loc);
			Node Endlevel=loc;
			while(!queue.isEmpty())
			{
				loc=queue.get(0);
				queue.remove(0);
				if(loc==null)
				{
					System.out.print(" __ ");
					queue.add(null);
					queue.add(null);
				}
				else
				{
				System.out.print(" "+loc.val+" ");
				queue.add(loc.left);
				queue.add(loc.right);
				}
				if(Endlevel==loc && loc!=null)
				{
					Endlevel=loc.right;
					System.out.println();
				}

			}
		}
		public void printTree(String type)
		{
			Node loc=this.root;
			if(type=="DFS")
			{
				printDFSTree(loc);
			}
			else
			{
				printBFSTree(loc);
			}
		}
	}
	public void getmaxmindepth(Node loc,int[] maxmin,int counter) 
	{
		if(loc!=null)
		{
			counter++;
			getmaxmindepth(loc.left, maxmin,counter);
			getmaxmindepth(loc.right, maxmin,counter);
		}
		else
		{
			if(maxmin[0]<counter)
			{
				maxmin[0]=counter-1;
			}
			if(maxmin[1]>counter)
			{
				maxmin[1]=counter-1;
			}
			return;
		}
	}
	public boolean checkIfBalanced(BinaryTree tree)
	{
		Node loc=tree.root;
		int[] maxmin={0,Integer.MAX_VALUE};
		int counter=0;
		getmaxmindepth(loc,maxmin,counter);
		System.out.println("max "+maxmin[0]);
		System.out.println("min "+maxmin[1]);
		if(maxmin[0]-maxmin[1]>2)
		{
			return false;
		}
		else 
		{
			return true;
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
	public static void main(String args[])
	{
		CheckIfBinaryTreeIsHeightBalanced cbthb = new CheckIfBinaryTreeIsHeightBalanced();
		CheckIfBinaryTreeIsHeightBalanced.BinaryTree tree= cbthb.new BinaryTree(65);
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
		System.out.println(cbthb.checkIfBalanced(tree));
	}
}
