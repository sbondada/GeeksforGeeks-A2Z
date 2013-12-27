package arrays;

import java.util.Arrays;
import java.util.HashMap;

public class CountOfPowerPairs 
{
	public int binarySearch(int[] searchArray,int start, int end,int searchElement)
	{
		int breaker;
		if(start==end)
		{
			return start;
		}
		else
		{
			breaker=(start+end)/2;
		}
		int pos=0;
		if(searchArray[breaker]<searchElement)
		{
			pos=binarySearch(searchArray,breaker+1, end, searchElement);
		}
		else if(searchArray[breaker]>searchElement)
		{
			pos=binarySearch(searchArray, start,breaker,searchElement);
		}
		else
		{
			return breaker;
		}
		return pos;

	}
	public int getCountPowerpairs(int[] array1,int[] array2)
	{
		Arrays.sort(array2);
		HashMap<Integer,Integer> arraymap= new HashMap<>();	
		for (int i=0;i<array2.length;i++)
		{
			if (arraymap.containsKey(array2[i]))
			{
				arraymap.put(array2[i],arraymap.get(array2[i])+1);
			}
			else
			{
				arraymap.put(array2[i],0);
			}
		}
		int count=0;
		int inc=0;
		while(inc<array1.length)
		{
			if (array1[inc]==0)
			{
				count+=0;
			}
			if (array1[inc]==1)
			{
				if (arraymap.containsKey(0))
				{
				count+=arraymap.get(0);
				}
				else
				{
					count+=0;
				}
			}
			count+=(array2.length-binarySearch(array2, 0, array2.length,array1[inc]));
//			System.out.println("array="+array1[inc]);
//			System.out.println("count="+binarySearch(array2, 0, array2.length,array1[inc]));
			if(array1[inc]==2)
			{
				if (arraymap.containsKey(3))
				{
					count-=arraymap.get(3);
				}
				if (arraymap.containsKey(4))
				{
					count-=arraymap.get(4);
				}
			}
			if(array1[inc]==3)
			{
				if (arraymap.containsKey(2))
				{
					count+=arraymap.get(2);
				}
			}
			inc=inc+1;
		}
		return count;
	}

	public static void main(String args[])
	{
		int[] array1={10,19,18};
		int[] array2={11,15,9};
//		for (int i=0;i<array2.length;i++)
//		{
//			System.out.print(array1[i]+"  ");
//			System.out.print(array2[i]+"  ");
//		}
		CountOfPowerPairs c = new CountOfPowerPairs();
		int pos=c.getCountPowerpairs(array1, array2);
		System.out.println("\n"+pos);
	}
}
