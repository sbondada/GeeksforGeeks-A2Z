package bits;

public class CheckDivisibility 
{
	public boolean checkDivisibilityBy9(int num)
	{
		if(num==0 || num==9)
		{
			return true;
		}
		if(num<9)
		{
			return false;
		}
		//quite complicated logic
		//floor[num/9] - num%8;
		return checkDivisibilityBy9((num>>3)-(num&7));
	}
	public static void main(String args[])
	{
		int num=99;
		CheckDivisibility cdb= new CheckDivisibility();
		System.out.println(cdb.checkDivisibilityBy9(num));
	}
}
