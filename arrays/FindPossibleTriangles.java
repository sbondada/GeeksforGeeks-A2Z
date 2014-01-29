package arrays;

import java.util.Arrays;

public class FindPossibleTriangles 
{
	public int countTriangles(int[] array)
	{
		int count=0;
		int i=0,j=1,k=j+1;
		while(i<array.length-2)
		{
			System.out.println("print "+i);
			while(j<array.length-1)
			{
                while(k<array.length)
                {
                        if(array[i]+array[j]>array[k])
                        {
                        	count+=1;	
                        }
                        k++;
                }
                j++;
                k=j+1;
			}
        i++;
        j=i+1;
        k=j+1;
		}
		return count;
	}
	public static void main(String args[])
	{
		int[] array={10,21,22,100,101,200,300};
		FindPossibleTriangles fpt=new FindPossibleTriangles();
		Arrays.sort(array);
		for(int i=0;i<array.length;i++)
		{
			System.out.print(array[i]+" ");
		}
		int count=fpt.countTriangles(array);
		System.out.println("count of triangles :"+count);
	}
}
