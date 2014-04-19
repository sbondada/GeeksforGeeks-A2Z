package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class OrderAnagrams 
{
	public class Trie
	{
		Node root;
		public Trie()
		{
			this.root=new Node('\0');
		}
	}
	public class Node
	{
		char val;
		HashMap<Character,Node> childMap;
		ArrayList<Integer> leafList;
		Node(char val)
		{
			this.val=val;
			this.childMap=new HashMap<Character,Node>();
			this.leafList=new ArrayList<Integer>();
		}
	}
	public char[] merge(char[] a,char[] b)
	{
		int i=0,j=0,inc=0;
		char[] mergestr=new char[a.length+b.length];
		while(i<a.length && j<b.length)
		{
			if(a[i]>b[j])
			{
				mergestr[inc]=b[j];
				j++;
				inc++;
			}
			else
			{
				mergestr[inc]=a[i];
				i++;
				inc++;
			}
		}
		if(i==a.length)
		{
			while(j<b.length)
			{
				mergestr[inc]=b[j];
				j++;inc++;
			}
		}
		else if(j==b.length)
		{
			while(i<a.length)
			{
				mergestr[inc]=a[i];
				i++;inc++;
			}
		}
		return mergestr;
	}
	public char[] sort(char[] strarray,int start,int end)
	{
		if(start<end)
		{
			int mid=(start+end)/2;
			char[] leftstr=sort(strarray, start, mid);
			char[] rightstr=sort(strarray,mid+1,end);
			return merge(leftstr,rightstr);
		}
		else
		{
			char[] sortstr={strarray[start]};
			return sortstr;
		}
	}
	public void addToTrie(String str,Trie t,int inc)
	{
		Node curr=t.root;
		int i=0;
		while(i<str.length())
		{
            if(curr.childMap.containsKey(str.charAt(i)))
            {
            	curr=curr.childMap.get(str.charAt(i));
            }
            else
            {
            	Node tempnew=new Node(str.charAt(i));
            	curr.childMap.put(str.charAt(i),tempnew);
            	curr=tempnew;
            }
		}
		curr.leafList.add(inc);
	}
	public void constructTrie(String[] strarray,Trie t)
	{
		int inc=0;
		for(String tempstr:strarray)
		{
			this.addToTrie(new String(this.sort(tempstr.toCharArray(),0,tempstr.length())), t,inc);
			inc++;
		}
	}
	public void order(String[] strarray) 
	{
		LinkedHashMap<String,ArrayList<String>> map= new LinkedHashMap<>();
		for(String tempstr:strarray)
		{
            String tempsortstr=new String(this.sort(tempstr.toCharArray(),0,tempstr.length()-1));
			if(map.containsKey(tempsortstr))
			{
                map.get(tempsortstr).add(tempstr);
			}
			else
			{
                ArrayList<String> templist=new ArrayList<>();
                templist.add(tempstr);
                map.put(tempsortstr,templist);
			}
		}
		Iterator<ArrayList<String>> mapiterator=map.values().iterator();
		while(mapiterator.hasNext())
		{
			for(String tempstr:mapiterator.next())
			{
				System.out.print(tempstr+" ");
			}
		}
	}
	public static void main(String args[])
	{
		OrderAnagrams oa = new OrderAnagrams();
//		String str="eacbd";
//		char[] sortarray= oa.sort(str.toCharArray(),0,str.length()-1);
//		System.out.println(new String(sortarray));
		String[] array={"cat","dog","tac","god","act"};
		oa.order(array);
		Trie t=oa.new Trie();
		oa.constructTrie(array, t);
	}
}
