package arrays;

public class ReplaceWithNextGreatest 
{
	//the basic logic of the whole program is it iterates the array from the back and try to find the max element within 
	//its previous elements and substitute the max in their positions
	public void replaceWithGreatest(int[] array)
	{
		int max=array[array.length-1];
		//as their are no elements after the last element so their are no greatest element after that so its assigned with
		//-1
		array[array.length-1]=-1;
		//iterating in the reverse
		for(int i=array.length-2;i>=0;i--)
		{
			//this stores the max value till i+1 pos because the next step involves updating the max value till  i pos
			int temp=max;
			if (array[i]>max)
			{
				max=array[i];
			}
			// replacing the current value with the max value till i+1 position
			array[i]=temp;
		}
	}
	public static void main(String args[])
	{
		int[] array={16,17,4,3,5,2};
		ReplaceWithNextGreatest rwng = new ReplaceWithNextGreatest();
		rwng.replaceWithGreatest(array);
		for(int i=0;i<array.length;i++)
		{
			System.out.print(array[i]+" ");
		}
	}
}

