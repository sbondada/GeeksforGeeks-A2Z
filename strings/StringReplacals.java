package strings;

import java.util.HashMap;
import java.util.HashSet;

public class StringReplacals 
{
	public String replaceString(String str)
	{
		char[] chararray= str.toCharArray();
		int i=0,j=0;
		char changechar=chararray[0];
		int count=0;
		for(int inc=0;inc<chararray.length;inc++)
		{
			if(changechar==chararray[inc])
			{
				count++;
			}
			else
			{
				chararray[j]=changechar;
				chararray[j+1]=(char)(count+48);
				changechar=chararray[inc];
				j=j+2;
				count=1;
			}
		}
		chararray[j]=changechar;
		chararray[j+1]=(char)(count+48);
		j=j+2;
		chararray[j]='\u0000';
		return new String(chararray);
	}
	public boolean StringMatching(String[] strarray,Tries trie)
	{
		Node tempNode = trie.root; 
		char[] chararray=strarray[0].toCharArray();
		for(char tempchar:chararray)
		{
			Node temp=new Node(tempchar);
			tempNode.branch.put(tempchar,temp);
			tempNode=temp;
		}
		boolean Flag=false;
		boolean branch=false;
		for(String tempstr:strarray)
		{
            tempNode = trie.root; 
            branch=false;
			for(char tempchar:tempstr.toCharArray())
			{
				if(tempNode.branch.containsKey(tempchar))
				{
					tempNode=tempNode.branch.get(tempchar);
				}
				else if(tempNode.branch.size()==0 && branch==false)
				{
					Flag=true;
					return Flag;
				}
				else
				{
					branch=true;
					Node temp=new Node(tempchar);
					tempNode.branch.put(tempchar,temp);
					tempNode=temp;
				}
			}
			if(branch==false)
			{
				return true;
			}
		}
		return Flag;
	}
	public class Tries
	{
		public Node root;
		public Tries()
		{
			root=new Node();
		}
	}
	public class Node
	{
		public char val;
		public HashMap<Character,Node> branch;
		public Node()
		{
			val='\u0000';
			branch= new HashMap<Character, StringReplacals.Node>();
		}
		public Node(char val)
		{
			this.val=val;
			branch= new HashMap<Character, StringReplacals.Node>();
		}
	}
	public static void main(String args[])
	{
		StringReplacals sr = new StringReplacals();
		String str="aaabbssbbdddddddd";
		String modString = sr.replaceString(str);
		System.out.println(modString);
		String[] strarray={"abc","ab","mnop","mnooo"};
		Tries trie=sr.new Tries();
		System.out.println(sr.StringMatching(strarray, trie));
	}
}
