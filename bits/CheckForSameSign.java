package bits;

public class CheckForSameSign 
{
	public  boolean checkForSign(int x,int y)
	{
		if((x^y)<0)
		{
			System.out.println("have different sign"+(x^y));
			return true;
		}
		else
		{
			System.out.println("have same sign");
			return false;
		}
	}
	public static void main(String args[])
	{
		int x=-2;
		int y=-3;
		System.out.println(Integer.toBinaryString(y));
		CheckForSameSign cfss = new CheckForSameSign();
		cfss.checkForSign(x, y);
	}
}
