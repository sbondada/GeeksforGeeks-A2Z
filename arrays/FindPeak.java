package arrays;

public class FindPeak 
{
	public int findPeak(int[] array,int start, int end)
	{
		int n=(start+end)/2;
		System.out.println("mid element "+n);
		int peak=0;
		if(n==0 || array[n]>=array[n-1] && array[n]>=array[n+1])
		{
			return array[n];
		}
		else if( array[n-1]>array[n])
		{
			peak=findPeak(array, start, n-1);
//            return findPeak(array, start, n-1);
		}
		else if(array[n+1]<array[n])
		{
			peak=findPeak(array, n+1, end);
//            return findPeak(array, n+1, end);
		}
		return peak;
	}
	public static void main(String[] args)
	{
		int[] array={40,30,25,20,10,5};
		FindPeak fp = new FindPeak();
		int peak=fp.findPeak(array, 0,array.length-1);
		System.out.println("peak is "+peak);
	}
}
