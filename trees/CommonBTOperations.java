package trees;

import java.util.ArrayList;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class CommonBTOperations 
{
	static int leafheight=-1;
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
    public int calculateTheSum(Node curr,int sum)
    {
    	if(curr!=null) 
    	{
    		sum=calculateTheSum(curr.left, sum);
    		sum=sum+curr.val;
    		sum=calculateTheSum(curr.right, sum);
    		return sum;
    	}
    	else
    	{
    		return sum;
    	}
    }
    public int replaceWithGreatestNode(Node curr,int sum,int totalsum)
    {
    	if(curr!=null)
    	{
    	    sum=replaceWithGreatestNode(curr.left, sum,totalsum);
    		sum=sum+curr.val;
    		if(curr.val<totalsum-sum)
    		{
    		curr.val=totalsum-sum;
    		}
    		sum=replaceWithGreatestNode(curr.right, sum,totalsum);
    		return sum;	
    	}
    	else
    	{
    		return sum;
    	}
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
	public void addLeafsToLists(ArrayList<Node> nodeList,Node loc)
	{
		if(loc.left==null && loc.right==null)
		{
			nodeList.add(loc);
			return;
		}
		if(loc.left!=null)
		{
			addLeafsToLists(nodeList, loc.left);
		}
		if(loc.right!=null)
		{
			addLeafsToLists(nodeList, loc.right);
		}
	}
	public ArrayList<Node> getLeafNodes(BinaryTree tree) 
	{
		ArrayList<Node> nodeList=new ArrayList<>();
		this.addLeafsToLists(nodeList, tree.root);
		return nodeList;
	}
	public void BranchedSum(ArrayList<Integer> sumList,Node loc,int sum)
	{
		sum=sum+loc.val;
		if(loc.left==null && loc.right==null)
		{
			sumList.add(sum);
			return;
		}
		if(loc.left!=null)
		{
			BranchedSum(sumList, loc.left, sum);
		}
		if(loc.right!=null)
		{
			BranchedSum(sumList, loc.right, sum);
		}
	}
	public ArrayList<Integer> calculateBranchSum(BinaryTree tree)
	{
		ArrayList<Integer> sumList=new ArrayList<>();
		int sum=0;
		this.BranchedSum(sumList, tree.root, sum);
		return sumList;
	}
	public int getNextRightNode(BinaryTree tree,int num)
	{
		ArrayList<Node> queue = new ArrayList<>();
		queue.add(tree.root);
		int startPoint=0;
		int endpoint=0;
		while(!queue.isEmpty())
		{
			Node pop=queue.get(0);
			endpoint--;
			queue.remove(0);
			if(pop.val==num)
			{
				if(endpoint>=0)
				{
					pop=queue.get(0);
					return pop.val;
				}
				else
				{
					return -1;
				}
			}
			if(pop.left!=null)
			{
			queue.add(pop.left);
			}
			if(pop.right!=null)
			{
			queue.add(pop.right);
			}
			if(endpoint<0)
			{
				endpoint=queue.size()-1;
			}
		}
        return -1;
	}
	public int getDepthoddleaf(Node curr,int depth,int maxodddepth)
	{
		depth++;
		if(curr!=null)
		{
			if(curr.left==null&&curr.right==null&&depth%2!=0)
			{
				if(maxodddepth<depth)
				{
					maxodddepth=depth;
				}
			}
			int templeftdepth=getDepthoddleaf(curr.left, depth, maxodddepth);
			int temprightdepth=getDepthoddleaf(curr.right, depth, maxodddepth);
			return Math.max(templeftdepth,temprightdepth);
		}
		else
		{
			return maxodddepth;
		}
	}
	public static Node maxNode=null;
	public static int maxDepth=-1;
	public void recurDeep(Node loc,int depth,int left)
	{
		depth++;
		if(loc==null)
		{
			return;
		}
		else
		{
			if(depth>maxDepth && left==1)
			{
				maxNode=loc;
				maxDepth=depth;
			}
			recurDeep(loc.left, depth, 1);
			recurDeep(loc.right, depth, 0);
		}
	}
	public boolean isLeavesWithConstHeight(Node curr,int depth)
	{
		depth++;
		if(curr!=null)
		{
			if(curr.left==null && curr.right==null)
			{
				if(leafheight!=-1 && depth!=leafheight)
				{
					return false;
				}
				else
				{
					leafheight=depth;
				}
			}
				boolean lefttempcond=isLeavesWithConstHeight(curr.left, depth);
				boolean righttempcond=isLeavesWithConstHeight(curr.right, depth);
				return (lefttempcond&&righttempcond);
		}
		return true;
	}
	public int deepestLeftNode(BinaryTree tree)
	{
		recurDeep(tree.root,0,0);
		return maxNode.val;
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
//    	tree.addNode(4);
//    	tree.addNode(8);
//    	tree.addNode(10);
//    	tree.addNode(1);
//    	tree.addNode(5);
//    	tree.addNode(7);
//    	tree.addNode(11);
//    	tree.addNode(23);
//    	tree.printTree("DFS");
//    	System.out.println(cbto.getDepth(tree, 7));
//    	System.out.println(cbto.lowestCommonAncestor(tree, 1, 5));
//    	System.out.println(cbto.findDist(tree,1,11));
//    	ArrayList<Node> nodeList=cbto.getLeafNodes(tree);
//    	for(CommonBTOperations.Node temp:nodeList)
//    	{
//    		System.out.print(temp.val+" ");
//    	}
//    	ArrayList<Integer> sumList=cbto.calculateBranchSum(tree);
//    	for(int temp:sumList)
//    	{
//    		System.out.print(temp+" ");
//    	}
//    	System.out.println(cbto.getNextRightNode(tree, 10));
//    	System.out.println(cbto.deepestLeftNode(tree));
//    	System.out.println(cbto.isLeavesWithConstHeight(tree.root,0));
//    	System.out.println(cbto.getDepthoddleaf(tree.root,0,0))
//    	System.out.println(cbto.calculateTheSum(tree.root, 0));
    	cbto.replaceWithGreatestNode(tree.root,0,cbto.calculateTheSum(tree.root, 0));
    	System.out.println(cbto.calculateTheSum(tree.root,0));
    	tree.printTree("DFS");
    }
}
