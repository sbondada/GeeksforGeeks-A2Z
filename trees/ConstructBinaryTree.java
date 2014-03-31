package trees;

import java.util.ArrayList;
import java.util.TreeMap;

import trees.VerticalPath.BinaryTree;
import trees.VerticalPath.Node;

public class ConstructBinaryTree 
{
	public class BinaryTree
	{
		public Node root;
		public BinaryTree(int val)
		{
			this.root=new Node(val);
		}
		public BinaryTree(Node root)
		{
			this.root=root;
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
	TreeMap<Integer,ArrayList<Integer>> map;
	{
		map=new TreeMap<Integer,ArrayList<Integer>>();
	}
	public Node ConstructBinaryTree(int[] array)
	{
		int inc=0;
		ArrayList<Node> queue = new ArrayList<ConstructBinaryTree.Node>();
		Node root=new Node(array[inc]);
		queue.add(root);
		inc++;
		while(!queue.isEmpty())
		{
			Node temp=queue.get(0);
			queue.remove(0);
			if(inc<array.length)
			{
				temp.left=new Node(array[inc]);
				queue.add(temp.left);
				inc++;
			}
			if(inc<array.length)
			{
				temp.right=new Node(array[inc]);
				queue.add(temp.right);
				inc++;
			}
		}
		return root;
	}
	public static void main(String args[])
	{
		ConstructBinaryTree cbt = new ConstructBinaryTree();
		int[] array ={10,8,2,3,92,23,43,18,11,31,33,43};
		Node root=cbt.ConstructBinaryTree(array);
		ConstructBinaryTree.BinaryTree tree = cbt.new BinaryTree(root);
		tree.printTree("DFS");
	}
}
