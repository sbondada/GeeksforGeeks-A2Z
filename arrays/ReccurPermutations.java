package arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ReccurPermutations 
{
	public void swap(char[] array,int i,int j)
	{
		char temp=array[i];
		array[i]=array[j];
		array[j]=temp;
	}
	public void getPermutations(String currstr,char[] array,int inc) 
	{
		int tempinc=inc;
		inc++;
		char[] array1=Arrays.copyOf(array,array.length);
		for(int i=0;i<array1.length-tempinc;i++)
		{
			swap(array,i,array.length-(tempinc+1));
			getPermutations(currstr+array1[i],array,inc);
			swap(array,i,array.length-(tempinc+1));
		}
		if(tempinc==array.length)
		{
			System.out.println(currstr);
		}
		inc++;
	}
	public static void main(String args[])
	{
		ReccurPermutations rp = new ReccurPermutations();
		String str="abcd";
		rp.getPermutations("",str.toCharArray(),0);
	}
}
