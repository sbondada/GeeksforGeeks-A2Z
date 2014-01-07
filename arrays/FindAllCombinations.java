package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class FindAllCombinations
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
	public ArrayList<Integer[]> findCombinations(ArrayList<Integer[]> combinationList ,int[] permArray,int selPos,int[] array,int inc)
	{
		if(inc!=-1)
		{
                permArray[inc]=array[selPos];
                array[selPos]=0;
                inc-=1;
                for ( int i=0;i<array.length;i++)
                {
                        if(array[i]!=0 && inc !=-1)
                        {
                                findCombinations(combinationList,cloneArray(permArray),i,cloneArray(array),inc);
                        }
                }
		}
		if(inc==-1)
		{
			combinationList.add(convertIntToInteger(permArray));
			displayArray(permArray);
		}
		return combinationList;
	}
	public static void main(String args[])
	{
		int[] array=new int[]{1,2,3,4,5};
		Arrays.sort(array);
		FindAllCombinations fac=new FindAllCombinations();
		int r=2;
		ArrayList<Integer[]> combinationList=new ArrayList<Integer[]>();
		for (int i=0;i<array.length;i++)
		{
                ArrayList<Integer[]> tempList =new ArrayList<>();
                int[] combArray=new int[r];
                tempList=fac.findCombinations(tempList,combArray,i,fac.cloneArray(array),r-1);
                combinationList.addAll(tempList);
		}
		System.out.println(combinationList.size());
	}
}
