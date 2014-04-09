package DynamicProgramming;

import java.util.ArrayList;

public class WeightedIndependentSet 
{
	public int[] getMaxWeight(int[] array)
	{
		int[] sol_array=new int[array.length];
		int inc=0;
		sol_array[inc]=Math.max(0,array[inc]);
		inc++;
		sol_array[inc]=Math.max(sol_array[inc-1],array[inc]);
		inc++;
		while(inc<array.length)
		{
			sol_array[inc]=Math.max(sol_array[inc-1],sol_array[inc-2]+array[inc]);
			inc++;
		}
		return sol_array;
	}
	public ArrayList<Integer> getWeightedIndeSet(int[] array, int[] sol_array)
	{
		ArrayList<Integer> wisSet=new ArrayList<Integer>();
		int inc=sol_array.length-1;
		while(inc>1)
		{
			if((sol_array[inc]-array[inc])==sol_array[inc-2])
			{
				wisSet.add(array[inc]);
				inc=inc-2;
			}
			else
			{
				inc=inc-1;
			}
		}
		if(inc==1)
		{
			if((sol_array[inc]-array[inc])==0)
			{
				wisSet.add(array[inc]);
				inc=inc-2;
			}
			else
			{
				inc--;
			}
		}
		if(inc==0)
		{
			if((sol_array[inc]-array[inc])==0)
			{
				wisSet.add(array[inc]);
				inc=inc-2;
			}
		}
		return wisSet;
	}
	public static void main(String args[])
	{
		int[] array={5,-7,6,3,-2,-1,5,9,12};
		WeightedIndependentSet ws = new WeightedIndependentSet();
		int[] sol_array=ws.getMaxWeight(array);
		System.out.println("max weight of the weighted independent set "+sol_array[array.length-1]);
		ArrayList<Integer> wisSet=ws.getWeightedIndeSet(array, sol_array);
		for(int temp : wisSet)
		{
			System.out.print(temp+" ");
		}
		System.out.println();
	}
}
