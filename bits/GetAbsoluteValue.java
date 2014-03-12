package bits;

public class GetAbsoluteValue 
{
	public int getAbsoluteValues(int num)
	{
		int mask=num>>31;
		return ((mask+num)^mask);
	}
	public static void main(String args[])
	{
		GetAbsoluteValue gav= new GetAbsoluteValue();
		int num=-234;
		int absnum=gav.getAbsoluteValues(num);
		System.out.println(absnum);
	}
}
