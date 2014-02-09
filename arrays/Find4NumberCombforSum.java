package arrays;

import java.util.HashMap;
import java.util.Iterator;

public class Find4NumberCombforSum 
{
	//prints the array to the console
	public void print(int[] array)
	{
        for(int i=0;i<array.length;i++)
        {
            System.out.print(array[i]+" ");
        }
        System.out.println();
	}
	//the function uses hash map to find the pair of values otherthan those already in combarray to form a sum
	public int[] find2NumberCombForSum(int[] array,int sum, int[] combArray)
	{
		HashMap<Integer,Integer> leftrightmap=new HashMap<>();
		//constructing the hash map
		for(int i=0;i<array.length;i++)
		{
			//key is the values in the array and values are the difference of the sum and the key
			leftrightmap.put(array[i],sum-array[i]);
		}
		Iterator<Integer> valueIterator= leftrightmap.values().iterator();
		//iteraating the value list to find if any value in the value list is in the array and satisfy other conditions
		while(valueIterator.hasNext())
		{
			int value=valueIterator.next();
//			System.out.println(keyvalue);
			//checking if the value is in the array and if the combination key and value are not the nombers which are already present 
			if(leftrightmap.containsKey(value) && value!=array[0] && value!=array[1] && (sum-value)!=array[0] && (sum-value)!=array[1])
            {
				combArray[2]=value;
				combArray[3]=sum-value;
                return combArray;
            }
		}
		return null;
	}
	public int[] find4NumberCombforSum(int[] array,int sum)
	{
		int[] combArray=new int[4];
		//looping the array twice to find all the sets of numbers
		for(int i=0;i<array.length;i++)
		{
			for(int j=0;j<array.length;j++)
			{
				if(i!=j)
				{

                    combArray=new int[4];
                    //calculating the difference of sum which would be used to find the remaining pair
					int remaingSum=sum-(array[i]+array[j]);
					combArray[0]=array[i];
					combArray[1]=array[j];
					combArray=find2NumberCombForSum(array,remaingSum,combArray);
					if(combArray!=null)
					{
						return combArray;
					}
				}
			}
		}
		return combArray;

	}
	public static void main(String args[])
	{
		int[] array={10,2,3,4,5,9,7,8};
		Find4NumberCombforSum fncs=new Find4NumberCombforSum();
		int sum=34;
//		int[] arrres=fncs.find2NumberCombForSum(array, sum);
//		System.out.println(arrres[0]+" "+arrres[1]);
		int[] arrres= fncs.find4NumberCombforSum(array, sum);
		if(arrres!=null)
		{
			fncs.print(arrres);
		}

	}
}
