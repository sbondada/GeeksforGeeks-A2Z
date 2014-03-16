package bits;

public class oddoneout 
{
	public int findMax(int[] array)
	{
		int max=-1;
		for(int temp:array)
		{
			if(temp>max)
			{
				max=temp;
			}
		}
		return max;
	}
	public int getOddOneOut(int[] array)
	{
		int mask=0x0000001;
		int num=0;
		int max=findMax(array);
		int maxbitlength=Integer.toBinaryString(max).length();
		for(int i=0;i<maxbitlength;i++)
		{
			int sum=0;
			for(int tempnum:array)
			{
				if ((tempnum & mask) >0)
				{
					sum++;
				}
			}
			mask=mask<<1; 
			num=num|((sum%3)<<i);
		}
		return num;
	}
	public static void main(String args[])
	{
		int[] array={1,1,2,1,2,2,13,45,13,45,13,45,5};
		oddoneout ado= new oddoneout();
		System.out.println(ado.getOddOneOut(array));
	}
}
