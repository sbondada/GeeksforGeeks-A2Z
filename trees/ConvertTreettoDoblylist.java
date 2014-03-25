package trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class ConvertTreettoDoblylist 
{
	static Node prevNode=null;
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
	//convert the tree as a doubly linked list without any extra space
	public void convertToList(Node curr)
	{
		if(curr==null)
		{
			return;
		}
		else
		{
			convertToList(curr.left);
			if(prevNode!=null)
			{
				prevNode.right=curr;
				curr.left=prevNode;
				prevNode=prevNode.right;
			}
			else
			{
				prevNode=curr;
				prevNode.left=null;
			}
			convertToList(curr.right);
		}
	}
	//print the leaves as a doubly linked lists
	public Node convertLeafsToLists(BinaryTree tree,Node curr,Node prev)
	{
		if(curr!=null)
		{
			if((curr.left==null && curr.right==null))
			{
				if(prev!=null)
				{
					prev.right=curr;
					curr.left=prev;
					prev=prev.right;
				}
				else
				{
					System.out.println(curr.val);
					tree.root=curr;
					curr.left=prev;
					prev=curr;
				}
				return prev;
			}
			else
			{
				prev=convertLeafsToLists(tree,curr.left, prev);
				prev=convertLeafsToLists(tree,curr.right, prev);
				return prev;
			}
		}
		else
		{
			return prev;
		}
	}
	//print left view of the tree
	public int printLeftView(Node curr,int depth,int maxdepth)
	{
		depth++;
		if(curr!=null)
		{
			if(maxdepth<depth)
			{
				System.out.println(curr.val);
				maxdepth=depth;
			}
			int leftmaxdepth=printLeftView(curr.left,depth, maxdepth);
			int rightmaxdepth=printLeftView(curr.right, depth, leftmaxdepth);
			return Math.max(leftmaxdepth,rightmaxdepth);
		}
		else
		{
			return maxdepth; 
		}
	}
	//iteratively prints the ancestors of a node
	public void iterateAllAncestors(BinaryTree tree,int val)
	{
		HashMap<Node,ArrayList<Node>> ancestorList= new HashMap<>();
		Stack<Node> nodeStack =  new Stack<>();
		nodeStack.push(tree.root);
		ArrayList<Node> tempList = new ArrayList<>();
		ancestorList.put(tree.root,tempList);
		while(!nodeStack.isEmpty())
		{
			Node temp=nodeStack.pop();
			if(temp.val==val)
			{
				for(Node tnode: ancestorList.get(temp))
				{
					System.out.println(tnode.val+" ");
				}
				System.out.println();
				return;
			}
			if(temp.left!=null)
			{
				nodeStack.push(temp.left);
				tempList = new ArrayList<>(ancestorList.get(temp));
				tempList.add(temp);
				ancestorList.put(temp.left, tempList);
			}
			//the templist should be present because we cannot specify id the above code is going to execute or not.
			if(temp.right!=null)
			{
				nodeStack.push(temp.right);
				tempList = new ArrayList<>(ancestorList.get(temp));
				tempList.add(temp);
				ancestorList.put(temp.right, tempList);
			}
		}
	}
	public int getDiffBtwEvenOddLevel(BinaryTree tree)
	{
		int evenSum=0,oddSum=0;
		ArrayList<Node> queue = new ArrayList<>();
		queue.add(tree.root);
		int endptr=queue.size();
		int depth=0;
		while(!queue.isEmpty())
		{
			Node temp=queue.get(0);
			queue.remove(0);
			endptr--;
			if(depth%2==0)
			{
				evenSum+=temp.val;
			}
			else
			{
				oddSum+=temp.val;
			}
			if(temp.left!=null)
			{
				queue.add(temp.left);
			}
			if(temp.right!=null)
			{
				queue.add(temp.right);
			}
			if(endptr==0)
			{
				depth++;
				endptr=queue.size();
			}
		}
		return Math.abs(evenSum-oddSum);
	}
	public void printList(BinaryTree tree)
	{
		Node temp=tree.root;
		while(temp!=null)
		{
			System.out.print(temp.val+" ");
			temp=temp.right;
		}
		System.out.println();
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
		ConvertTreettoDoblylist ctdl = new ConvertTreettoDoblylist();
		ConvertTreettoDoblylist.BinaryTree tree= ctdl.new BinaryTree(4);
		tree.addNode(5);
		tree.addNode(12);
		tree.addNode(23);
		tree.addNode(21);
		tree.addNode(34);
		tree.addNode(35);
		tree.addNode(45);
		tree.addNode(22);
		tree.addNode(8);
		tree.addNode(9);
		tree.addNode(17);
//		ctdl.convertToList(tree.root);
//		ctdl.printList(tree);
//		ctdl.convertLeafsToLists(tree, tree.root,null);
//		ctdl.printList(tree);
//		ctdl.printLeftView(tree.root,0,0);
//		ctdl.iterateAllAncestors(tree, 35);
		System.out.println(ctdl.getDiffBtwEvenOddLevel(tree));
	}
}
