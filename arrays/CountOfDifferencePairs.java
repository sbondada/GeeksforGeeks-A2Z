package arrays;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class CountOfDifferencePairs 
{
	public int getCountOfDifferencePairs(int[] array,int diff)
	{
		int pairCount=0;
		// creating a hash map of each element in array as a key and its corresponding diff pair as value
		HashMap<Integer,Integer> diffMap= new HashMap<>();
		int inc=0;
		while(inc<array.length)
		{
			//adding the array element with the diff value to get the corresponding diff pair(important)
			diffMap.put(array[inc],array[inc]+diff);
			inc+=1;
		}
		Iterator<Entry<Integer,Integer>> diffIterator=diffMap.entrySet().iterator();
		//finding if the coresponding dif pair exist in the hashmap as a key
		while(diffIterator.hasNext())
		{
			Entry<Integer,Integer> diffPair=diffIterator.next();
			if(diffMap.containsKey(diffPair.getValue()))
			{
				// if arrays diff pair exist in hash map key add to counter
				pairCount+=1;
			}
		}
		return pairCount;


		
	}
	public static void main(String args[])
	{
        CountOfDifferencePairs cdfp = new CountOfDifferencePairs();
		int[] array1={1,5,3,4,2};
        for (int j=0;j<array1.length;j++)
		{
			System.out.print(array1[j]+" ");
		}
        System.out.println("\n");
        int diff=3;
        int pairCount=cdfp.getCountOfDifferencePairs(array1,diff);
        System.out.println("Count "+pairCount);
	}
}
