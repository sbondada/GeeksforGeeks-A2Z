package arrays;

import java.util.Arrays;

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
		int pos=binarySearch(array2, 0, array2.length, 8);
		System.out.println(pos);
		return 0;
	}

	public static void main(String args[])
	{
		int[] array2={1,3,4,7,4,2,3,5,7,3,33,44,56,2};
		CountOfPowerPairs c = new CountOfPowerPairs();
		int pos=c.binarySearch(array2, 0, array2.length, 8);
		System.out.println(pos);
	}
}
