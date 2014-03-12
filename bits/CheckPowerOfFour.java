package bits;

public class CheckPowerOfFour 
{
	public boolean checkPowerOf4(int num)
	{
		int count=0;
		int tempnum=num;
		while(tempnum!=0)
		{
			tempnum=tempnum&(tempnum-1);
			count++;
		}
		if(count!=1)
		{
			return false;
		}
		else
		{
			int zerocount=0;
			int mask=1;
			while((mask&num)==0)
			{
				mask=mask<<1;
				zerocount++;
			}
			if(zerocount>2 && zerocount%2==0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	}
	public static void main(String args[])
	{
		CheckPowerOfFour cpf= new CheckPowerOfFour();
		int num=6;
		boolean condition=cpf.checkPowerOf4(num);
		if(condition)
		{
			System.out.println("this is power of 4");
		}
	}
}
