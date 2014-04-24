package arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindTheMedian 
{
	public int findTheMedian(int[] array)
	{
		PriorityQueue<Integer> minheap = new PriorityQueue<>(10,new Comparator<Integer>() {
			public int compare(Integer arg0, Integer arg1)
			{
				return (arg0.intValue()-arg1.intValue());
			}
		});
		PriorityQueue<Integer> maxheap=new PriorityQueue<>(10, new Comparator<Integer>() {
			public int compare(Integer arg1,Integer arg2)
			{
				return(arg2.intValue()-arg1.intValue());
			}
		});
		for(int temp:array)
		{
		}
	}
	public static void main(String args[])
	{
		FindTheMedian ftm = new FindTheMedian();
		int[] array={8,3,44,22,23,4,57,7,2,12,44,65,3,76,54};
		ftm.findTheMedian(array);
	}
}
