package DynamicProgramming;

import java.util.ArrayList;

public class LongestCommonSubsequence 
{
	public int[][] findLongestCommonSubsequence(String astr,String bstr)
	{
		char[] aarray=astr.toCharArray();
		char[] barray=bstr.toCharArray();
		int[][] costmatrix=new int[astr.length()+1][bstr.length()+1];
		int[][] trackmatrix=new int[astr.length()+1][bstr.length()+1];
		int i=1;
		int j=1;
		for(int a=0;a<aarray.length+1;a++)
		{
			costmatrix[a][0]=a;
		}
		for(int b=0;b<barray.length+1;b++)
		{
			costmatrix[0][b]=b;
		}
		while(i<=aarray.length+1)
		{
			int tempi=i;
			int tempj=j;
			while(tempi>0 && tempj<barray.length+1)	
			{
//				System.out.println(tempi+","+tempj+" ");
				int temptrack;
				int tempmin;
				if(costmatrix[tempi-1][tempj]+1<costmatrix[tempi][tempj-1]+1)
				{
					temptrack=1;
					tempmin=costmatrix[tempi-1][tempj]+1;
				}
				else
				{
					temptrack=2;
					tempmin=costmatrix[tempi][tempj-1]+1;
				}
				if(tempmin<costmatrix[tempi-1][tempj-1]+Math.abs(aarray[tempi-1]-barray[tempj-1]))
				{
					costmatrix[tempi][tempj]=tempmin;
					trackmatrix[tempi][tempj]=temptrack;
				}
				else
				{
					costmatrix[tempi][tempj]=costmatrix[tempi-1][tempj-1]+Math.abs(aarray[tempi-1]-barray[tempj-1]);
					trackmatrix[tempi][tempj]=3;
				}
				tempi=tempi-1;
				tempj=tempj+1;
			}
			if(i<aarray.length)
			{
				i++;
			}
			else if(i==aarray.length && j==barray.length)
			{
				break;
			}
			else if(i>=aarray.length)
			{
				j++;
			}			
		}
		System.out.println(costmatrix[astr.length()][bstr.length()]);
		return trackmatrix;
	}
	public void retractPath(int[][] trackmatrix,char[] a,char[] b)
	{
		int i=1;
		int j=1;
		ArrayList<Character> astr= new ArrayList<Character>();
		ArrayList<Character> bstr= new ArrayList<Character>();
		while(i<trackmatrix.length && j<trackmatrix[0].length)
		{
			if(trackmatrix[i][j]==1)
			{
				astr.add(a[i-1]);
				bstr.add(' ');
				i=i+1;
			}
			else if(trackmatrix[i][j]==2)
			{
				bstr.add(b[j-1]);
				astr.add(' ');
				j=j+1;
			}
			else if(trackmatrix[i][j]==3)
			{
				astr.add(a[i-1]);
				bstr.add(b[j-1]);
				i=i+1;j=j+1;
			}
		}
		for(char tempa : astr)
		{
			System.out.print(tempa+" ");
		}
		System.out.println();
		for(char tempb : bstr)
		{
			System.out.print(tempb+" ");
		}

	}
	public static void main(String args[])
	{
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		String astr="HELLO";
		String bstr="HOUSE";
		int[][] trackmatrix=lcs.findLongestCommonSubsequence(astr, bstr);
		lcs.retractPath(trackmatrix, astr.toCharArray(), bstr.toCharArray());
	}
}
