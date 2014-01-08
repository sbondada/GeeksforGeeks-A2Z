package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class SortByFrequency 
{
	public int[] convertInt2Integer(ArrayList<Entry<Integer,Integer>> orgArray)
	{
		int[] convertedArray= new int[orgArray.size()];
		for(int i=0;i<orgArray.size();i++)
		{
			convertedArray[i]=(int) orgArray.get(i).getKey();
		}
		return convertedArray;
	}
	public int[] sortArray(int[] array)
	{
		HashMap<Integer,Integer> freqMap=new HashMap<>();
		for(int i=0;i<array.length;i++)
		{
			if(freqMap.containsKey(array[i]))
			{
				freqMap.put(array[i],freqMap.get(array[i])+1);
			}
			else
			{
				freqMap.put(array[i],0);
			}
		}
	Set<Entry<Integer,Integer>> freqset= freqMap.entrySet();
	ArrayList<Entry<Integer,Integer>> freqArray= new ArrayList<>();
	freqArray.addAll(freqset);
	Collections.sort(freqArray,new Comparator<Entry<Integer,Integer>>() 
	{
		public int compare(Entry<Integer,Integer> a,Entry<Integer,Integer> b)
		{
			return b.getValue()-a.getValue();
		}
	});
	return convertInt2Integer(freqArray);
	}
	public static void main(String[] args)
	{
		int[] array={1,2,3,3,4,5,6,2,2,3,1,2,2,3,4,4,5,6};
		SortByFrequency sof = new SortByFrequency();
		int[] sortedArray = sof.sortArray(array);
		for(int i=0;i<sortedArray.length;i++)
		{
			System.out.print(sortedArray[i]+" ");
		}
		System.out.println();
	}
}
