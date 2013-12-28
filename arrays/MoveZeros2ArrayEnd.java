package arrays;

import java.util.ArrayList;
import java.util.Map.Entry;

public class MoveZeros2ArrayEnd 
{
	public int[] move2End(int[] array1)
	{
        ArrayList<Integer> arraypos= new ArrayList<>();
        int i=0;
		while(i<array1.length)
		{
			if (array1[i]==0)
			{
				arraypos.add(i);
			}
			i=i+1;
		}
		int inc=0;
		int lastNonZeroPos=array1.length-1;
		while(inc<arraypos.size())
		{
			while (array1[lastNonZeroPos]==0)
			{
				lastNonZeroPos-=1;
			}
//			int temp;
//			temp=array1[arraypos.get(inc)];
			array1[arraypos.get(inc)]=array1[lastNonZeroPos];
			array1[lastNonZeroPos]=0;
			inc+=1;
		}
		return array1;
	}
	public static void main(String args[])
	{
		MoveZeros2ArrayEnd moveObj=new MoveZeros2ArrayEnd();
		int[] array1={0,1,2,4,0,4,3,0,2,6,7,0,3,0,3};
		array1=moveObj.move2End(array1);
		for (int j=0;j<array1.length;j++)
		{
			System.out.print(array1[j]);
		}
	}
}
