package arrays;

public class RedixSort 
{
	public int[] performRedixSort(int[] array)
	{
		//finding the maximum size of the digit
		int inc=0;
		int max=Integer.MIN_VALUE;
		while(inc<array.length)
		{
			if(array[inc]>max)
			{
				max=array[inc];
			}
			inc+=1;
		}
		System.out.println("max value"+max);;
		//a simple way to count no of digits in a number
		int multiplier=0;
        int[] partSortArray=new int[array.length];
		while(max>0)
		{
			multiplier+=1;
			max/=10;
			int[] modArray= new int[array.length];
			inc=0;
//			System.out.println("multiplier"+multiplier);
			//generating the nth digit list based on the  multiplier
			while(inc<array.length)
			{
				modArray[inc]=getDigit(array[inc],multiplier);
//				System.out.println(array[inc]+"working"+modArray[inc]);
				inc+=1;
			}
            int[] countArray=countingSort(modArray);
//            return countArray;
            inc=array.length-1;
            //inverted the order of adding the elements to keep the orginal order in the previos list to same
            // important code
            while(inc>=0)
            {
            	int tempPos=getDigit(array[inc],multiplier);
//            	System.out.println(tempPos);
            	partSortArray[countArray[tempPos]-1]=array[inc];
            	countArray[tempPos]-=1;
            	inc-=1;
            } 
		}
		return partSortArray; 
	}
	public int getDigit(int number,int iterator)
	{
		int temp=-1;
        temp=number%((int)Math.pow(10,iterator));
        iterator-=1;
        temp=temp/((int)Math.pow(10, iterator));
		return temp;
	}
	public int[] countingSort(int[] array)
	{
		int[] countArray=new int[10];//default array is assigned with default values
		int inc=0;
		//calculate the count array with the no of elements in each position
		while(inc<array.length)
		{
			countArray[array[inc]]+=1;
			inc+=1;
		}
		inc=1;
		//gets the list of orginal position list
		while(inc<countArray.length)
		{
			countArray[inc]+=countArray[inc-1];
			inc+=1;
		}
		return countArray;
	}
	public static void main(String args[])
	{		
		RedixSort rs = new RedixSort();
		int[] array1={1,5,33,22,45,67,8,64,23,45,5325};
        for (int j=0;j<array1.length;j++)
		{
			System.out.print(array1[j]+" ");
		}
        System.out.println("\n");
        int[] pairCount=rs.performRedixSort(array1);
        for(int i=0;i<pairCount.length;i++)
        {
            System.out.print(pairCount[i]+" ");
        }
	}
}
