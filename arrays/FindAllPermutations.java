package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class FindAllPermutations 
{
	public Integer[] convertIntToInteger(int[] inpArray)
	{
		Integer[] outArray=new Integer[inpArray.length];
		for (int i=0;i<inpArray.length;i++)
		{
			outArray[i]=Integer.valueOf(inpArray[i]);
		}
		return outArray;
	}
	public int[] cloneArray(int[] orginalArray) 
	{
		int[] clonedArray = new int[orginalArray.length];
		for(int i=0;i<orginalArray.length;i++)
		{
			clonedArray[i]=orginalArray[i];
		}
		return clonedArray;
	}
	public ArrayList<Integer[]> findPermutations(ArrayList<Integer[]> permutationList,int[] array,int[] permArray,int inc) 
	{
		for(int i=0;i<array.length;i++)
		{
			if(array[i]!=0)
			{
				permArray[inc]=array[i];
				array[i]=0;
				if(inc==0)
				{
					permutationList.add(convertIntToInteger(cloneArray(permArray)));
					return permutationList;
				}
				else
				{
					inc-=1;
					permutationList=findPermutations(permutationList, array, permArray, inc);
				}
			}
		}
		return permutationList;
	}
	public static void main(String args[])
	{
		int[] array=new int[]{1,2,4,3,6,7,5,9};
		Arrays.sort(array);
		FindAllPermutations fap=new FindAllPermutations();
		int r=3;
		int[] pemArray=new int[r];
		ArrayList<Integer[]> permutationList=new ArrayList<Integer[]>();
		permutationList=fap.findPermutations(permutationList,array, pemArray, r-1);
		System.out.println(permutationList.size());
	}
}
