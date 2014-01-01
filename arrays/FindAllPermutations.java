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
	public void displayArray(int[] array)
	{
		for(int i=0;i<array.length;i++)
		{
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
	public ArrayList<Integer[]> findPermutations(ArrayList<Integer[]> permutationList,int[] array,int[] permArray,int inc) 
	{
		for(int i=0;i<array.length;i++)
		{
			if(array[i]!=0)
			{
				displayArray(array);
				permArray[inc]=array[i];
				array[i]=0;
				if(inc==0)
				{
					displayArray(permArray);
					permutationList.add(convertIntToInteger(cloneArray(permArray)));
//					return permutationList;
				}
				else
				{
					displayArray(permArray);
					inc-=1;
                    findPermutations(permutationList,cloneArray(array), cloneArray(permArray), inc);
//					permutationList=findPermutations(permutationList,cloneArray(array), cloneArray(permArray), inc);
					System.out.println(permutationList.size());
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
		System.out.println(permutationList.get(2).length);
		System.out.println(permutationList.size());
	}
}
