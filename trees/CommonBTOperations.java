package trees;

import java.util.ArrayList;

public class CommonBTOperations 
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
	public Node getNode(BinaryTree tree, int num)
	{
		Node loc=tree.root;
		while(loc!=null)
		{
			if(loc.val==num)
			{
				return loc;
			}
			else if(loc.val<num)
			{
				loc=loc.right;
			}
			else
			{
				loc=loc.left;
			}
		}
		return null;
	}
    public int getDepth(BinaryTree tree, int num)
	{
		Node loc=tree.root;
		int depth=0;
		while(loc!=null)
		{
			if(loc.val==num)
			{
				return depth;
			}
			else if(loc.val<num)
			{
				loc=loc.right;
			}
			else
			{
				loc=loc.left;
			}
			depth++;
		}
		return -1;
	}
    public class LCAnode
    {
    	public Node loc;
    	public int flag;
    }
    public ArrayList<Integer> getPath(BinaryTree tree, int num)
    {
    	Node loc=tree.root;
    	ArrayList<Integer> path=new ArrayList<>();
    	while(loc!=null)
    	{
    		path.add(loc.val);
    		if(loc.val==num)
    		{
    			return path;
    		}
            else if(loc.val<num)
    		{
    			loc=loc.right;
    		}
    		else
    		{
    			loc=loc.left;
    		}
    	}
    	return null;
    }
    public int lowestCommonAncestor(BinaryTree tree,int first,int second)
    {
    	ArrayList<Integer> firstPath=this.getPath(tree, first);
    	ArrayList<Integer> secPath=this.getPath(tree, second);
    	if(firstPath!=null && secPath!=null)
    	{
    		int inc=0;
    		while(firstPath.get(inc)==secPath.get(inc))
    		{
    			inc++;
    		}
    		return firstPath.get(inc-1);
    	}
    	else
    	{
    		System.out.println("No common parent found");
    		return -1;
    	}
    }
	public int findDist(BinaryTree tree, int first,int second)
	{
		int fdepth=this.getDepth(tree, first);
		int sdepth=this.getDepth(tree, second);
		int lca=this.lowestCommonAncestor(tree, first, second);
		int lcadepth=this.getDepth(tree, lca);
		int mindist=fdepth+sdepth-(2*lcadepth);
		return mindist;
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
    	CommonBTOperations cbto= new CommonBTOperations();
    	CommonBTOperations.BinaryTree tree= cbto.new BinaryTree(6);
    	tree.addNode(3);
    	tree.addNode(9);
    	tree.addNode(2);
    	tree.addNode(4);
    	tree.addNode(8);
    	tree.addNode(10);
    	tree.addNode(1);
    	tree.addNode(5);
    	tree.addNode(7);
    	tree.addNode(11);
    	tree.printTree("DFS");
//    	System.out.println(cbto.getDepth(tree, 7));
//    	System.out.println(cbto.lowestCommonAncestor(tree, 1, 5));
    	System.out.println(cbto.findDist(tree,1,11));
    }
}
