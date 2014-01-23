package arrays;

public class BiggestNumberFromArray 
{
	//writing own compare function to decide which number should come first.
	//we take to integers append a to b and b to a and form ab and ba
	//if ab>ba then a>b that is how this function work
	public int myCompare(int a,int b)
	{
		//converted the integer to strings and then concatenate 
		//instead of calculating the the doing a longer procedure to
		//append the didgits
		String stra=Integer.toString(a);
		String strb=Integer.toString(b);
		String strab=stra+strb;
		String strba=strb+stra;
		int ab=Integer.parseInt(strab);
		int ba=Integer.parseInt(strba);
		if(ab>=ba)
		{
			return 1;
		}
		else
		{
			return -1;
		}
	}
	//using selection sort 
	public void sort(int[] array)
	{
		for(int i=0;i<array.length;i++)
		{
			int max=array[i];
            int pos=i;
			for(int j=i;j<array.length;j++)
			{
				//finding the maximum in the array of i+1 to end and swapping the max with the
				//ith position element
				if(myCompare(max,array[j])==-1)
				{
					max=array[j];
					pos=j;
				}
			}
			int temp=array[i];
			array[i]=array[pos];
			array[pos]=temp;
		}
	}
	public static void main(String args[])
	{
		int[] array={9,54,23,65,76,34,45,28,8};
		BiggestNumberFromArray bgfn=new BiggestNumberFromArray();
		bgfn.sort(array);
		System.out.println("printing the Biggest number");
		for(int i=0;i<array.length;i++)
		{
			System.out.print(array[i]);
		}
	}
}
