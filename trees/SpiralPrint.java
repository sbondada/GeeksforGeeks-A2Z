package trees;

import java.util.ArrayList;

import trees.PrintAllAtDistanceK.BinaryTree;
import trees.PrintAllAtDistanceK.Node;

public class SpiralPrint 
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
	public void printSpiralTree(Node curr)
	{
		ArrayList<Node> queue = new ArrayList<Node>();
		queue.add(curr);
		Node endpoint=curr;
		int flag=0;
		System.out.print(curr.val+" ");
		while(!queue.isEmpty())
		{
			Node pop=queue.get(0);
			queue.remove(0);
			if(pop.left!=null)
			{
				queue.add(pop.left);
			}
			if(pop.right!=null)
			{
				queue.add(pop.right);
			}
			if(flag==0 && pop.equals(endpoint))
			{
				for(int i =1;i<=queue.size();i++)
				{
					System.out.print(queue.get(queue.size()-i).val+" ");
				}
				flag=1;
			}
			else if(flag==1 && pop.equals(endpoint))
			{
				for (Node temp : queue)
				{
					System.out.print(temp.val+" ");
				}
				flag=0;
			}
			if(pop==endpoint)
			{
				int temp=queue.size()-1;
				if(temp>=0)
				{
					endpoint=queue.get(temp);
				}
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
	public static void main(String args[])
	{
		SpiralPrint sp = new SpiralPrint();
		SpiralPrint.BinaryTree tree= sp.new BinaryTree(65);
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
		sp.printSpiralTree(tree.root);
	}
}
