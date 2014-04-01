package trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

import trees.CommonBTOperations.Node;

public class VerticalPath 
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
	public void printVerticalPath(Node curr,int hd)
	{
		if(curr!=null)
		{
			if(this.map.containsKey(hd))
			{
				this.map.get(hd).add(curr.val);
				this.map.put(hd,this.map.get(hd));
			}
			else
			{
				ArrayList<Integer> a=new ArrayList<Integer>();
				a.add(curr.val);
				this.map.put(hd,a);
			}
			int lefthd=hd-1;
			int righthd=hd+1;
			printVerticalPath(curr.left,lefthd); 
			printVerticalPath(curr.right,righthd); 
		}
		else
		{
			return ;
		}
	}
	public void printList(ArrayList<Integer> array)
	{
		for(int a : array)
		{
			System.out.print(a+" ");
		}
		System.out.println();
	}
	public static void main(String args[])
	{
		VerticalPath vp = new VerticalPath();
		VerticalPath.BinaryTree tree= vp.new BinaryTree(19);
		tree.addNode(6);
		tree.addNode(29);
		tree.addNode(3);
		tree.addNode(8);
		tree.addNode(1);
		tree.addNode(5);
		tree.addNode(11);
		tree.addNode(10);
		tree.addNode(18);
		vp.printVerticalPath(tree.root,0);
		Iterator<Entry<Integer, ArrayList<Integer>>> itr=vp.map.entrySet().iterator();
		while(itr.hasNext())
		{
			Entry<Integer, ArrayList<Integer>> temp=itr.next();
			vp.printList(temp.getValue());
		}
	}
}
