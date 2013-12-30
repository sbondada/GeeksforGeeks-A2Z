package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class NumbersGreaterByNByKTimes 
{
	public ArrayList<Integer> getNumberArray(int[] array,int k)
	{
		HashMap<Integer,Integer> countMap = new HashMap<>();
		//generating a map which keeps the count of all the values
		for(int i=0;i<array.length;i++)
		{
			if(countMap.containsKey(array[i]))
			{
				countMap.put(array[i],countMap.get(array[i])+1);
			}
			else
			{
				countMap.put(array[i],0);
			}
		}
		//looping through all the individual key and value pair
		java.util.Iterator<Entry<Integer,Integer>> mapIterator=countMap.entrySet().iterator();
		int n=array.length;
		int nByK=n/k;
		//creating a list to keep all the elements greater than n/k
		ArrayList<Integer> nByKArray=new ArrayList<>();
		while (mapIterator.hasNext())
		{
			Entry<Integer,Integer> tempEntry=mapIterator.next();
			//checking element by element, if the count is greater than n/k
			// if so adding to the list
			if(tempEntry.getValue()>nByK)
			{
				nByKArray.add(tempEntry.getKey());
			}
		}
		return nByKArray;
	}
	public static void main(String args[])
	{
		int[] array= new int[]{1,2,4,3,2,1,2,3,2,3,2,1,1,1,2,3,2,1,4,5,6,7,5,4,5,7};
		NumbersGreaterByNByKTimes ngbkt=new NumbersGreaterByNByKTimes();
		java.util.Iterator<Integer> nByKIterator=ngbkt.getNumberArray(array,10).iterator();
		while(nByKIterator.hasNext())
		{
			System.out.println(nByKIterator.next()+" ");
		}
	}
}
