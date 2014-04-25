package arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class Intersection 
{
	public Set<Integer> getIntersections(int[][] array)
	{
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i=0; i <array.length;i++)
		{
			System.out.println(map.size());
			for (int j=0;j<array[i].length;j++)
			{
				if(i==0)
				{
					map.put(array[i][j],0);
				}
				else
				{
					if(map.containsKey(array[i][j]))
					{
						if((map.get(array[i][j]))!=i-1)
						{
							map.remove(array[i][j]);
						}
						else
						{
							map.put(array[i][j],map.get(array[i][j])+1);
						}
					}
				}
			}
		}
	Iterator<Entry<Integer,Integer>> it = map.entrySet().iterator();
	HashSet<Integer> result = new HashSet<>();
	while(it.hasNext())
	{
		Entry<Integer,Integer> tempEntry=it.next();
		if(tempEntry.getValue()==array.length-1)
		{
			result.add(tempEntry.getKey());
		}
	}
    return result;
	}
	public static void main(String args[])
	{
		Intersection inter= new Intersection();
		int[][] array={{1,2,5,3,8,6},{1,2,6,8},{1,4,5,7,8,9}};
		Set<Integer> intset=inter.getIntersections(array);
		for(int temp: intset)
		{
			System.out.print(temp+" ");
		}
		System.out.println();
	}
}
