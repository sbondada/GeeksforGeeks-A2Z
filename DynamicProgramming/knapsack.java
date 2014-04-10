package DynamicProgramming;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.omg.CORBA.INTERNAL;

public class knapsack 
{
	public int findMax(int[] array)
	{
		int max=Integer.MIN_VALUE;
		for(int a : array)
		{
			if(max<a)
			{
				max=a;
			}
		}
		return max;
	}
	public int[][] evaluate(int w,int[] warray,int[] carray)
	{
		int[][] memomat=new int[warray.length+1][w+1];
		int[][] keepmat=new int[warray.length+1][w+1];
		for(int a=0;a<warray.length+1;a++)
		{
			memomat[a][0]=0;
		}
		for(int b=0;b<w+1;b++)
		{
			memomat[0][b]=0;
		}
		for(int i=1;i<warray.length+1;i++)
		{
			for(int j=1;j<w+1;j++)
			{
				int tempb=0;
				if((j-warray[i-1])>=0)
				{
					tempb=memomat[i-1][j-warray[i-1]]+carray[i-1];
				}
				memomat[i][j]=Math.max(memomat[i-1][j],tempb);
				if(memomat[i-1][j]>=tempb)
				{
					keepmat[i][j]=0;
				}
				if(tempb>memomat[i-1][j])
				{
					keepmat[i][j]=1;
				}
			}
		}
		this.printmatrix(memomat);
		this.printmatrix(keepmat);
		return keepmat;
	}
	public ArrayList<Integer> reconstruct_weightset(int[][] keepmat,int[] warray)
	{
		int j=keepmat[0].length-1;
		int i=keepmat.length-1;
		ArrayList<Integer> set = new ArrayList<Integer>();
		while(i>0 && j>0)
		{
			if(keepmat[i][j]==1)
			{
				set.add(warray[i-1]);
				j=j-warray[i-1];
				i=i-1;
			}
			else
			{
				i=i-1;
			}
		}
		return set;
	}
	public static void main(String args[])
	{
		knapsack kp = new knapsack();
		int[] warray={4,2,3,6,7,8,3,11,2,12,9};
		int[] carray={30,20,15,40,11,13,18,25,11,27,16};
		int[][] keepmat=kp.evaluate(45,warray,carray);
		ArrayList<Integer> set=kp.reconstruct_weightset(keepmat, warray);
		System.out.println();
		for(int i : set)
		{
			System.out.print(i+" ");
		}
	
	}
	public void printmatrix(int[][] memomat)
	{
		
		for(int i=0;i<memomat.length;i++)
		{
			for(int j=0;j<memomat[0].length;j++)
			{
				System.out.print(memomat[i][j]+" ");
			}
			System.out.println();
		}
	}

}
