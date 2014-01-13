package arrays;

//the method implemented works only because the distinct nos in array is less than the value of n
// and the array only has a set of positive nos
public class FindMaxRepeatingNo 
{
	public int findMaxPos(int[] array)
	{
		int max=0;
		int pos=0;
		for (int i=0;i<array.length;i++)
		{
			if(array[i]>max)
			{
				max=array[i];
				pos=i;
			}
		}
		return pos;
	}
	public int findRepeatingNo(int[] array)
	{
		//k is the max range of the numbers in the array.
		// the logic is to add the max value at the position array[i]%k because even if we add the value to the 
		// upcoming pos in the array, since we are finding the remainder of array[i]%k we would get the original 
		// value , which would have been before adding  the value of k
		int maxelepos=findMaxPos(array);
		int k=array[maxelepos];
		for(int i=0;i<array.length;i++)
		{
			int subpos=array[i]%k;
			array[subpos]=array[subpos]+k;  //wonderfull logic simple and elegant
		}
		return findMaxPos(array);
	}
	public static void main(String args[])
	{
		int[] array={1,2,2,3,2,2,2,3,1,4,5,3,2,4,3,5};
		FindMaxRepeatingNo fmrn=new FindMaxRepeatingNo();
		int element=fmrn.findRepeatingNo(array);
		System.out.println("the max repeatiing element is");
		System.out.println(element);

	}
}
